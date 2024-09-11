package br.com.actionsys.kawhycommons.infra.exception;

//Arquivos ignorado continuaram na pasta de entrada, não serão movidos.
public class StopExecutionException extends RuntimeException {
    public StopExecutionException() {
    }
    public StopExecutionException(String message) {
        super(message);
    }
    public StopExecutionException(String message, Exception e) {
        super(message, e);
    }
    public StopExecutionException(Exception e) {
        super(e);
    }
}
