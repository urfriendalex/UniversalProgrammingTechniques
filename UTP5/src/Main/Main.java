package Main;

import Message.MessageQueue;
import Participant.Requestor;
import Participant.Service;

import java.util.ArrayList;

public class Main {
    public static void main (String args[]){
        MessageQueue q = new MessageQueue();
        ArrayList<Requestor> requestors = new ArrayList<>();
        ArrayList<Service> services = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Requestor requestor = new Requestor(q);
            requestors.add(requestor);
        }
        for (int i = 0; i < 10; i++) {
            Service service = new Service(q);
            services.add(service);
        }

        for (Service service : services) {
            service.start();
        }
        for (Requestor requestor : requestors) {
            requestor.start();
        }
    }
}
