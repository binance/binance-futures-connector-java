package examples.um_futures.proxy;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.binance.connector.futures.client.utils.ProxyAuth;
import java.net.InetSocketAddress;
import java.net.Proxy;

public final class UnauthProxy {
    private UnauthProxy() {
    }

    private static final Integer proxyPort = 80;

    public static void main(String[] args) {
        UMFuturesClientImpl client = new UMFuturesClientImpl();
        
        Proxy proxyConn = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", proxyPort));
        ProxyAuth proxy = new ProxyAuth(proxyConn, null);
        client.setProxy(proxy);
        System.out.println(client.market().time());

        client.unsetProxy();
        System.out.println(client.market().time());
    }
}
