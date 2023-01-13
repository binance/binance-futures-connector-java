package unit.cm_futures.account;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;
import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;

public class TestCMPositionAdlQuantileEstimation {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testPositionAdlQuantileEstimationNoSymbol() {
        String path = "dapi/v1/adlQuantile";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(MockData.API_KEY, MockData.SECRET_KEY, baseUrl);
        String result = client.account().getAdlQuantile(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testPositionAdlQuantileEstimation() {
        String path = "dapi/v1/adlQuantile?symbol=BNBUSDT";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(MockData.API_KEY, MockData.SECRET_KEY, baseUrl);
        String result = client.account().getAdlQuantile(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}
