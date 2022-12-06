package com.binance.connector.client;

import com.binance.connector.client.utils.WebSocketCallback;
import java.util.ArrayList;

public interface WebsocketClient {
    int symbolTicker(String symbol, WebSocketCallback callback);
    int symbolTicker(String symbol, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int klineStream(String symbol, String interval, WebSocketCallback callback);
    int klineStream(String symbol, String interval, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int aggTradeStream(String symbol, WebSocketCallback callback);
    int aggTradeStream(String symbol, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int miniTickerStream(String symbol, WebSocketCallback callback);
    int miniTickerStream(String symbol, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int allTickerStream(WebSocketCallback callback);
    int allTickerStream(WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int allMiniTickerStream(WebSocketCallback callback);
    int allMiniTickerStream(WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int bookTicker(String symbol, WebSocketCallback callback);
    int bookTicker(String symbol, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int allBookTickerStream(WebSocketCallback callback);
    int allBookTickerStream(WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int partialDepthStream(String symbol, int levels, int speed, WebSocketCallback callback);
    int partialDepthStream(String symbol, int levels, int speed, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int diffDepthStream(String symbol, int speed, WebSocketCallback callback);
    int diffDepthStream(String symbol, int speed, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int combineStreams(ArrayList<String> streams, WebSocketCallback callback);
    int combineStreams(ArrayList<String> streams, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int listenUserStream(String listenKey, WebSocketCallback callback);
    int listenUserStream(String listenKey, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    void closeConnection(int streamId);
    void closeAllConnections();
    int markPriceStream(String symbol, int speed, WebSocketCallback callback);
    int markPriceStream(String symbol, int speed, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int continuousKlineStream(String pair, String interval, String contractType, WebSocketCallback callback);
    int continuousKlineStream(String pair, String interval, String contractType, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int forceOrderStream(String symbol, WebSocketCallback callback);
    int forceOrderStream(String symbol, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
    int allForceOrderStream(WebSocketCallback callback);
    int allForceOrderStream(WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback);
}