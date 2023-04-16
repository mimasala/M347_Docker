package ch.tbz.domain.set;

import ch.tbz.domain.exercise.Exercise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_set")
public class Set {
    @Id
    private Long id;

    private Integer setCount;
    private Integer repCount;
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}
