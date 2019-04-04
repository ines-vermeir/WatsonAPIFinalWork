package be.ehb.vermeirines.finalworkapi.controllers;

import be.ehb.vermeirines.finalworkapi.model.LoginForm;
import be.ehb.vermeirines.finalworkapi.model.User;
import be.ehb.vermeirines.finalworkapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    @ResponseBody
    public Long login (@RequestBody LoginForm loginForm) {
        User user = userRepository.findUserByUsernameEqualsAndPasswordEquals(loginForm.getUsername(), loginForm.getPassword());
        if(user == null){
            return null;
        }
        return user.getId();
    }

}
