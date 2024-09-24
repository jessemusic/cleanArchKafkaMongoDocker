package br.com.mattec.clean.cleanarch.config;

import br.com.mattec.clean.cleanarch.core.usecase.impl.insertCustomerUseCaseImpl;
import br.com.mattec.clean.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.mattec.clean.cleanarch.dataprovider.InsertCustomerImpl;
import br.com.mattec.clean.cleanarch.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public insertCustomerUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCodeImpl findAddressByZipCode,
            InsertCustomerImpl insertCustomer,
            SendCpfForValidationImpl SendCpfForValidation
    ){
        return new insertCustomerUseCaseImpl(findAddressByZipCode,insertCustomer,SendCpfForValidation);
    }
}
