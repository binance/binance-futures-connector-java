package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class PartialDepthStream {
    private PartialDepthStream() {
    }
    private static final int speed = 100;
    private static final int defaultSpeed = 250;
    private static final int levels = 5;

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();

        client.partialDepthStream("btcusdt", levels, speed, ((event) -> {
            System.out.println(event);
        }));

        client.partialDepthStream("ethusdt", levels, defaultSpeed, ((event) -> {
            System.out.println(event);
        }));

        client.closeAllConnections();
    }
}
