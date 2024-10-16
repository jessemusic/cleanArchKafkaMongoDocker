package br.com.mattec.clean.cleanarch.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String numeroendereco;

    @NotBlank
    private String zipCode;


}
