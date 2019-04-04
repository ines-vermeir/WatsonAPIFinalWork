package be.ehb.vermeirines.finalworkapi.controllers;

import be.ehb.vermeirines.finalworkapi.model.User;
import be.ehb.vermeirines.finalworkapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/database")
public class DatabaseController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/init")
    public void initDatabase(){

        userRepository.deleteAll();

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        userRepository.save(admin);

        User home1 = new User();
        home1.setUsername("home1");
        home1.setPassword("home1");
        userRepository.save(home1);

        User lucy = new User();
        lucy.setUsername("lucy");
        lucy.setPassword("Lucy123");
        userRepository.save(lucy);

    }
}
