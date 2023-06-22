package client;

import responses.Response;

public interface Client {
    Response worker();
    Response exit();
    Response help();

    Response executeScript(String path);
}
