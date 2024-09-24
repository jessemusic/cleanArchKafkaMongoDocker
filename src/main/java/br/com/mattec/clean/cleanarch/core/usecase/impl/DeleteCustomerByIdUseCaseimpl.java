package br.com.mattec.clean.cleanarch.core.usecase.impl;

import br.com.mattec.clean.cleanarch.core.dataprovider.DeleteCustomerById;
import br.com.mattec.clean.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import br.com.mattec.clean.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseimpl implements DeleteCustomerByIdUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseimpl(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerById deleteCustomerById
    ){
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomerById = deleteCustomerById;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdUseCase.find(id);
        deleteCustomerById.delete(id);
    }
}
