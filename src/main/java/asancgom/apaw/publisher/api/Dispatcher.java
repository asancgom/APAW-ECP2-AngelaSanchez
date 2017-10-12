package asancgom.apaw.publisher.api;

//import asancgom.apaw.publisher.api.resources.PublisherResource;
//import asancgom.apaw.publisher.api.resources.RequestInvalidException;
//import asancgom.apaw.publisher.api.resources.AuthorResource;
import asancgom.apaw.publisher.http.HttpRequest;
import asancgom.apaw.publisher.http.HttpResponse;
import asancgom.apaw.publisher.http.HttpStatus;

public class Dispatcher {

    //private PublisherResource publisherResource = new PublisherResource();

    //private AuthorResource authorResource = new AuthorResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
       //  responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        // responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
       // responseError(response, new RequestInvalidException(request.getPath()));
    }

}
