package at.nacs.morse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MorseService {

  private final Map<String, String> morse;

  @Value("${translation.not-supported}")
  private String notSupported;

  public String encode(String letter) {
    String upperCase = letter.toUpperCase();
    return morse.getOrDefault(upperCase, notSupported);
  }
}
