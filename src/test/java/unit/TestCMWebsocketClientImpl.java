package unit;
import com.binance.connector.futures.client.impl.CMWebsocketClientImpl;
import com.binance.connector.futures.client.utils.WebSocketCallback;
import static org.junit.Assert.*;
import com.binance.connector.futures.client.utils.WebSocketConnection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class TestCMWebsocketClientImpl extends CMWebsocketClientImpl {
    @Override
    public int indexPriceStream(String pair, int speed, WebSocketCallback onMessageCallback) {
        return super.indexPriceStream(pair, speed, onMessageCallback);
    }

    @Override
    public int markPriceSymbolsPairStream(String pair, int speed, WebSocketCallback onMessageCallback) {
        return super.markPriceSymbolsPairStream(pair, speed, onMessageCallback);
    }

    @Override
    public void closeAllConnections() {
        super.closeAllConnections();
    }

    @Override
    public void closeConnection(int connectionId) {
        super.closeConnection(connectionId);
    }

    @Override
    public int indexKlineCandlestick(String pair, String interval, WebSocketCallback onMessageCallback) {
        return super.indexKlineCandlestick(pair, interval, onMessageCallback);
    }

    @Override
    public int markKlineCandlestick(String symbol, String interval, WebSocketCallback onMessageCallback) {
        return super.markKlineCandlestick(symbol, interval, onMessageCallback);
    }

    @Override
    public Map<Integer, WebSocketConnection> getConnections() {
        return super.getConnections();
    }



    WebSocketCallback mockObj = new WebSocketCallback() {
        @Override
        public void onReceive(String data) {

        }
    };

    int connectionId = indexPriceStream("BTCUSDT", 1,mockObj);
    int connectionIdForDefaultSpeed = indexPriceStream("BTCUSDT", 3,mockObj);

    ArrayList<Integer> checkConnectionList = new ArrayList<>(Arrays.asList(indexKlineCandlestick("BTCUSDT", "1",mockObj),markKlineCandlestick("BTCUSDT", "1",mockObj)));

    public void getCheckConnectionList(ArrayList<Integer> checkConnectionList) {
        this.checkConnectionList = checkConnectionList;
//        checkConnectionList.add(Arrays.asList())
    }

    @Test

    public void checkIndexPrice(){
        assertNotNull(connectionId); // checking for the if statement when the speed is high 1000ms.
        assertNotNull(connectionIdForDefaultSpeed); // checking for the if statement when the speed = default speed.
        assertNotEquals(connectionId, indexPriceStream("BTCUSDT", 1,mockObj)); // checking wether the function is returning the new connection id or not.
        // because after getting called this many times in one runtime it should create new connection id and not overwrite the existing one.
    }

    @Test
    public void checkPriceSymbolPairStream(){
        assertNotNull(markPriceSymbolsPairStream("BTCUSDT", 1, mockObj)); // checking wether when this method is hit is it really returning the connection id or not.
    }

    @Test
    public void checkConnectionCloseById(){
        closeConnection(connectionId);
        assertTrue(!getConnections().containsValue(connectionId));
    }

    @Test
    public void checkConnectionClosedState(){
        closeAllConnections();
        assertTrue(getConnections().isEmpty());
    }
    @Test
    public void checkCandleList(){
        assertTrue(!checkConnectionList.isEmpty());
    }


}
