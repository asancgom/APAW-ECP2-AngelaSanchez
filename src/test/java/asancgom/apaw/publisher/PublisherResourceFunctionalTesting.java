package asancgom.apaw.publisher;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asancgom.apaw.publisher.http.HttpClientService;
import asancgom.apaw.publisher.http.HttpException;
import asancgom.apaw.publisher.http.HttpMethod;
import asancgom.apaw.publisher.http.HttpRequest;
import asancgom.apaw.publisher.http.HttpRequestBuilder;


public class PublisherResourceFunctionalTesting {


	    private void createPublisher() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("publisher").body("2:Segunda publicación:Madrid:10/10/2017").build();
	        new HttpClientService().httpRequest(request);
	    }

	    @Test
	    public void testCreateTheme() {
	        this.createPublisher();
	    }

	    @Test(expected = HttpException.class)
	    public void testCreatePublisherEmpty() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("publisher").body("").build();
	        new HttpClientService().httpRequest(request);
	    }

	    @Test(expected = HttpException.class)
	    public void testCreateWithoutPublisher() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("publisher").build();
	        new HttpClientService().httpRequest(request);
	    }

	    @Test
	    public void testGetPublisher() {
	        this.createPublisher();
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("publisher").path("/{id}")
	                .expandPath("2").build();
	        assertEquals("{\"id\":2,\"title\":\"Segunda publicación\", \"city\":\"Madrid\", \"date\": \"10/10/2017\"}", new HttpClientService().httpRequest(request).getBody());

	    }

	    @Test
	    public void testPublisherList() {
	        this.createPublisher();
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("author/{id}/publisher").expandPath("1").build();
	        assertEquals("[{\"id\":1,\"title\":\"Primera publicación\",\"city\":\"Zaragoza\",\"date\":\"08/10/2010\"}, {\"id\":2,\"title\":\"Segunda publicación\", \"city\":\"Madrid\", \"date\": \"10/10/2017\"}]", new HttpClientService().httpRequest(request).getBody());
	    }

	    @Test
	    public void testPublisherListEmpty() {
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("publisher").path("publisher/{id}/publisher").expandPath("2").build();
	        assertEquals("[]", new HttpClientService().httpRequest(request).getBody());
	    }

	    @Test
	    public void testPublisherDate() {
	        this.createPublisher();
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("publisher/{id}/date").expandPath("2").build();
	        new HttpClientService().httpRequest(request);
	        assertEquals("{\"date\": \"10/10/2017\"}", new HttpClientService().httpRequest(request).getBody());
	    }
	    
	    @Test
	    public void testAuthorPublisherSum() {
	        this.createPublisher();
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("author/{id}/sum").expandPath("1").build();
	        new HttpClientService().httpRequest(request);
	        assertEquals("2", new HttpClientService().httpRequest(request).getBody());
	    }

	    @Test
	    public void testAuthorPublisherSumWithoutPublisher() {
	        this.createPublisher();
	        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("author/{id}/sum").expandPath("2").build();
	        assertEquals("NaN", new HttpClientService().httpRequest(request).getBody());
	    }
	    
	    @Test
	    public void testDeletePublisher() {
	    	HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path("publisher/{id}").expandPath("2").build();
	        new HttpClientService().httpRequest(request);
	        assertEquals("{\"id\":2,\"title\":\"Segunda publicación\", \"city\":\"Madrid\", \"date\": \"10/10/2017\"}", new HttpClientService().httpRequest(request).getBody());

	    }
}
