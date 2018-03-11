import java.net.URI;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) {

        System.out.println("main started.");
        
        try {
            // open websocket
            URI uri = new URI("wss://echo.websocket.org");
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(uri);

            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });

            // send message to websocket
            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");

            // wait 5 seconds for messages from websocket
            Thread.sleep(5000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }
}