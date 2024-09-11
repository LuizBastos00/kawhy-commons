package br.com.actionsys.kawhycommons.infra.exception;

//Arquivos ignorado continuaram na pasta de entrada, não serão movidos.
public class IgnoreFileException extends RuntimeException {
    public IgnoreFileException() {
    }
    public IgnoreFileException(String message) {
        super(message);
    }
    public IgnoreFileException(String message, Exception e) {
        super(message, e);
    }
    public IgnoreFileException(Exception e) {
        super(e);
    }
}
