package at.nacs.drhousediagnoses.persistence.domain;

import lombok.Data;

@Data
public class Token {
  private String token;
  private int ValidThrough;
}
