package ch.tbz.domain.workout;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.set.Set;
import ch.tbz.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_workout")
public class Workout {

    public Workout(Blueprint b, User u){
        this.blueprint = b;
        this.user = u;
    }

    @Id
    private int id;

    private Rating rating;
    private boolean active = true;
    private LocalDateTime finishedAt;

    @OneToMany
    private List<Set> sets;

    @ManyToOne
    @JoinColumn(name = "blueprint_id")
    private Blueprint blueprint;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void finish(){
        active = false;
        finishedAt = LocalDateTime.now();
    }
}
