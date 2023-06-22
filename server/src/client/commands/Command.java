package client.commands;

import requests.Request;
import responses.Response;




public interface Command {
    Response execute(Request request);
}
