package com.binance.connector.futures.client.impl.um_futures;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.utils.ParameterChecker;
import java.util.LinkedHashMap;
import com.binance.connector.futures.client.impl.futures.Market;
import com.binance.connector.futures.client.utils.ProxyAuth;

/**
 * <h2>USDⓈ-Margined Market Endpoints</h2>
 * All endpoints under the
 * <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/general-info">Market Data Endpoint</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned in <i>String format</i>.
 */
public class UMMarket extends Market {
    public UMMarket(String productUrl, String baseUrl, String apiKey, boolean showLimitUsage, ProxyAuth proxy) {
        super(productUrl, baseUrl, apiKey, showLimitUsage, proxy);
    }

    /**
     * Mark Price and Funding Rate
     * <br><br>
     * GET /v1/premiumIndex
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading symbol <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Mark-Price">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Mark-Price</a>
     */
    public String markPrice(LinkedHashMap<String, Object> parameters) {
        return super.markPrice(parameters);
    }

    /**
     * 24 hour rolling window price change statistics. Careful when accessing this with no symbol.
     * <br><br>
     * GET /v1/ticker/24hr
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading symbol <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/24hr-Ticker-Price-Change-Statistics">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/24hr-Ticker-Price-Change-Statistics</a>
     */
    public String ticker24H(LinkedHashMap<String, Object> parameters) {
        return super.ticker24H(parameters);
    }

    /**
     * Latest price for a symbol or symbols.
     * <br><br>
     * GET /v1/ticker/price
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Symbol-Price-Ticker
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading symbol <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Symbol-Price-Ticker">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Symbol-Price-Ticker</a>
     */
    public String tickerSymbol(LinkedHashMap<String, Object> parameters) {
        return super.tickerSymbol(parameters);
    }

    /**
     * Best price/qty on the order book for a symbol or symbols.
     * <br><br>
     * GET /v1/ticker/bookTicker
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Symbol-Order-Book-Ticker
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading symbol <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Symbol-Order-Book-Ticker">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Symbol-Order-Book-Ticker</a>
     */
    public String bookTicker(LinkedHashMap<String, Object> parameters) {
        return super.bookTicker(parameters);
    }

    /**
     * Open Interest History
     * <br><br>
     * GET /futures/data/openInterestHist
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Open-Interest-Statistics
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * period -- mandatory/enum -- "5m","15m","30m","1h","2h","4h","6h","12h","1d" <br>
     * limit -- optional/long -- default 30, max 500 <br>
     * startTime -- optional/long -- Start Time <br>
     * endTime -- optional/long -- End Time <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Open-Interest-Statistics">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Open-Interest-Statistics</a>
     */
    public String openInterestStatistics(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "period", String.class);
        return super.openInterestStatistics(parameters);
    }

    /**
     * Top Trader Long/Short Ratio (Positions)
     * <br><br>
     * GET /futures/data/topLongShortPositionRatio
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Top-Trader-Long-Short-Ratio
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * period -- mandatory/enum -- "5m","15m","30m","1h","2h","4h","6h","12h","1d" <br>
     * limit -- optional/long -- default 30, max 500 <br>
     * startTime -- optional/long -- Start Time <br>
     * endTime -- optional/long -- End Time <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Top-Trader-Long-Short-Ratio">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Top-Trader-Long-Short-Ratio</a>
     */
    public String topTraderLongShortPos(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "period", String.class);
        return super.topTraderLongShortPos(parameters);
    }

    /**
     * Top Trader Long/Short Ratio (Accounts)
     * <br><br>
     * GET /futures/data/topLongShortAccountRatio
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Top-Long-Short-Account-Ratio
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * period -- mandatory/enum -- "5m","15m","30m","1h","2h","4h","6h","12h","1d" <br>
     * limit -- optional/long -- default 30, max 500 <br>
     * startTime -- optional/long -- Start Time <br>
     * endTime -- optional/long -- End Time <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Top-Long-Short-Account-Ratio">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Top-Long-Short-Account-Ratio</a>
     */
    public String topTraderLongShortAccs(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "period", String.class);
        return super.topTraderLongShortAccs(parameters);
    }

    /**
     * Long/Short Ratio
     * <br><br>
     * GET /futures/data/globalLongShortAccountRatio
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Long-Short-Ratio
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * period -- mandatory/enum -- "5m","15m","30m","1h","2h","4h","6h","12h","1d" <br>
     * limit -- optional/long -- default 30, max 500 <br>
     * startTime -- optional/long -- Start Time <br>
     * endTime -- optional/long -- End Time <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Long-Short-Ratio">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Long-Short-Ratio</a>
     */
    public String longShortRatio(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "period", String.class);
        return super.longShortRatio(parameters);
    }

    private final String TAKE_BUY_SELL_VOLUME = "/futures/data/takerlongshortRatio";
    /**
     * Taker Buy/Sell Volume
     * <br><br>
     * GET /futures/data/takerlongshortRatio
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Taker-BuySell-Volume
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * period -- mandatory/enum -- "5m","15m","30m","1h","2h","4h","6h","12h","1d" <br>
     * limit -- optional/long -- default 30, max 500 <br>
     * startTime -- optional/long -- Start Time <br>
     * endTime -- optional/long -- End Time <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Taker-BuySell-Volume">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Taker-BuySell-Volume</a>
     */
    public String takerBuySellVol(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "period", String.class);
        return getRequestHandler().sendPublicRequest(getBaseUrl(), TAKE_BUY_SELL_VOLUME, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String HISTORICAL_BLVT = "/v1/lvtKlines";
    /**
     * The BLVT NAV system is based on Binance Futures, so the endpoint is based on fapi
     * <br><br>
     * GET /v1/lvtKlines
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Historical-BLVT-NAV-Kline-Candlestick
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string -- the trading pair <br>
     * interval -- mandatory/enum -- interval <br>
     * startTime -- optional/long -- Start Time <br>
     * endTime -- optional/long -- End Time <br>
     * limit -- optional/long -- default 500, max 1000 <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Historical-BLVT-NAV-Kline-Candlestick">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Historical-BLVT-NAV-Kline-Candlestick</a>
     */
    public String historicalBlvt(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "interval", String.class);
        return getRequestHandler().sendPublicRequest(getProductUrl(), HISTORICAL_BLVT, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String INDEX_INFO = "/v1/indexInfo";
    /**
     * GET /v1/indexInfo
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Composite-Index-Symbol-Information
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading pair <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Composite-Index-Symbol-Information">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Composite-Index-Symbol-Information</a>
     */
    public String indexInfo(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendPublicRequest(getProductUrl(), INDEX_INFO, parameters, HttpMethod.GET, getShowLimitUsage());
    }

    private final String ASSET_INDEX = "/v1/assetIndex";
    /**
     * asset index for Multi-Assets mode
     * <br><br>
     * GET /v1/assetIndex
     * <br>
     * https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Multi-Assets-Mode-Asset-Index
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string -- the trading pair <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Multi-Assets-Mode-Asset-Index">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/market-data/rest-api/Multi-Assets-Mode-Asset-Index</a>
     */
    public String assetIndex(LinkedHashMap<String, Object> parameters) {
        return getRequestHandler().sendPublicRequest(getProductUrl(), ASSET_INDEX, parameters, HttpMethod.GET, getShowLimitUsage());
    }

}
