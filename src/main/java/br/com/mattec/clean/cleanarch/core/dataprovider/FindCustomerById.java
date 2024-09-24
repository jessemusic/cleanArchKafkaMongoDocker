package br.com.mattec.clean.cleanarch.core.dataprovider;

import br.com.mattec.clean.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);
}
