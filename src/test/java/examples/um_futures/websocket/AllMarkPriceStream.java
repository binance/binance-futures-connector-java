package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class AllMarkPriceStream {
    private AllMarkPriceStream() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        final int defaultSpeed = 3;
        int streamId1 = client.allMarkPriceStream(defaultSpeed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);

        final int acceptedSpeed = 1;
        int streamId2 = client.allMarkPriceStream(acceptedSpeed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId2);
    }
}
