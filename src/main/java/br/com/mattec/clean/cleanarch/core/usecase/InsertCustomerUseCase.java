package br.com.mattec.clean.cleanarch.core.usecase;

import br.com.mattec.clean.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipCode);
}
