package ch.tbz.modl.blueprint;

import ch.tbz.modl.user.User;
import ch.tbz.modl.workout.Workout;
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
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "blueprint")
    private List<Workout> generated;

    public void addGenerated(Workout w){
        generated.add(w);
    }
}
