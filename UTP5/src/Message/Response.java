package Message;

public class Response extends Message {

    int sum;

    public Response(Request request){
        super(request.getRequestor(), request.getPriority());
        sum = request.comp1 + request.comp2;
    }


    @Override
    public String toString() {
      return super.toString() + " [" + sum +"]";
    }
}
