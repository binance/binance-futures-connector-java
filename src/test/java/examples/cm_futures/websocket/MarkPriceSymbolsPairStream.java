package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class MarkPriceSymbolsPairStream {
    private MarkPriceSymbolsPairStream() {
    }

    private static final int defaultSpeed = 3;
    private static final int speed = 1;
    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        int streamId1 = client.markPriceSymbolsPairStream("btcusd", defaultSpeed, ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.markPriceSymbolsPairStream("ethusd", speed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
