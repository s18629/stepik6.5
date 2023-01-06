import org.junit.jupiter.api.Test;
import stepik65.Client;
import stepik65.Message;
import stepik66.RaceResultService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RaceResultServiceTestMockito {
    Client client = mock(Client.class);
    RaceResultService raceResultService = new RaceResultService();
    Message message = mock(Message.class);

    @Test
    public void sendMessageTest(){
        raceResultService.addSubscriber(client);
        raceResultService.send(message);
        verify(client).reciveMessage(message);
    }
}