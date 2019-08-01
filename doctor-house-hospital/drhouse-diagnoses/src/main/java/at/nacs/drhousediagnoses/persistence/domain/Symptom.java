package at.nacs.drhousediagnoses.persistence.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;


public class Symptom {
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    @Indexed(unique = true)
    private int ID;
    @JsonFormat(shape = STRING)
    private String Name;
}
