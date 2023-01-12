package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class AllForceOrderStream {
    private AllForceOrderStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.allForceOrderStream(((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
