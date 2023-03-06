package com.binance.connector.futures.client.impl.um_futures;

import com.binance.connector.futures.client.impl.futures.UserData;
import com.binance.connector.futures.client.utils.ProxyAuth;

/**
 * <h2>USDⓈ-Margined User Data Streams Endpoints</h2>
 * All endpoints under the
 * <a href="https://binance-docs.github.io/apidocs/futures/en/#user-data-streams">User Data Streams</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned in <i>String format</i>.
 */
public class UMUserData extends UserData {
    public UMUserData(String productUrl, String apiKey, boolean showLimitUsage, ProxyAuth proxy) {
        super(productUrl, apiKey, showLimitUsage, proxy);
    }
}
