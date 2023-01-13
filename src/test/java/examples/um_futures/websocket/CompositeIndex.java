package examples.um_futures.websocket;

import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;

public final class CompositeIndex {
    private CompositeIndex() {
    }

    public static void main(String[] args) {
        UMWebsocketClientImpl client = new UMWebsocketClientImpl();
        client.compositeIndexSymbolInfo("DEFIUSDT", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
