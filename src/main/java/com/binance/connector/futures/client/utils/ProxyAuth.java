package com.binance.connector.futures.client.utils;

import okhttp3.Authenticator;
import java.net.Proxy;

public final class ProxyAuth {
    private Proxy proxy;
    private Authenticator auth;
    
    public ProxyAuth(Proxy proxy, Authenticator auth) {
        this.proxy = proxy;
        this.auth = auth;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public Authenticator getAuth() {
        return auth;
    }
}
