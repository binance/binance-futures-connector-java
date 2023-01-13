package unit.cm_futures.market;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;
import static org.junit.Assert.assertEquals;

public class TestCMExchangeInfo {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testExchangeInfo() {
        String path = "dapi/v1/exchangeInfo";

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        CMFuturesClientImpl client = new CMFuturesClientImpl(baseUrl);
        String result = client.market().exchangeInfo();
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}
