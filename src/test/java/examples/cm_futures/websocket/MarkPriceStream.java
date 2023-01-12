package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class MarkPriceStream {
    private MarkPriceStream() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        final int defaultSpeed = 3;
        int streamId1 = client.markPriceStream("btcusd_perp", defaultSpeed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);

        final int acceptedSpeed = 1;
        int streamId2 = client.markPriceStream("ethusd_perp", acceptedSpeed, ((event) -> {
            System.out.println(event);
        }));

        client.closeConnection(streamId2);
    }
}
