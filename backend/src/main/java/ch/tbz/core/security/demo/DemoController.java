package ch.tbz.core.security.demo;

import ch.tbz.core.helpers.UserConverter;
import ch.tbz.core.modl.user.User;
import org.springframework.http.ResponseEntity;
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
