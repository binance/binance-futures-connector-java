package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class AllTickerStream {
    private AllTickerStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.allTickerStream(((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
