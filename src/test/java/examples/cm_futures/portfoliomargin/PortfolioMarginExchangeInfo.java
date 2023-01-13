package examples.cm_futures.portfoliomargin;

import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import examples.PrivateConfig;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PortfolioMarginExchangeInfo {
    private PortfolioMarginExchangeInfo() {
    }

    private static final Logger logger = LoggerFactory.getLogger(PortfolioMarginAccountInfo.class);
    public static void main(String[] args) {
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        CMFuturesClientImpl client = new CMFuturesClientImpl(PrivateConfig.TESTNET_API_KEY, PrivateConfig.TESTNET_SECRET_KEY, PrivateConfig.TESTNET_BASE_URL);

        parameters.put("symbol", "BNBUSD_PERP");
        String result = client.portfolioMargin().portfolioMarginExchangeInfo(parameters);
        logger.info(result);
    }
}