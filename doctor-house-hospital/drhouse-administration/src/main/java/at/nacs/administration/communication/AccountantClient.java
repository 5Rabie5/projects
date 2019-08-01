package at.nacs.administration.communication;

import at.nacs.administration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountantClient {
  private final RestTemplate restTemplate;
  @Value("${accountant.server.url}")
  private String url;

  public Invoice[] getAll() {
    return restTemplate.getForObject(url, Invoice[].class);
  }

  public void post(Long id) {
    String urlPut = url + "/" + id + "/paid";
    restTemplate.put(urlPut, void.class);
  }
}
