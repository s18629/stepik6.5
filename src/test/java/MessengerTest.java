import org.junit.jupiter.api.Test;
import stepik65.*;


import static org.mockito.Mockito.*;

class MessengerTest {
    MailServer mailServer = mock(MailServer.class);
    Client client = mock(Client.class);
    TemplateEngine templateEngine = mock(TemplateEngine.class);
    Template template = mock(Template.class);
    Messenger messenger = new Messenger(mailServer, templateEngine);

    @Test
    public void testSendingMessage() {
        when(client.getEmail()).thenReturn("Travolta@gmail.com");
        when(template.getText()).thenReturn("Some text in template");
        when(templateEngine.prepareMessage(template, client)).thenReturn("email");
        messenger.sendMessage(client, template);
        verify(templateEngine).prepareMessage(template, client);
        verify(mailServer).send("Travolta@gmail.com", "email");
    }
}

