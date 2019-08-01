package at.nacs.administration.view.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
public class Symptom {
  @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
  private int ID;
  @JsonFormat(shape = STRING)
  private String Name;
}
