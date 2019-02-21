package Participant;

import Message.MessageQueue;
import Message.Request;
import Message.Response;

public class Requestor extends Paricipant {

    public Requestor(MessageQueue queue){
        super(queue);
    }
    public void run(){
        System.out.println("Running " + this);
        while (true){
            queueRequest();
            boolean responseConsumed = false;
            while (!responseConsumed){
                Response response = queue.dequeueResponse(this);
                if (response != null)
                    consumeRsponse(response);
                    responseConsumed = true;
            }
            sleep();
        }
    }
    public Request createRequest() {
    Request request = new Request(this);
    return  request;
    }
    public void queueRequest(){
    Request request = createRequest();
    queue.queueMessage(request);
    }
    public void consumeRsponse(Response response){
        if (response.getRequestor() == this)
            System.out.println(response.toString() + " consumed");
    }

}
