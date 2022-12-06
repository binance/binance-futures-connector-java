package com.binance.connector.client.impl;

import com.binance.connector.client.utils.RequestBuilder;
import com.binance.connector.client.utils.WebSocketCallback;
import okhttp3.Request;

/**
 * <h2>Websocket Streams</h2>
 * All stream endpoints under the
 * <a href="https://binance-docs.github.io/apidocs/spot/en/#websocket-market-streams">Websocket Market Streams</a> and
 * <a href="https://binance-docs.github.io/apidocs/spot/en/#user-data-streams">User Data Streams</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned as callback.
 */
public class UMWebsocketClientImpl extends WebsocketClientImpl {

    public UMWebsocketClientImpl() {
        super();
    }

    public UMWebsocketClientImpl(String baseUrl) {
        super(baseUrl);
    }

    /**
     * Mark price and funding rate for all symbols pushed every 3 seconds or every second.
     * <br><br>
     * &lt;symbol&gt;@markPrice or &lt;symbol&gt;@markPrice@1s
     * <br><br>
     * Update Speed: 3000ms or 1000ms
     *
     * @param speed 1s or 3s
     * @return int - Connection ID
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#mark-price-stream-for-all-market">
     * https://binance-docs.github.io/apidocs/futures/en/#mark-price-stream-for-all-market</a>
     */
    public int allMarkPriceStream(int speed, WebSocketCallback callback) {
        return allMarkPriceStream(speed, getNoopCallback(), callback, getNoopCallback(), getNoopCallback());
    }

    /**
     * Same as {@link #allMarkPriceStream(String, WebSocketCallback)} plus accepts callbacks for all major websocket connection events.
     *
     * @param speed
     * @param onOpenCallback
     * @param onMessageCallback
     * @param onClosingCallback
     * @param onFailureCallback
     * @return
     */
    public int allMarkPriceStream(int speed, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback) {
        Request request = RequestBuilder.buildWebsocketRequest(String.format("%s/ws/!markPrice@arr@%s", getBaseUrl(), speed));
        return super.createConnection(onOpenCallback, onMessageCallback, onClosingCallback, onFailureCallback, request);
    }

}