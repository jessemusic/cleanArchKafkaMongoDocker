package br.com.mattec.clean.cleanarch.core.usecase.impl;

import br.com.mattec.clean.cleanarch.core.dataprovider.FindAddressByZipCode;
import br.com.mattec.clean.cleanarch.core.dataprovider.UpdateCustomer;
import br.com.mattec.clean.cleanarch.core.domain.Customer;
import br.com.mattec.clean.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.mattec.clean.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {


    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCode findAddressByZipCode,
            UpdateCustomer updateCustomer){
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public void update(Customer customer, String zipCode) {

        findCustomerByIdUseCase.find(customer.getId());
        var adresss = findAddressByZipCode.find(zipCode);
        customer.setAddress(adresss);
        updateCustomer.update(customer);
    }
}
