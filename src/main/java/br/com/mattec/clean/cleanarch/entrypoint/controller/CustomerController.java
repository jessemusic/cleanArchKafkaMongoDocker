package br.com.mattec.clean.cleanarch.entrypoint.controller;


import br.com.mattec.clean.cleanarch.core.dataprovider.DeleteCustomerById;
import br.com.mattec.clean.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import br.com.mattec.clean.cleanarch.core.usecase.FindCustomerByIdUseCase;
import br.com.mattec.clean.cleanarch.core.usecase.InsertCustomerUseCase;
import br.com.mattec.clean.cleanarch.core.usecase.UpdateCustomerUseCase;
import br.com.mattec.clean.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import br.com.mattec.clean.cleanarch.entrypoint.controller.request.CustomerRequest;
import br.com.mattec.clean.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer,customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final String id){
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final String id,@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }


}
