package com.binance.connector.futures.client;

import com.binance.connector.futures.client.impl.futures.Account;
import com.binance.connector.futures.client.impl.futures.UserData;
import com.binance.connector.futures.client.impl.futures.Market;
import com.binance.connector.futures.client.impl.futures.PortfolioMargin;

public interface FuturesClient {
    Market market();
    Account account();
    UserData userData();
    // Default implementation to make the method optional
    default PortfolioMargin portfolioMargin() {
        throw new UnsupportedOperationException("Portfolio Margin is not supported by this implementation.");
    }
}
