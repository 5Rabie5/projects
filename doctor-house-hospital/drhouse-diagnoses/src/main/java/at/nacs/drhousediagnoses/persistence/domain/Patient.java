package at.nacs.drhousediagnoses.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
}
