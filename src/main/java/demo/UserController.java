package demo;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = {"/auth/user/me"})
public class UserController {
    @RequestMapping(path = "/", method = {GET}, produces = {"application/json"})
    public User user(Principal principal) {
        return new User();
    }

}