package be.ehb.vermeirines.finalworkapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/watson")
public class WatsonCotroller {

    private WatsonConnection watsonConnection;

    @GetMapping("")
    public String makeConnection () {
        watsonConnection = new WatsonConnection();
        return watsonConnection.getSessionID();
    }

    @GetMapping("/input")
    public String processSpeechToTextResult(@RequestParam String sessionID, @RequestParam String input){
        String output = watsonConnection.watsonSend(sessionID,input);

        return output;
    }
}
