package ch.tbz;

import ch.tbz.domain.exercise.ExcerciseDTO;
import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.exercise.ExerciseRepo;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

@Component
public class AppStartRunner implements CommandLineRunner {
    private final ExerciseRepo exerciseRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public AppStartRunner(ExerciseRepo exerciseRepo, ModelMapper modelMapper) {
        this.exerciseRepo = exerciseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        int offset = 0;
        try {
//            while (true) {
//                URL url = new URL("https://api.api-ninjas.com/v1/exercises?offset=" + offset);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestProperty("accept", "application/json");
//                connection.addRequestProperty("X-Api-Key", "nC7RuBqgRN9bss2W4Lom0w==4pbIHmsdENwDz8jm");
//                InputStream responseStream = connection.getInputStream();
//                Gson gson = new Gson();
//                ExcerciseDTO[] exercises = gson.fromJson(new java.io.InputStreamReader(responseStream), ExcerciseDTO[].class);
//                if (exercises.length == 0) {
//                    break;
//                }
//                for (ExcerciseDTO exercise : exercises) {
//                    Exercise e = Exercise.builder()
//                            .name(exercise.name)
//                            .type(exercise.type)
//                            .muscle(exercise.muscle)
//                            .equipment(exercise.equipment)
//                            .difficulty(exercise.difficulty)
//                            .instructions(exercise.instructions)
//                            .build();
//                    System.out.println(e);
//                    exerciseRepo.save(e);
//                }
////                exerciseRepo.saveAll(Arrays.asList(exercises));
//
//                System.out.println(Arrays.asList(exercises));
//                offset += 10;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}