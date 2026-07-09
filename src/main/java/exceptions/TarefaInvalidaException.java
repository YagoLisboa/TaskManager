package exceptions;

// Herdando de Exception (Checked Exception), o que obriga o tratamento com try/catch
public class TarefaInvalidaException extends Exception {
    
    // Construtor que recebe a mensagem personalizada de erro
    public TarefaInvalidaException(String mensagem) {
        super(mensagem);
    }
}