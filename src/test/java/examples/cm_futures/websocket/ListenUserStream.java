package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class ListenUserStream {
    private ListenUserStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.listenUserStream("abc123", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
