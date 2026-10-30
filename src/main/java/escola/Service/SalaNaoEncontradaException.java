package escola.service;

// Lançada quando o id pedido não existe. Vira 404 no tratador de erros.
public class SalaNaoEncontradaException extends RuntimeException {

    public SalaNaoEncontradaException(Long id) {
        super("Sala não encontrada: id " + id);
    }
}