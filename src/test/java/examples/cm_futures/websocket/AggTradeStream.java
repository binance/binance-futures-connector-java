package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class AggTradeStream {
    private AggTradeStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        int streamId1 = client.aggTradeStream("btcusd_perp", ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.aggTradeStream("ethusd_perp", ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
