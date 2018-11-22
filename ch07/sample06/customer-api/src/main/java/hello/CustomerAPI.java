package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class CustomerAPI {

  private final RestTemplate restTemplate;

  public CustomerAPI(RestTemplate rest) {
    this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "getCachedProducts")
  public String getProducts() {
    URI uri = URI.create("http://localhost:8090/products");

    return this.restTemplate.getForObject(uri, String.class);
  }

  public String getCachedProducts() {
    return "[Cached] Microservices for the Enterprise: Designing, Developing, and Deploying Paperback";
  }

}
