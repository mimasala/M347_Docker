package ch.tbz.domain.blueprint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_exercisetype")
public class ExerciseType {
    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String difficulty;
    private String muscle;
    private String equipment;
}
