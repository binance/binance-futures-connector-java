package com.binance.connector.futures.client.impl;

import com.binance.connector.futures.client.FuturesClient;
import com.binance.connector.futures.client.utils.ProxyAuth;

public abstract class FuturesClientImpl implements FuturesClient {
    private final String apiKey;
    private final String secretKey;
    private final String baseUrl;
    private final String productUrl;
    private boolean showLimitUsage;
    private ProxyAuth proxy = null;

    public FuturesClientImpl(String baseUrl, String product) {
        this(null, null, baseUrl, product);
    }

    public FuturesClientImpl(String baseUrl, String product, boolean showLimitUsage) {
        this(null, null, baseUrl, product, showLimitUsage);
    }

    public FuturesClientImpl(String apiKey, String secretKey, String baseUrl, String product) {
        this(apiKey, secretKey, baseUrl, product, false);
    }

    public FuturesClientImpl(String apiKey, String secretKey, String baseUrl, String product, boolean showLimitUsage) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.baseUrl = baseUrl;
        this.productUrl = baseUrl + product;
        this.showLimitUsage = showLimitUsage;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public boolean getShowLimitUsage() {
        return this.showLimitUsage;
    }

    public void setShowLimitUsage(boolean showLimitUsage) {
        this.showLimitUsage = showLimitUsage;
    }

    public void setProxy(ProxyAuth proxy) {
        this.proxy = proxy;
    }

    public ProxyAuth getProxy() {
        return proxy;
    }

    public void unsetProxy() {
        this.proxy = null;
    }

}
