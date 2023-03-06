package com.binance.connector.futures.client.impl;

import com.binance.connector.futures.client.enums.DefaultUrls;
import com.binance.connector.futures.client.impl.cm_futures.CMMarket;
import com.binance.connector.futures.client.impl.cm_futures.CMAccount;
import com.binance.connector.futures.client.impl.cm_futures.CMUserData;
import com.binance.connector.futures.client.impl.cm_futures.CMPortfolioMargin;

public class CMFuturesClientImpl extends FuturesClientImpl {
    private static String defaultBaseUrl = DefaultUrls.COINM_PROD_URL;
    private static String cmProduct = "/dapi";

    public CMFuturesClientImpl() {
        super(defaultBaseUrl, cmProduct);
    }

    public CMFuturesClientImpl(String baseUrl) {
        super(baseUrl, cmProduct);
    }

    public CMFuturesClientImpl(String apiKey, String secretKey) {
        super(apiKey, secretKey, defaultBaseUrl, cmProduct);
    }

    public CMFuturesClientImpl(String baseUrl, boolean showLimitUsage) {
        super(baseUrl, cmProduct, showLimitUsage);
    }

    public CMFuturesClientImpl(String apiKey, String secretKey, boolean showLimitUsage) {
        super(apiKey, secretKey, defaultBaseUrl, cmProduct, showLimitUsage);
    }

    public CMFuturesClientImpl(String apiKey, String secretKey, String baseUrl) {
        super(apiKey, secretKey, baseUrl, cmProduct);
    }

    @Override
    public CMMarket market() {
        return new CMMarket(getProductUrl(), getBaseUrl(), getApiKey(), getShowLimitUsage(), getProxy());
    }

    @Override
    public CMAccount account() {
        return new CMAccount(getProductUrl(), getApiKey(), getSecretKey(), getShowLimitUsage(), getProxy());
    }

    @Override
    public CMUserData userData() {
        return new CMUserData(getProductUrl(), getApiKey(), getShowLimitUsage(), getProxy());
    }

    @Override
    public CMPortfolioMargin portfolioMargin() {
        return new CMPortfolioMargin(getProductUrl(), getApiKey(), getSecretKey(), getShowLimitUsage(), getProxy());
    }
}
