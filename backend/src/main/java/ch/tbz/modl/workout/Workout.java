package ch.tbz.modl.workout;

import ch.tbz.modl.blueprint.Blueprint;
import ch.tbz.modl.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    private boolean active = true;

    private LocalDateTime finishedAt;

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
