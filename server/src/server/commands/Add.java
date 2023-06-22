package server.commands;
import requests.AddRequest;
import requests.Request;
import responses.AddResponse;
import responses.Response;
import server.Receiver;

public class Add extends AbstractCommand{

//

    public Add(Receiver receiver, String[] movieArguments) {
        super("add", receiver);
    }


    @Override
    public Response execute(Request request) {
        AddRequest addRequest = (AddRequest) request;
        AddResponse response;
        receiver.add(addRequest.movieArguments);
        return new AddResponse(null);
    }
}
