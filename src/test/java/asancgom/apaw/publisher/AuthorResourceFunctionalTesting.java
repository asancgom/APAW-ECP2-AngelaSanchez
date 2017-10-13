package asancgom.apaw.publisher;

import org.junit.Test;


import asancgom.apaw.publisher.http.HttpClientService;
import asancgom.apaw.publisher.http.HttpException;
import asancgom.apaw.publisher.http.HttpMethod;
import asancgom.apaw.publisher.http.HttpRequest;
import asancgom.apaw.publisher.http.HttpRequestBuilder;

public class AuthorResourceFunctionalTesting {


	    @Test(expected = HttpException.class)
	    public void testAuthorPublisherSumPublisherIdNotFound() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("author/{id}/sum").expandPath("3").build();
	        new HttpClientService().httpRequest(request);
	    }
}
