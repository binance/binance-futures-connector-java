package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class AllBookTicker {
    private AllBookTicker() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.allBookTickerStream(((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
