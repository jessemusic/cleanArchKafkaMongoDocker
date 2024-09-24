package br.com.mattec.clean.cleanarch.core.usecase.impl;

import br.com.mattec.clean.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.mattec.clean.cleanarch.core.dataprovider.InsertCustomer;
import br.com.mattec.clean.cleanarch.core.dataprovider.SendCpdForValidation;
import br.com.mattec.clean.cleanarch.core.domain.Address;
import br.com.mattec.clean.cleanarch.core.domain.Customer;
import br.com.mattec.clean.cleanarch.core.usecase.InsertCustomerUseCase;
import br.com.mattec.clean.cleanarch.exceptions.CepNotFoundException;
import br.com.mattec.clean.cleanarch.exceptions.RefusedConnectionException;
import br.com.mattec.clean.cleanarch.util.Messages;
import lombok.SneakyThrows;

public class insertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;

    private final InsertCustomer insertCustomer;

    private final SendCpdForValidation sendCpdForValidation;


    public insertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer,
            SendCpdForValidation sendCpdForValidation){
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpdForValidation = sendCpdForValidation;
    }

    @Override
    @SneakyThrows
    public void insert(Customer customer, String zipCode) {
        Address address = null;
        try {
            address = this.findAddressByZipCode.find(zipCode);
        } catch (RuntimeException ex) {
            if(ex.getMessage().contains(Messages.CONNECTION_REFUSED)){
                throw new RefusedConnectionException(Messages.ERRO_CONEXAO_API_ADDRESS + ex.getMessage());
            }
            throw new CepNotFoundException(Messages.ERRO_ZIPCODE_NAO_ENCONTRADO + zipCode);
        }
        customer.setAddress(address);
        insertCustomer.insert(customer);
        sendCpdForValidation.send(customer.getCpf());
    }
}
