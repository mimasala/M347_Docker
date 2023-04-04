package ch.tbz.core.modl.set;

import ch.tbz.core.modl.exercise.Exercise;
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

    private int setCount;
    private int repCount;
    private int weight;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}
