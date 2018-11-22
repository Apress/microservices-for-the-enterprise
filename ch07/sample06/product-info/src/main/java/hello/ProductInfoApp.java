package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class ProductInfoApp {

  @RequestMapping(value = "/products")
  public String productList(){
    return "Apple iPhone XS Max, Fully Unlocked 6.5 inch, 256 GB - Gold, " +
            "Google Pixel 3 Unlocked GSM/CDMA, Amazon Echo Dot (3rd Gen) - Smart speaker with Alexa";
  }

  public static void main(String[] args) {
    SpringApplication.run(ProductInfoApp.class, args);
  }
}
