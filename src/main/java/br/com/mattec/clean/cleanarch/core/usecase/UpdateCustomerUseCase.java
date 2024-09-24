package br.com.mattec.clean.cleanarch.core.usecase;

import br.com.mattec.clean.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
    void update(Customer customer, String zipCode);
}
