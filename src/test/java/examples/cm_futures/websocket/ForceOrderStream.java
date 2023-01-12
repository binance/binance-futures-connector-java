package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class ForceOrderStream {
    private ForceOrderStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        client.forceOrderStream("btcusd_perp", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
