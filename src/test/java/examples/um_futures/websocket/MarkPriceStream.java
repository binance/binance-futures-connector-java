package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class MarkPriceStream {
    private MarkPriceStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        final int defaultSpeed = 3;
        int streamId1 = client.markPriceStream("BTCUSDT", defaultSpeed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);

        final int acceptedSpeed = 1;
        int streamId2 = client.markPriceStream("BTCUSDT", acceptedSpeed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId2);
    }
}
