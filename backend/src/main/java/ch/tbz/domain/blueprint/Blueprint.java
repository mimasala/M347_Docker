package ch.tbz.domain.blueprint;

import ch.tbz.domain.user.User;
import ch.tbz.domain.workout.Workout;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_blueprint")
public class Blueprint {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int exerciseCount;

    @OneToMany
    private List<Workout> generated;

    @OneToMany
    private List<ExerciseType> types;

    public void addGenerated(Workout w){
        generated.add(w);
    }
}
