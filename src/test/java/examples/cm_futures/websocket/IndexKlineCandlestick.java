package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class IndexKlineCandlestick {
    private IndexKlineCandlestick() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        int streamId1 = client.indexKlineCandlestick("btcusd", "1m", ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.indexKlineCandlestick("ethusd", "1m", ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
