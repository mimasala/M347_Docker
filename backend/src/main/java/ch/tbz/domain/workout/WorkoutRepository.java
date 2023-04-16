package ch.tbz.domain.workout;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Page<Workout> findAllByNameContainingIgnoreCase(String search, Pageable pageable);
}
