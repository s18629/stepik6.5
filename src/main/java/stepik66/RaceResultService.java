package stepik66;

import stepik65.Client;
import stepik65.Message;

import java.util.HashSet;
import java.util.*;

public class RaceResultService {
    private Collection<Client> clients = new HashSet<Client>();

    public void addSubscriber(Client client){
        clients.add(client);
    }

    public void send(Message message){
        for (Client client: clients){
            client.reciveMessage(message);
        }
    }

    public void removeSubscriber(Client client){
        clients.remove(client);
    }
}
