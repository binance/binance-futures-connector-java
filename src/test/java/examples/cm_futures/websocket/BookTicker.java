package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class BookTicker {
    private BookTicker() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.bookTicker("btcusd_perp", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
