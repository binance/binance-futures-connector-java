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

public class TestCMTopLongShortPositionRatio {
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
    public void testCMTopLongShortPositionRatioWithoutSymbol() {
        String path = "/futures/data/topLongShortPositionRatio?period=5m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("period", "5m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().topTraderLongShortPos(parameters));
    }

    @Test
    public void testCMTopLongShortPositionRatioWithoutPeriod() {
        String path = "/futures/data/topLongShortPositionRatio?pair=bnbusd_perpetual";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "bnbusd_perpetual");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        assertThrows(BinanceConnectorException.class, () -> client.market().topTraderLongShortPos(parameters));
    }

    @Test
    public void testCMTopLongShortPositionRatio() {
        String path = "/futures/data/topLongShortPositionRatio?pair=bnbusd_perpetual&period=5m";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "bnbusd_perpetual");
        parameters.put("period", "5m");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().topTraderLongShortPos(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testCMTopLongShortPositionRatioWithParameters() {
        String path = String.format("/futures/data/topLongShortPositionRatio?pair=bnbusd_perpetual&period=5m&limit=1000&startTime=%s&endTime=%s", startTime, endTime);
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("pair", "bnbusd_perpetual");
        parameters.put("period", "5m");
        parameters.put("limit", limit);
        parameters.put("startTime", startTime);
        parameters.put("endTime", endTime);

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().topTraderLongShortPos(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}