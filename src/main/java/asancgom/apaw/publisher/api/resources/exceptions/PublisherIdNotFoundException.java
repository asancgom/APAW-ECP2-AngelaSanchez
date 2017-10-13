package asancgom.apaw.publisher.api.resources.exceptions;

public class PublisherIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El id del tema no existe";

    public PublisherIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public PublisherIdNotFoundException() {
        this("");
    }
}
