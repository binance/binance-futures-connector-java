package unit.cm_futures.market;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;
import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestCMBasis {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testBasisWithoutPair() {
        String path = "/futures/data/basis?period=1m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("period", "1m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().basis(parameters));
    }

    @Test
    public void testBasisWithoutPeriod() {
        String path = "/futures/data/basis?pair=BTCUSD";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "BTCUSD");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().basis(parameters));
    }

    @Test
    public void testBasis() {
        String path = "/futures/data/basis?pair=BTCUSD&contractType=PERPETUAL&period=1m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "BTCUSD");
        parameters.put("contractType", "PERPETUAL");
        parameters.put("period", "1m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().basis(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}
