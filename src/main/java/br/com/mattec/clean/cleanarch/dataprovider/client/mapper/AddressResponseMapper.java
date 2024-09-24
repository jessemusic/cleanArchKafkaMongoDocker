package br.com.mattec.clean.cleanarch.dataprovider.client.mapper;

import br.com.mattec.clean.cleanarch.core.domain.Address;
import br.com.mattec.clean.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
