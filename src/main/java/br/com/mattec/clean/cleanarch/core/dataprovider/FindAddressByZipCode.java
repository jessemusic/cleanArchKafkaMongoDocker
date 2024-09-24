package br.com.mattec.clean.cleanarch.core.dataprovider;

import br.com.mattec.clean.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);
}
