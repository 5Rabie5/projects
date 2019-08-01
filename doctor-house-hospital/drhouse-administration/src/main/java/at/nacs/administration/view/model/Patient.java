package at.nacs.administration.view.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

  @NotEmpty
  private String name;
  @NotEmpty
  private String symptoms;
}
