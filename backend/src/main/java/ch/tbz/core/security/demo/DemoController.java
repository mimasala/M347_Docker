package ch.tbz.core.security.demo;

import ch.tbz.helpers.UserConverter;
import ch.tbz.modl.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

  @GetMapping
  public ResponseEntity<String> sayHello(Principal p) {
    User u = UserConverter.convert(p);
    return ResponseEntity.ok("Hello from secured endpoint" + u.getFirstname());
  }

}
