package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncoderEndpoint {

  private final Encoder encoder;

  @PostMapping
  String encode(@RequestBody String text) {
    return encoder.encode(text);
  }

}
