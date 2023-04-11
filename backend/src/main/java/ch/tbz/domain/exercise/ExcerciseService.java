package ch.tbz.domain.exercise;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcerciseService {
    private final ExcerciseRepository excerciseRepository;

    public ExcerciseService(ExcerciseRepository excerciseRepository) {
        this.excerciseRepository = excerciseRepository;
    }

    public List<Exercise> getExercises() {
        return excerciseRepository.findAll();
    }
}
