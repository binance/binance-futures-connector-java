package com.binance.connector.futures.client.impl.futures;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.utils.ProxyAuth;
import com.binance.connector.futures.client.utils.RequestHandler;
import com.binance.connector.futures.client.utils.ParameterChecker;
import com.binance.connector.futures.client.utils.signaturegenerator.SignatureGenerator;
import java.util.LinkedHashMap;

/**
 * <h2>Portfolio Margin Endpoints</h2>
 * Response will be returned in <i>String format</i>.
 */
public abstract class PortfolioMargin {
    private String productUrl;
    private RequestHandler requestHandler;
    private boolean showLimitUsage;

    public PortfolioMargin(String productUrl, String apiKey, SignatureGenerator signatureGenerator, boolean showLimitUsage, ProxyAuth proxy) {
        this.productUrl = productUrl;
        this.requestHandler = new RequestHandler(apiKey, signatureGenerator, proxy);
        this.showLimitUsage = showLimitUsage;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public RequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public boolean getShowLimitUsage() {
        return this.showLimitUsage;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public void setRequestHandler(String apiKey, SignatureGenerator signatureGenerator, ProxyAuth proxy) {
        this.requestHandler = new RequestHandler(apiKey, signatureGenerator, proxy);
    }

    public void setShowLimitUsage(boolean showLimitUsage) {
        this.showLimitUsage = showLimitUsage;
    }

    private final String PORTFOLIO_MARGIN_EXCHANGE_INFO = "/v1/pmExchangeInfo";
    public String portfolioMarginExchangeInfo(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, PORTFOLIO_MARGIN_EXCHANGE_INFO, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String PORTFOLIO_MARGIN_ACCOUNT_INFO = "/v1/pmAccountInfo";
    /**
     * Get Portfolio Margin current account information.
     * GET /v1/pmAccountInfo
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * asset -- mandatory/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/portfolio-margin-endpoints/Classic-Portfolio-Margin-Account-Information#api-description">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/portfolio-margin-endpoints/Classic-Portfolio-Margin-Account-Information#api-description</a>
     */
    public String portfolioMarginAccountInfo(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "asset", String.class);
        return requestHandler.sendSignedRequest(productUrl, PORTFOLIO_MARGIN_ACCOUNT_INFO, parameters, HttpMethod.GET, showLimitUsage);
    }
}