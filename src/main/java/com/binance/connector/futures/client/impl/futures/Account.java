package com.binance.connector.futures.client.impl.futures;

import com.binance.connector.futures.client.enums.HttpMethod;
import com.binance.connector.futures.client.utils.ParameterChecker;
import com.binance.connector.futures.client.utils.ProxyAuth;
import com.binance.connector.futures.client.utils.RequestHandler;
import java.util.LinkedHashMap;

/**
 * <h2>Trade Endpoints</h2>
 * Response will be returned in <i>String format</i>.
 */
public abstract class Account {
    private String productUrl;
    private RequestHandler requestHandler;
    private boolean showLimitUsage;

    public Account(String productUrl, String apiKey, String secretKey, boolean showLimitUsage, ProxyAuth proxy) {
        this.productUrl = productUrl;
        this.requestHandler = new RequestHandler(apiKey, secretKey, proxy);
        this.showLimitUsage = showLimitUsage;
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

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public void setRequestHandler(String apiKey, String secretKey, ProxyAuth proxy) {
        this.requestHandler = new RequestHandler(apiKey, secretKey, proxy);
    }

    public void setShowLimitUsage(boolean showLimitUsage) {
        this.showLimitUsage = showLimitUsage;
    }

    private final String OPEN_ORDERS = "/v1/openOrders";
    public String currentAllOpenOrders(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, OPEN_ORDERS, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String ALL_ORDERS = "/v1/allOrders";
    public String allOrders(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, ALL_ORDERS, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String USER_TRADES = "/v1/userTrades";
    public String accountTradeList(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, USER_TRADES, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String LEVERAGE_BRACKET = "/v1/leverageBracket";
    public String getLeverageBracket(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, LEVERAGE_BRACKET, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String POSITION_SIDE_DUAL = "/v1/positionSide/dual";
    /**
     * Change user's position mode (Hedge Mode or One-way Mode ) on EVERY symbol
     * <br><br>
     * POST /v1/positionSide/dual
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * dualSidePosition -- mandatory/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Position-Mode">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Position-Mode</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Change-Position-Mode">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Change-Position-Mode</a>
     */
    public String changePositionModeTrade(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "dualSidePosition", String.class);
        return requestHandler.sendSignedRequest(productUrl, POSITION_SIDE_DUAL, parameters, HttpMethod.POST, showLimitUsage);
    }

    /**
     * Check an order's status.
     * <br><br>
     * GET /v1/positionSide/dual
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Current-Position-Mode">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Current-Position-Mode</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/account/Get-Current-Position-Mode">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/account/Get-Current-Position-Mode</a>
     */
    public String getCurrentPositionMode(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, POSITION_SIDE_DUAL, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String ORDER = "/v1/order";
    /**
     * Send in a new order.
     * <br><br>
     * POST /v1/order
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * side -- mandatory/enum <br>
     * positionSide - optional/enum <br>
     * type -- mandatory/enum <br>
     * timeInForce -- optional/enum <br>
     * quantity -- optional/decimal <br>
     * reduceOnly -- optional/string <br>
     * price -- optional/decimal <br>
     * newClientOrderId -- optional/string <br>
     * stopPrice -- optional/decimal <br>
     * closePosition -- optional/string <br>
     * activationPrice -- optional/decimal <br>
     * callbackRate -- optional/decimal <br>
     * workingType -- optional/enum <br>
     * priceProtect -- optional/string <br>
     * newOrderRespType -- optional/enum <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/New-Order">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/New-Order</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/New-Order">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/New-Order</a>
     */
    public String newOrder(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "side", String.class);
        ParameterChecker.checkParameter(parameters, "type", String.class);
        return requestHandler.sendSignedRequest(productUrl, ORDER, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String BATCH_ORDERS = "/v1/batchOrders";
    /**
     * Send in a new order.
     * <br><br>
     * POST /v1/batchOrders
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * batchOrders -- mandatory/list <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Place-Multiple-Orders">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Place-Multiple-Orders</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Modify-Multiple-Orders">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Modify-Multiple-Orders</a>
     */
    public String placeMultipleOrders(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkRequiredParameter(parameters, "batchOrders");
        return requestHandler.sendSignedRequest(productUrl, BATCH_ORDERS, parameters, HttpMethod.POST, showLimitUsage);
    }

    /**
     * Check an order's status.
     * <br><br>
     * GET /v1/order
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * orderId -- optional/long <br>
     * origClientOrderId -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Query-Order">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Query-Order</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Query-Order">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Query-Order</a>
     */
    public String queryOrder(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkOrParameters(parameters, "orderId", "origClientOrderId");
        return requestHandler.sendSignedRequest(productUrl, ORDER, parameters, HttpMethod.GET, showLimitUsage);
    }

    /**
     * Cancel an active order.
     * <br><br>
     * DELETE /v1/order
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * orderId -- optional/long <br>
     * origClientOrderId -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Cancel-Order">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Cancel-Order</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Cancel-Order">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Cancel-Order</a>
     */
    public String cancelOrder(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkOrParameters(parameters, "orderId", "origClientOrderId");
        return requestHandler.sendSignedRequest(productUrl, ORDER, parameters, HttpMethod.DELETE, showLimitUsage);
    }

    private final String ALL_OPEN_ORDERS = "/v1/allOpenOrders";
    /**
     * Cancel all open orders.
     * <br><br>
     * DELETE /v1/allOpenOrders
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Cancel-All-Open-Orders">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Cancel-All-Open-Orders</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Cancel-All-Open-Orders">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Cancel-All-Open-Orders</a>
     */
    public String cancelAllOpenOrders(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendSignedRequest(productUrl, ALL_OPEN_ORDERS, parameters, HttpMethod.DELETE, showLimitUsage);
    }

    /**
     * Cancel multiple orders.
     * <br><br>
     * DELETE /v1/batchOrders
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * orderIdList -- optional/list <br>
     * origClientOrderIdList -- optional/list <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Cancel-Multiple-Orders">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Cancel-Multiple-Orders</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Cancel-Multiple-Orders">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Cancel-Multiple-Orders</a>
     */
    public String cancelMultipleOrders(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendSignedRequest(productUrl, BATCH_ORDERS, parameters, HttpMethod.DELETE, showLimitUsage);
    }

    private final String CANCEL_ALL = "/v1/countdownCancelAll";
    /**
     * Cancel all open orders of the specified symbol at the end of the specified countdown.
     * <br><br>
     * POST /v1/countdownCancelAll
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * countdownTime -- mandatory/long <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Auto-Cancel-All-Open-Orders">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Auto-Cancel-All-Open-Orders</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Auto-Cancel-All-Open-Orders">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Auto-Cancel-All-Open-Orders</a>
     */
    public String autoCancelOpen(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "countdownTime", Integer.class);
        return requestHandler.sendSignedRequest(productUrl, CANCEL_ALL, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String OPEN_ORDER = "/v1/openOrder";
    /**
     * Query Current Open Order
     * <br><br>
     * GET /v1/openOrder
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * orderId -- optional/long <br>
     * origClientOrderId - optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Query-Current-Open-Order">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Query-Current-Open-Order</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Query-Current-Open-Order">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Query-Current-Open-Order</a>
     */
    public String queryCurrentOpenOrder(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkOrParameters(parameters, "orderId", "origClientOrderId");
        return requestHandler.sendSignedRequest(productUrl, OPEN_ORDER, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String LEVERAGE = "/v1/leverage";
    /**
     * Change user's initial leverage of specific symbol market.
     * <br><br>
     * POST /v1/leverage
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * leverage -- mandatory/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Initial-Leverage">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Initial-Leverage</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Change-Initial-Leverage">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Change-Initial-Leverage</a>
     */
    public String changeInitialLeverage(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "leverage", Integer.class);
        return requestHandler.sendSignedRequest(productUrl, LEVERAGE, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String MARGIN_TYPE = "/v1/marginType";
    /**
     * Change user's margin type
     * <br><br>
     * POST /v1/marginType
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * marginType -- mandatory/enum <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Margin-Type">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Change-Margin-Type</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Change-Margin-Type">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Change-Margin-Type</a>
     */
    public String changeMarginType(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkParameter(parameters, "marginType", String.class);
        return requestHandler.sendSignedRequest(productUrl, MARGIN_TYPE, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String POSITION_MARGIN = "/v1/positionMargin";
    /**
     * Modify Isolated Position Margin
     * <br><br>
     * POST /v1/positionMargin
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * positionSide -- optional/enum <br>
     * amount -- mandatory/decimal <br>
     * type -- mandatory/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Modify-Isolated-Position-Margin">
     *     https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Modify-Isolated-Position-Margin</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Modify-Isolated-Position-Margin">
     *     https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Modify-Isolated-Position-Margin</a>
     */
    public String modifyIsolatedPositionMargin(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        ParameterChecker.checkRequiredParameter(parameters, "amount");
        ParameterChecker.checkParameter(parameters, "type", Integer.class);
        return requestHandler.sendSignedRequest(productUrl, POSITION_MARGIN, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String POSITION_MARGIN_HISTORY = "/v1/positionMargin/history";
    /**
     * Get position margin change history
     * <br><br>
     * GET /v1/positionMargin/history
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * type -- optional/integer <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Get-Position-Margin-Change-History">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Get-Position-Margin-Change-History</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Get-Position-Margin-Change-History">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Get-Position-Margin-Change-History</a>
     */
    public String getPositionMarginChangeHistory(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendSignedRequest(productUrl, POSITION_MARGIN_HISTORY, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String INCOME = "/v1/income";
    /**
     * Get Income History
     * <br><br>
     * GET /v1/income
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * incomeType -- optional/string <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Income-History">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/Get-Income-History</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/account/Get-Income-History">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/account/Get-Income-History</a>
     */
    public String getIncomeHistory(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, INCOME, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String ADL_QUANTILE = "/v1/adlQuantile";
    /**
     * Position ADL Quantile Estimation
     * <br><br>
     * GET /v1/adlQuantile
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Position-ADL-Quantile-Estimation">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Position-ADL-Quantile-Estimation</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Position-ADL-Quantile-Estimation">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Position-ADL-Quantile-Estimation</a>
     */
    public String getAdlQuantile(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, ADL_QUANTILE, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String FORCE_ORDERS = "/v1/forceOrders";
    /**
     * User's Force Orders
     * <br><br>
     * GET /v1/forceOrders
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- optional/string <br>
     * autoCloseType -- optional/enum <br>
     * startTime -- optional/long <br>
     * endTime -- optional/long <br>
     * limit -- optional/integer <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Users-Force-Orders">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/trade/rest-api/Users-Force-Orders</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Users-Force-Orders">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/trade/Users-Force-Orders</a>
     */
    public String getForceOrders(LinkedHashMap<String, Object> parameters) {
        return requestHandler.sendSignedRequest(productUrl, FORCE_ORDERS, parameters, HttpMethod.GET, showLimitUsage);
    }

    private final String COMMISSION_RATE = "/v1/commissionRate";
    /**
     * User's Commission Rate
     * <br><br>
     * GET /v1/commissionRate
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * symbol -- mandatory/string <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/User-Commission-Rate">
     *    https://developers.binance.com/docs/derivatives/usds-margined-futures/account/rest-api/User-Commission-Rate</a>
     * @see <a href="https://developers.binance.com/docs/derivatives/coin-margined-futures/account/User-Commission-Rate">
     *    https://developers.binance.com/docs/derivatives/coin-margined-futures/account/User-Commission-Rate</a>
     */
    public String getCommissionRate(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendSignedRequest(productUrl, COMMISSION_RATE, parameters, HttpMethod.GET, showLimitUsage);
    }
}