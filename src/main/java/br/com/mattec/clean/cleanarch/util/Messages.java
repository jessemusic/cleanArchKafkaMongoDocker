package br.com.mattec.clean.cleanarch.util;

public class Messages {

    public static final String ERRO_ZIPCODE_NAO_ENCONTRADO = "Erro:CEP não encontrado na base com zipCode: .";
    public static final String ERRO_CONEXAO_API_ADDRESS = "Erro: Não foi possivel estabelecer as conexão com a API de endereços!! ";
    public static final String ERRO_CONNECTION_REFUSED = "Connection refused";

    public static final String SUCESSO_CADASTRO = "Sucesso: Usuário cadastrado com sucesso.";
    public static final String SUCESSO_ATUALIZACAO = "Sucesso: Dados atualizados com sucesso.";

    public static final String LOG_INICIANDO_PROCESSO = "Iniciando o processo...";
    public static final String LOG_FINALIZANDO_PROCESSO = "Processo finalizado com sucesso.";

    private Messages() {
        throw new UnsupportedOperationException("Esta classe não pode ser instanciada.");
    }
}
