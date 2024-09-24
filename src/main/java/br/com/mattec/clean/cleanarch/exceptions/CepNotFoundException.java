package br.com.mattec.clean.cleanarch.exceptions;

public class CepNotFoundException  extends RuntimeException{

    public CepNotFoundException(String message){
        super(message);
    }
}
