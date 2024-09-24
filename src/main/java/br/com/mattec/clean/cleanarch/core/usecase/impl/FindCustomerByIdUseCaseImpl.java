package br.com.mattec.clean.cleanarch.core.usecase.impl;

import br.com.mattec.clean.cleanarch.core.dataprovider.FindCustomerById;
import br.com.mattec.clean.cleanarch.core.domain.Customer;
import br.com.mattec.clean.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {


    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById){
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {
        return findCustomerById.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));
    }
}
