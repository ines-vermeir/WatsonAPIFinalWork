package be.ehb.vermeirines.finalworkapi.controllers;

import be.ehb.vermeirines.finalworkapi.Exception.UnauthorizedException;
import be.ehb.vermeirines.finalworkapi.Service.TokenService;
import be.ehb.vermeirines.finalworkapi.WatsonConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/watson")
public class WatsonCotroller {

    private WatsonConnection watsonConnection;
    @Autowired
    private TokenService tokenService;


    @GetMapping("")
    @ResponseBody
    public String makeConnection (@RequestHeader String authToken) {
        if(!tokenService.isTokenValid(authToken)){
            throw new UnauthorizedException();
        }
        watsonConnection = new WatsonConnection();
        return watsonConnection.getSessionID();
    }

    @GetMapping("/input")
    @ResponseBody
    public String processSpeechToTextResult(@RequestHeader String authToken,@RequestParam String sessionID, @RequestParam String input){
        if(!tokenService.isTokenValid(authToken)){
            throw new UnauthorizedException();
        }
        String output = watsonConnection.watsonSend(sessionID,input);
        return output;
    }


}
