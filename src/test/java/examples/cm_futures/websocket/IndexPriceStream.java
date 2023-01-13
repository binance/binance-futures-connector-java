package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class IndexPriceStream {
    private IndexPriceStream() {
    }

    private static final int speed = 3;

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        int streamId1 = client.indexPriceStream("btcusd", speed, ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.indexPriceStream("ethusd", speed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
