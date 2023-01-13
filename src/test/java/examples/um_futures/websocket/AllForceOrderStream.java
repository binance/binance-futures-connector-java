package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class AllForceOrderStream {
    private AllForceOrderStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        client.allForceOrderStream(((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
