package com.binance.connector.futures.client.impl.futures;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.utils.ParameterChecker;
import com.binance.connector.futures.client.utils.ProxyAuth;
import com.binance.connector.futures.client.utils.RequestHandler;
import java.util.LinkedHashMap;

/**
 * <h2>Market Endpoints</h2>
 * Response will be returned in <i>String format</i>.
 */
public abstract class Market {
    private String baseUrl;
    private String productUrl;
    private RequestHandler requestHandler;
    private boolean showLimitUsage;

    public Market(String productUrl, String baseUrl, String apiKey, boolean showLimitUsage, ProxyAuth proxy) {
        this.baseUrl = baseUrl;
        this.productUrl = productUrl;
        this.requestHandler = new RequestHandler(apiKey, proxy);
        this.showLimitUsage = showLimitUsage;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public RequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public boolean getShowLimitUsage() {
        return this.showLimitUsage;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public void setRequestHandler(String apiKey, String secretKey, ProxyAuth proxy) {
        new RequestHandler(apiKey, secretKey, proxy);
    }

    public void setShowLimitUsage(boolean showLimitUsage) {
        this.showLimitUsage = showLimitUsage;
    }

    private final String MARK_PRICE = "/v1/premiumIndex";
    public String markPrice(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(productUrl, MARK_PRICE, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String TICKER_24H = "/v1/ticker/24hr";
    public String ticker24H(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(productUrl, TICKER_24H, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String TICKER_SYMBOL = "/v1/ticker/price";
    public String tickerSymbol(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(productUrl, TICKER_SYMBOL, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String BOOK_TICKER = "/v1/ticker/bookTicker";
    public String bookTicker(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(productUrl, BOOK_TICKER, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String OPEN_INTEREST_STATS = "/futures/data/openInterestHist";
    public String openInterestStatistics(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(baseUrl, OPEN_INTEREST_STATS, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String TOP_TRADER_LONG_SHORT_RATIO_POSITIONS = "/futures/data/topLongShortPositionRatio";
    public String topTraderLongShortPos(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(baseUrl, TOP_TRADER_LONG_SHORT_RATIO_POSITIONS, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String TOP_TRADER_LONG_SHORT_RATIO_ACCOUNTS = "/futures/data/topLongShortAccountRatio";
    public String topTraderLongShortAccs(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(baseUrl, TOP_TRADER_LONG_SHORT_RATIO_ACCOUNTS, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String GLOBAL_LONG_SHORT = "/futures/data/globalLongShortAccountRatio";
    public String longShortRatio(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(baseUrl, GLOBAL_LONG_SHORT, parameters, HttpMethod.GET, showLimitUsage);
    }


    private final String PING = "/v1/ping";
    /**
     * Test connectivity to the Rest API.
     * <br><br>
     * GET /v1/ping
     * <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Test-Connectivity">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Test-Connectivity</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Test-Connectivity">
     * https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Test-Connectivity</a>
     */
    public String ping() {
        return requestHandler.sendPublicRequest(productUrl, PING, null, HttpMethod.GET, showLimitUsage);
    }

    private final String TIME = "/v1/time";
    /**
     * Test connectivity to the Rest API and get the current server time.
     * <br><br>
     * GET /api/v1/time
     * <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Check-Server-Time">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Check-Server-Time</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Check-Server-time">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Check-Server-time</a>
     */
    public String time() {
        return requestHandler.sendPublicRequest(productUrl, TIME, null, HttpMethod.GET, showLimitUsage);
    }

    private final String EXCHANGE_INFO = "/v1/exchangeInfo";
    /**
     * Current exchange trading rules and symbol information.
     * <br><br>
     * GET /v1/exchangeinfo
     * <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Exchange-Information">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Exchange-Information</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Exchange-Information">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Exchange-Information</a>
     */
    public String exchangeInfo() {
        return requestHandler.sendPublicRequest(productUrl, EXCHANGE_INFO, null, HttpMethod.GET, showLimitUsage);
    }

    private final String DEPTH = "/v1/depth";
    /**
     * GET /v1/depth
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * limit -- optional/integer -- limit the results
     *            Default 100; max 5000. Valid limits:[5, 10, 20, 50, 100, 500, 1000, 5000] <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Order-Book">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Order-Book</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Order-Book">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Order-Book</a>
     */
    public String depth(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendPublicRequest(productUrl, DEPTH, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String TRADES = "/v1/trades";
    /**
     * Get recent trades.
     * <br><br>
     * GET /v1/trades
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * limit -- optional/integer -- limit the results Default 500; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Recent-Trades-List">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Recent-Trades-List</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Recent-Trades-List">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Recent-Trades-List</a>
     */
    public String trades(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendPublicRequest(productUrl, TRADES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String HISTORICAL_TRADES = "/v1/historicalTrades";
    /**
     * Get older market trades.
     * <br><br>
     * GET /v1/historicalTrades
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * limit -- optional/integer -- limit the result Default 500; max 1000 <br>
     * fromId -- optional/long -- trade id to fetch from. Default gets most recent trades <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Old-Trades-Lookup">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Old-Trades-Lookup</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Old-Trades-Lookup">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Old-Trades-Lookup</a>
     *
     */
    public String historicalTrades(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendWithApiKeyRequest(productUrl, HISTORICAL_TRADES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String AGG_TRADES = "/v1/aggTrades";
    /**
     * Get compressed, aggregate trades. Trades that fill at the time, from the same order,
     * with the same price will have the quantity aggregated.
     * <br><br>
     * GET /v1/aggTrades
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * fromId -- optional/long -- id to get aggregate trades from INCLUSIVE <br>
     * startTime -- optional/long -- Timestamp in ms to get aggregate trades from INCLUSIVE <br>
     * endTime -- optional/long -- Timestamp in ms to get aggregate trades until INCLUSIVE <br>
     * limit -- optional/integer -- limit the results Default 500; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Compressed-Aggregate-Trades-List">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Compressed-Aggregate-Trades-List</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Compressed-Aggregate-Trades-List">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Compressed-Aggregate-Trades-List</a>
     */
    public String aggTrades(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendPublicRequest(productUrl, AGG_TRADES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String KLINES = "/v1/klines";
    /**
     * Kline/candlestick bars for a symbol.
     * Klines are uniquely identified by their open time.
     * <br><br>
     * GET /v1/klines
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * interval -- mandatory/string <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer -- limit the results Default 500; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Kline-Candlestick-Data</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Kline-Candlestick-Data</a>
     */
    public String klines(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "interval", String.class);
        return requestHandler.sendPublicRequest(productUrl, KLINES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String CONTINUOUSKLINES = "/v1/continuousKlines";
    /**
     * Kline/candlestick bars for a specific contract type.
     * Klines are uniquely identified by their open time.
     * <br><br>
     * GET /v1/continuousKlines
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * pair -- mandatory/string <br>
     * contractType -- mandatory/enum <br>
     * interval -- mandatory/enum <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer -- limit the results Default 500; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Continuous-Contract-Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Continuous-Contract-Kline-Candlestick-Data</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Continuous-Contract-Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Continuous-Contract-Kline-Candlestick-Data</a>
     */
    public String continuousKlines(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "pair", String.class);
        ParameterChecker.checkParameter(parameters, "contractType", String.class);
        ParameterChecker.checkParameter(parameters, "interval", String.class);
        return requestHandler.sendPublicRequest(productUrl, CONTINUOUSKLINES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String INDEXPRICEKLINES = "/v1/indexPriceKlines";
    /**
     * Kline/candlestick bars for the index price of a pair.
     * Klines are uniquely identified by their open time.
     * <br><br>
     * GET /v1/indexPriceKlines
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * pair -- mandatory/string <br>
     * interval -- mandatory/enum <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer -- limit the results Default 500; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Index-Price-Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Index-Price-Kline-Candlestick-Data</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Index-Price-Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Index-Price-Kline-Candlestick-Data</a>
     */
    public String indexPriceKlines(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "pair", String.class);
        ParameterChecker.checkParameter(parameters, "interval", String.class);
        return requestHandler.sendPublicRequest(productUrl, INDEXPRICEKLINES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String MARKPRICEKLINES = "/v1/markPriceKlines";
    /**
     * Kline/candlestick bars for the mark price of a symbol.
     * Klines are uniquely identified by their open time.
     * <br><br>
     * GET /v1/markPriceKlines
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * interval -- mandatory/enum <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer -- limit the results Default 500; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Mark-Price-Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Mark-Price-Kline-Candlestick-Data</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Mark-Price-Kline-Candlestick-Data">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Mark-Price-Kline-Candlestick-Data</a>
     */
    public String markPriceKlines(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "interval", String.class);
        return requestHandler.sendPublicRequest(productUrl, MARKPRICEKLINES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String FUNDING_RATE = "/v1/fundingRate";
    /**
     * Get funding rate history
     * <br><br>
     * GET /v1/fundingRate
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading pair <br>
     * startTime -- optional/long -- Timestamp in ms to get funding rate from INCLUSIVE. <br>
     * endTime -- optional/long -- Timestamp in ms to get funding rate until INCLUSIVE. <br>
     * limit -- optional/int -- Default 100; max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Get-Funding-Rate-History">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Get-Funding-Rate-History</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Get-Funding-Rate-History-of-Perpetual-Futures">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Get-Funding-Rate-History-of-Perpetual-Futures</a>
     */
    public String fundingRate(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendPublicRequest(productUrl, FUNDING_RATE, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String OPEN_INTEREST = "/v1/openInterest";
    /**
     * Get present open interest of a specific symbol.
     * <br><br>
     * GET /v1/openInterest
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Open-Interest
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Open-Interest">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Open-Interest</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Open-Interest">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/market-data/Open-Interest</a>
     */
    public String openInterest(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendPublicRequest(productUrl, OPEN_INTEREST, parameters, HttpMethod.GET, showLimitUsage);
    }
}
