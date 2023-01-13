package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class ContinuousKlineStream {
    private ContinuousKlineStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();

        client.continuousKlineStream("btcusdt", "perpetual", "1m", ((event) -> {
            System.out.println(event);
        }));

        client.closeAllConnections();
    }
}
