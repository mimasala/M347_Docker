package ch.tbz;

import ch.tbz.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppStartRunner implements CommandLineRunner {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
