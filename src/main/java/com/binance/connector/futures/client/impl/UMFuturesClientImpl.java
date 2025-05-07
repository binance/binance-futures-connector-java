package com.binance.connector.futures.client.impl;

import com.binance.connector.futures.client.enums.DefaultUrls;
import com.binance.connector.futures.client.impl.um_futures.UMAccount;
import com.binance.connector.futures.client.impl.um_futures.UMMarket;
import com.binance.connector.futures.client.impl.um_futures.UMUserData;
import com.binance.connector.futures.client.utils.signaturegenerator.SignatureGenerator;

public class UMFuturesClientImpl extends FuturesClientImpl {
    private static String defaultBaseUrl = DefaultUrls.USDM_PROD_URL;
    private static String umProduct = "/fapi";

    public UMFuturesClientImpl() {
        super(defaultBaseUrl, umProduct);
    }

    public UMFuturesClientImpl(String baseUrl) {
        super(baseUrl, umProduct);
    }

    public UMFuturesClientImpl(String apiKey, String secretKey) {
        super(apiKey, secretKey, defaultBaseUrl, umProduct);
    }

    public UMFuturesClientImpl(String baseUrl, boolean showLimitUsage) {
        super(baseUrl, umProduct, showLimitUsage);
    }

    public UMFuturesClientImpl(String apiKey, String secretKey, boolean showLimitUsage) {
        super(apiKey, secretKey, defaultBaseUrl, umProduct, showLimitUsage);
    }

    public UMFuturesClientImpl(String apiKey, String secretKey, String baseUrl) {
        super(apiKey, secretKey, baseUrl, umProduct);
    }

    public UMFuturesClientImpl(String apiKey, SignatureGenerator signatureGenerator, String baseUrl, boolean showLimitUsage) {
        super(apiKey, signatureGenerator, baseUrl, umProduct, showLimitUsage);
    }

    @Override
    public UMMarket market() {
        return new UMMarket(getProductUrl(), getBaseUrl(), getApiKey(), getShowLimitUsage(), getProxy());
    }

    @Override
    public UMAccount account() {
        return new UMAccount(getProductUrl(), getApiKey(), getSignatureGenerator(), getShowLimitUsage(), getProxy());
    }

    @Override
    public UMUserData userData() {
        return new UMUserData(getProductUrl(), getApiKey(), getShowLimitUsage(), getProxy());
    }
}
