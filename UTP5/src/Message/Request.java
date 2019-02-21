package Message;

import Enums.MessagePriority;
import Participant.Requestor;


public class Request extends Message {

    int comp1;
    int comp2;

    public Request(Requestor requestor) {
        super(requestor, MessagePriority.random());
        comp1 =(int)( Math.random()*1500);
        comp2 =(int)( Math.random()*1500);
    }
    @Override
    public String toString() {
        return super.toString() + " ( " + comp1 + " , " + comp2 + " )";
    }
}

