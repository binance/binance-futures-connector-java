package examples.cm_futures.websocket;

import com.binance.connector.client.impl.CMWebsocketClientImpl;

public final class MarkPriceAllSymbolsOfPairStream {
    private MarkPriceAllSymbolsOfPairStream() {
    }

    private static final int speed = 3;

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        int streamId1 = client.markPriceAllSymbolsOfPairStream("btcusdt", speed, ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.markPriceAllSymbolsOfPairStream("ethusdt", speed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
