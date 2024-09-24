package br.com.mattec.clean.cleanarch.config;

import br.com.mattec.clean.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseimpl;
import br.com.mattec.clean.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.mattec.clean.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseimpl deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            DeleteCustomerByIdImpl deleteCustomerById
    ){
        return new DeleteCustomerByIdUseCaseimpl(findCustomerByIdUseCase,deleteCustomerById);
    }
}
