package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

@Service
@RequiredArgsConstructor
public class Encoder {

  private final MorseClient morseClient;
  
  public String encode(String text) {
    String[] letters = text.split("");
    return Stream.of(letters)
                 .map(morseClient::encode)
                 .collect(joining());
  }
}
