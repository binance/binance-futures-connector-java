package examples.cm_futures.market;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExchangeInfo {
    private ExchangeInfo() {
    }

    private static final Logger logger = LoggerFactory.getLogger(ExchangeInfo.class);
    public static void main(String[] args) {

        CMFuturesClientImpl client = new CMFuturesClientImpl();

        try {
            String result = client.market().exchangeInfo();
            logger.info(result);
        } catch (BinanceConnectorException e) {
            logger.error("fullErrMessage: {}", e.getMessage(), e);
        } catch (BinanceClientException e) {
            logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
        }
    }
}