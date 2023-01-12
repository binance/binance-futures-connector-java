package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class ContinuousKlineStream {
    private ContinuousKlineStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();

        client.continuousKlineStream("btcusd", "next_quarter", "1m", ((event) -> {
            System.out.println(event);
        }));

        client.closeAllConnections();
    }
}
