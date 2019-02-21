package Message;

import Enums.MessagePriority;
import Participant.Requestor;

public abstract class Message implements Comparable<Message> {

    private static int currID = 0;

    private static int getCurrID(){
        return currID++;
    }
    private final int id;


    private Requestor requestor;
    private MessagePriority priority;

    public Message(Requestor requestor, MessagePriority pr){
        this.requestor = requestor;
        id = getCurrID();
       priority= pr;

    }

    public Requestor getRequestor() {
        return requestor;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Message newMess) {
        if(priority!= newMess.getPriority()) {
            return priority.compareTo(newMess.getPriority());
        }
        else return id!=newMess.getId()?1:0;
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + getId() +")";
    }
}
