package br.com.mattec.clean.cleanarch.dataprovider.client.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
