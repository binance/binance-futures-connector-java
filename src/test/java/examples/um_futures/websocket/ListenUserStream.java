package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class ListenUserStream {
    private ListenUserStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        client.listenUserStream("abc123", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
