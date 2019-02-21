package Message;

import Participant.Requestor;

import java.util.PriorityQueue;
import java.util.Queue;

public class MessageQueue {

    private final Queue<Message> priorityQueue;

    public MessageQueue() {
        priorityQueue = new PriorityQueue<Message>();
    }

    public synchronized void queueMessage(Message message){
        priorityQueue.offer(message);
    }

    public synchronized Request dequeueRequest() {
        try {
            Request request = null;
            Message message = priorityQueue.peek();
            if (message instanceof  Request) {
                request = (Request) priorityQueue.poll();
            }
            return request;
        }catch (Throwable ex){
            throw new SecurityException(ex);
        }
    }

    public synchronized Response dequeueResponse(Requestor requestor) {
        Response response = null;
        Message message = priorityQueue.peek();
        if (message instanceof Response && message.getRequestor() == requestor)
        {
            response = (Response) priorityQueue.poll();
        }
        return response;
    }

}

