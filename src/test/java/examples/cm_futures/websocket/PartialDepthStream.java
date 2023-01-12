package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class PartialDepthStream {
    private PartialDepthStream() {
    }
    private static final int acceptedSpeed = 100;
    private static final int defaultSpeed = 250;
    private static final int levels = 5;

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.partialDepthStream("btcusd_perp", levels, acceptedSpeed, ((event) -> {
            System.out.println(event);
        }));

        client.partialDepthStream("ethusd_perp", levels, defaultSpeed, ((event) -> {
            System.out.println(event);
        }));

        client.closeAllConnections();

    }
}
