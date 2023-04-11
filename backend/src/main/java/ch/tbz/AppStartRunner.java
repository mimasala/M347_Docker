package ch.tbz;

import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.exercise.ExerciseRepo;
import ch.tbz.domain.user.UserRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class AppStartRunner implements CommandLineRunner {
    @Autowired
    private final ExerciseRepo exerciseRepo;

    @Override
    public void run(String... args) throws Exception {
        int offset = 0;
        try {
            while (true){
                URL url = new URL("https://api.api-ninjas.com/v1/exercises?offset=" + offset);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("accept", "application/json");
                connection.addRequestProperty("X-Api-Key", "nC7RuBqgRN9bss2W4Lom0w==4pbIHmsdENwDz8jm");
                InputStream responseStream = connection.getInputStream();
                Gson gson = new Gson();
                Exercise[] exercises = gson.fromJson(new java.io.InputStreamReader(responseStream), Exercise[].class);
                if (exercises.length == 0){
                    break;
                }
//                exerciseRepo.saveAll(Arrays.asList(exercises));
                System.out.println(Arrays.asList(exercises));
                offset += 10;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
