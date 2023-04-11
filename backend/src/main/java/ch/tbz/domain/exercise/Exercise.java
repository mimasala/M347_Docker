package ch.tbz.domain.exercise;

import ch.tbz.domain.set.Set;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String muscle;
    private String equipment;
    private String difficulty;
    @Column(columnDefinition = "TEXT")
    private String instructions;

    @OneToMany
    private List<Set> refSets;

}
