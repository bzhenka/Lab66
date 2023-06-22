package client.commands;


import client.Client;
import client.network.NetworkClient;

import java.io.Serializable;
public abstract class AbstractCommand implements Command, Serializable {

    final transient Client client;
    final transient NetworkClient networkClient;
    final String name;

    public AbstractCommand(String name, Client client, NetworkClient networkClient) {
        this.name = name;
        this.client = client;
        this.networkClient = networkClient;
    }

        @Override
        public String toString () {
            return name;
        }

        public String getName () {
            return name;
        }
}