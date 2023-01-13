package examples.cm_futures.websocket;

import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;

public final class SymbolTicker {
    private SymbolTicker() {
    }

    public static void main(String[] args) {
        CMWebsocketClientImpl client = new CMWebsocketClientImpl();
        client.symbolTicker("btcusd_perp", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
        }));
    }
}
