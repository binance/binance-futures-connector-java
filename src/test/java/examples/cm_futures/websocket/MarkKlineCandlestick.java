package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class MarkKlineCandlestick {
    private MarkKlineCandlestick() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        int streamId1 = client.markKlineCandlestick("btcusd_perp", "1m", ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.markKlineCandlestick("ethusd_perp", "3m", ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
