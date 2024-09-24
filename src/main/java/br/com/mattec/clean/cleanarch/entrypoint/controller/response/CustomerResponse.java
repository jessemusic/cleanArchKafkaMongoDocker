package br.com.mattec.clean.cleanarch.entrypoint.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String nome;

    private String cpf;

    private Boolean isValidCpof;

    private AddressResponse address;
}
