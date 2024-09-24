package br.com.mattec.clean.cleanarch.entrypoint.consumer.mapper;

import br.com.mattec.clean.cleanarch.core.domain.Customer;
import br.com.mattec.clean.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address",ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
