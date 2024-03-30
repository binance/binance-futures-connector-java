package com.binance.connector.futures.client.impl;

import com.binance.connector.futures.client.utils.WebSocketCallback;

public class MarkPriceSymbolParams {
    private final String pair;
    private final int speed;
    private final WebSocketCallback onOpenCallback;
    private final WebSocketCallback onMessageCallback;
    private final WebSocketCallback onClosingCallback;
    private final WebSocketCallback onFailureCallback;

    /**
     * @param pair trading pair
     * @param speed speed in seconds, can be 1 or 3
     * @param onOpenCallback onOpenCallback
     * @param onMessageCallback onMessageCallback
     * @param onClosingCallback onClosingCallback
     * @param onFailureCallback onFailureCallback
     *
     */
    public MarkPriceSymbolParams(String pair, int speed, WebSocketCallback onOpenCallback, WebSocketCallback onMessageCallback, WebSocketCallback onClosingCallback, WebSocketCallback onFailureCallback) {
        this.pair = pair;
        this.speed = speed;
        this.onOpenCallback = onOpenCallback;
        this.onMessageCallback = onMessageCallback;
        this.onClosingCallback = onClosingCallback;
        this.onFailureCallback = onFailureCallback;
    }

    public String getPair() {
        return pair;
    }

    public int getSpeed() {
        return speed;
    }

    public WebSocketCallback getOnOpenCallback() {
        return onOpenCallback;
    }

    public WebSocketCallback getOnMessageCallback() {
        return onMessageCallback;
    }

    public WebSocketCallback getOnClosingCallback() {
        return onClosingCallback;
    }

    public WebSocketCallback getOnFailureCallback() {
        return onFailureCallback;
    }
}
