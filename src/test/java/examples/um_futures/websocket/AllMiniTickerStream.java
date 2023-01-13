package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class AllMiniTickerStream {
    private AllMiniTickerStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        client.allMiniTickerStream(((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
