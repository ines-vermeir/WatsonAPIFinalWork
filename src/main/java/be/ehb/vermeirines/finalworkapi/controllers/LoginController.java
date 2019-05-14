package be.ehb.vermeirines.finalworkapi.controllers;

import be.ehb.vermeirines.finalworkapi.Exception.UnauthorizedException;
import be.ehb.vermeirines.finalworkapi.Service.TokenService;
import be.ehb.vermeirines.finalworkapi.model.LoginForm;
import be.ehb.vermeirines.finalworkapi.model.Resident;
import be.ehb.vermeirines.finalworkapi.model.ResidentialCareCenter;
import be.ehb.vermeirines.finalworkapi.repositories.RccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RccRepository rccRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("")
    @ResponseBody
    public Resident login (@RequestHeader String authToken, @RequestBody LoginForm loginForm) {
        if(!tokenService.isTokenValid(authToken)){
            throw new UnauthorizedException();
        }
        ResidentialCareCenter rcc = rccRepository.findResidentialCareCenterByUsernameEqualsAndPasswordEquals(loginForm.getUsername(), loginForm.getPassword());
        if(rcc == null){
            return null;
        }
        for(Resident resident : rcc.getResidents()){
            if(resident.getRoomNumber().equals(loginForm.getRoomNumber())){
                return resident;
            }
        }
        return null;
    }

    @GetMapping("/token")
    @ResponseBody
    public String getToken(@RequestParam String clientId, @RequestParam String clientSecret){
        return tokenService.getToken(clientId, clientSecret);
    }

}
