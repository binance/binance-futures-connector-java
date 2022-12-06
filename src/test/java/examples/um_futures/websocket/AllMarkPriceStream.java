package examples.um_futures.websocket;

import com.binance.connector.client.impl.UMWebsocketClientImpl;

public final class AllMarkPriceStream {
    private AllMarkPriceStream() {
    }

    private static final int speed = 3;

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        int streamId1 = client.allMarkPriceStream(speed, ((event) -> {
            System.out.println(event);
        }));
        int streamId2 = client.allMarkPriceStream(speed, ((event) -> {
            System.out.println(event);
        }));
        client.closeConnection(streamId1);
        client.closeConnection(streamId2);
    }
}
