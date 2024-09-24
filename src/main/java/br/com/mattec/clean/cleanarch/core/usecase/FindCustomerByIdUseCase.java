package br.com.mattec.clean.cleanarch.core.usecase;

import br.com.mattec.clean.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
