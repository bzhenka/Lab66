package client;

import responses.Response;

public interface Client {
    void worker();
    Response exit();
    Response help();

    Response executeScript(String path);
}
