package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class DiffDepthStream {
    private DiffDepthStream() {
    }
    private static final int speed = 100;

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.diffDepthStream("btcusd_perp", speed, ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
