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

public class TestCMTopLongShortAccountRatio {
    private MockWebServer mockWebServer;
    private String baseUrl;

    private final long startTime = System.currentTimeMillis();
    private final long endTime = startTime + 1000;
    private final int limit = 1000;

    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testCMTopLongShortAccountRatioWithoutSymbol() {
        String path = "/futures/data/topLongShortAccountRatio?period=5m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("period", "5m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().topTraderLongShortAccs(parameters));
    }

    @Test
    public void testCMTopLongShortAccountRatioWithoutPeriod() {
        String path = "/futures/data/topLongShortAccountRatio?pair=btcusd_perpetual";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "btcusd_perpetual");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().topTraderLongShortAccs(parameters));
    }

    @Test
    public void testCMTopLongShortAccountRatio() {
        String path = "/futures/data/topLongShortAccountRatio?pair=btcusd_perpetual&period=5m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "btcusd_perpetual");
        parameters.put("period", "5m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().topTraderLongShortAccs(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testCMTopLongShortAccountRatioWithParameters() {
        String path = String.format("/futures/data/topLongShortAccountRatio?pair=btcusd_perpetual&period=5m&limit=1000&startTime=%s&endTime=%s", startTime, endTime);
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "btcusd_perpetual");
        parameters.put("period", "5m");
        parameters.put("limit", limit);
        parameters.put("startTime", startTime);
        parameters.put("endTime", endTime);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().topTraderLongShortAccs(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}