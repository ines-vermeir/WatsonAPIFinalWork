package be.ehb.vermeirines.finalworkapi.Service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    private static String clientid = "javaAPI";
    private static String clientsecret = "password2019";
    private static String authToken = null;

    public TokenService(){
        this.authToken = UUID.randomUUID().toString();
    }

    public String getToken(String clientid, String clientsecret){
        if(clientid.equals(this.clientid) && clientsecret.equals(this.clientsecret)){
            return this.authToken;
        }
        return null;
    }

    public boolean isTokenValid(String authToken){
        if(this.authToken != null && authToken.equals(this.authToken)){
            return true;
        }
        return false;
    }
}
