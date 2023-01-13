package unit.um_futures.market;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import java.util.LinkedHashMap;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import unit.MockData;
import unit.MockWebServerDispatcher;

public class TestUMMultiAssetsModeIndex {
    private MockWebServer mockWebServer;
    private String baseUrl;


    @Before
    public void init() {
        this.mockWebServer = new MockWebServer();
        this.baseUrl = mockWebServer.url(MockData.PREFIX).toString();
    }

    @Test
    public void testMultiAssetsModeIndexWithoutSymbol() {
        String path = "fapi/v1/assetIndex";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().assetIndex(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }

    @Test
    public void testMultiAssetsModeIndexWithSymbol() {
        String path = "fapi/v1/assetIndex?symbol=ADAUSD";
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "ADAUSD");

        Dispatcher dispatcher = MockWebServerDispatcher.getDispatcher(MockData.PREFIX, path, MockData.MOCK_RESPONSE, HttpMethod.GET, MockData.HTTP_STATUS_OK);
        mockWebServer.setDispatcher(dispatcher);

        UMFuturesClientImpl client = new UMFuturesClientImpl(baseUrl);
        String result = client.market().assetIndex(parameters);
        assertEquals(MockData.MOCK_RESPONSE, result);
    }
}
