package be.ehb.vermeirines.finalworkapi;
import com.ibm.watson.developer_cloud.assistant.v2.Assistant;
import com.ibm.watson.developer_cloud.assistant.v2.model.*;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.service.exception.RequestTooLargeException;
import com.ibm.watson.developer_cloud.service.exception.ServiceResponseException;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class WatsonConnection {

    private Assistant assistant;
    private String sessionID;
    private String assistantID;

    public WatsonConnection() {
        try {
            if(assistant == null) {
                IamOptions options = new IamOptions.Builder()
                        .apiKey("Rwdyc3jrMPi1QCVZPzDuPfi21hgoJDaCs26HrAYVsp2s")
                        .build();
                assistant = new Assistant("2019-02-26", options);
                assistant.setEndPoint("https://gateway-lon.watsonplatform.net/assistant/api");
            }
        assistantID = "446db265-4c81-4cae-8291-41ca1ed8d972";
        CreateSessionOptions optionsSession = new CreateSessionOptions.Builder(assistantID).build();
        SessionResponse response = assistant.createSession(optionsSession).execute();
        sessionID = response.getSessionId();

        System.out.println(response);
        } catch (NotFoundException e) {

            // Handle Not Found (404) exception
        } catch (RequestTooLargeException e) {

            // Handle Request Too Large (413) exception
        } catch (ServiceResponseException e) {

            // Base class for all exceptions caused by error responses from the service
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        }
    }

    public String watsonSend(String sessionID, String speechInput){
        try {
            MessageInput input = new MessageInput.Builder()
                    .messageType("text")
                    .text(speechInput)
                    .build();

            MessageOptions options = new MessageOptions.Builder(assistantID, sessionID)
                    .input(input)
                    .build();

            MessageResponse response = assistant.message(options).execute();

            return response.toString();
        } catch (NotFoundException e) {

            // Handle Not Found (404) exception
        } catch (RequestTooLargeException e) {

            // Handle Request Too Large (413) exception
        } catch (ServiceResponseException e) {

            // Base class for all exceptions caused by error responses from the service
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        }
        return null;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(String assistantID) {
        this.assistantID = assistantID;
    }
}
