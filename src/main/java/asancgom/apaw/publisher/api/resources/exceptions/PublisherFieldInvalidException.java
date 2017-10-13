package asancgom.apaw.publisher.api.resources.exceptions;

public class PublisherFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre del tema no encontrado";

    public PublisherFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public PublisherFieldInvalidException() {
        this("");
    }

}
