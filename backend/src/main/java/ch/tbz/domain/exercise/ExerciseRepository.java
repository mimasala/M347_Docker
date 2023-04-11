package ch.tbz.domain.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query(value = """
      select e from Exercise e
      where e.difficulty = :difficulty
      and e.equipment = :equipment
      and e.type = :type
      and e.muscle = :muscle
      """)
    List<Exercise> GetExercisesByType(
            String difficulty,
            String equipment,
            String type,
            String muscle
    );

}
