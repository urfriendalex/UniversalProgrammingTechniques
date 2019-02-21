package Participant;

import Message.MessageQueue;
import Message.Request;
import Message.Response;

public final class Service extends Paricipant {

    public Service(MessageQueue queue){
        super(queue);
    }
    public void run(){
        while (true){
            Request request = queue.dequeueRequest();
            if (request != null){
                serviceRequest(request);
            }
            sleep();
        }
    }
    private Response createResponse (Request request) {
        return new Response(request);
    }
    private void serviceRequest(Request request){
        System.out.println("Request: "+ request + "is being processed");
        Response response =  createResponse(request);
        queue.queueMessage(response);
    }

}
