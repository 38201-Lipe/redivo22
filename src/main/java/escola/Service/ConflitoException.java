package escola.service;

// Lançada quando uma regra da escola impede a operação. Vira 409 no tratador de erros.
public class ConflitoException extends RuntimeException {

    public ConflitoException(String mensagem) {
        super(mensagem);
    }
}