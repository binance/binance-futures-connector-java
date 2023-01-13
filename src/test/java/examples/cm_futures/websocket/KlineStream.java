package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class KlineStream {
    private KlineStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.klineStream("btcusd_perp", "1h", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
