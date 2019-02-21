package Participant;

import Message.MessageQueue;

public abstract class Paricipant extends Thread {
    private static  final  int SLEEP_TIME = 2000; //for convenience

    private static int currID = 0;

    private static int getCurrID(){
        return currID++;
    }
    private final int id;
    protected final MessageQueue queue;

    protected Paricipant(MessageQueue messageQueue){
        id = getCurrID();
        queue =messageQueue;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + getId() + ")";
    }



    void sleep(){
        try {
            sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
