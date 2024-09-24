package br.com.mattec.clean.cleanarch.config;

import br.com.mattec.clean.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.mattec.clean.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import br.com.mattec.clean.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import br.com.mattec.clean.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            FindAddressByZipCodeImpl findAddressByZipCode,
            UpdateCustomerImpl updateCustomer
    ){
        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase,findAddressByZipCode,updateCustomer);
    }
}
