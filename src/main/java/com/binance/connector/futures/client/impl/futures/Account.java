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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#change-position-mode-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#change-position-mode-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#change-position-mode-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#change-position-mode-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#get-current-position-mode-user_data">
     *     https://binance-docs.github.io/apidocs/futures/en/#get-current-position-mode-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#get-current-position-mode-user_data">
     *     https://binance-docs.github.io/apidocs/delivery/en/#get-current-position-mode-user_data</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#new-order-trade">
     *    https://binance-docs.github.io/apidocs/futures/en/#new-order-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#new-order-trade">
     *    https://binance-docs.github.io/apidocs/delivery/en/#new-order-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#place-multiple-orders-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#place-multiple-orders-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#modify-multiple-orders-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#modify-multiple-orders-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#query-order-user_data">
     *     https://binance-docs.github.io/apidocs/futures/en/#query-order-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#query-order-user_data">
     *     https://binance-docs.github.io/apidocs/delivery/en/#query-order-user_data</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#cancel-order-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#cancel-order-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#cancel-order-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#cancel-order-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#cancel-all-open-orders-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#cancel-all-open-orders-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#cancel-all-open-orders-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#cancel-all-open-orders-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#cancel-multiple-orders-trade">
     *     hhttps://binance-docs.github.io/apidocs/futures/en/#cancel-multiple-orders-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#cancel-multiple-orders-trade">
     *     hhttps://binance-docs.github.io/apidocs/delivery/en/#cancel-multiple-orders-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#auto-cancel-all-open-orders-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#auto-cancel-all-open-orders-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#auto-cancel-all-open-orders-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#auto-cancel-all-open-orders-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#query-current-open-order-user_data">
     *    https://binance-docs.github.io/apidocs/futures/en/#query-current-open-order-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#query-current-open-order-user_data">
     *    https://binance-docs.github.io/apidocs/delivery/en/#query-current-open-order-user_data</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#change-initial-leverage-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#change-initial-leverage-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#change-initial-leverage-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#change-initial-leverage-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#change-margin-type-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#change-margin-type-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#change-margin-type-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#change-margin-type-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#modify-isolated-position-margin-trade">
     *     https://binance-docs.github.io/apidocs/futures/en/#modify-isolated-position-margin-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#modify-isolated-position-margin-trade">
     *     https://binance-docs.github.io/apidocs/delivery/en/#modify-isolated-position-margin-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#get-position-margin-change-history-trade">
     *    https://binance-docs.github.io/apidocs/futures/en/#get-position-margin-change-history-trade</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#get-position-margin-change-history-trade">
     *    https://binance-docs.github.io/apidocs/delivery/en/#get-position-margin-change-history-trade</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#get-income-history-user_data">
     *    https://binance-docs.github.io/apidocs/futures/en/#get-income-history-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#get-income-history-user_data">
     *    https://binance-docs.github.io/apidocs/delivery/en/#get-income-history-user_data</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#position-adl-quantile-estimation-user_data">
     *    https://binance-docs.github.io/apidocs/futures/en/#position-adl-quantile-estimation-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#position-adl-quantile-estimation-user_data">
     *    https://binance-docs.github.io/apidocs/delivery/en/#position-adl-quantile-estimation-user_data</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#user-39-s-force-orders-user_data">
     *    https://binance-docs.github.io/apidocs/futures/en/#user-39-s-force-orders-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#user-39-s-force-orders-user_data">
     *    https://binance-docs.github.io/apidocs/delivery/en/#user-39-s-force-orders-user_data</a>
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
     * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#user-commission-rate-user_data">
     *    https://binance-docs.github.io/apidocs/futures/en/#user-commission-rate-user_data</a>
     * @see <a href="https://binance-docs.github.io/apidocs/delivery/en/#user-commission-rate-user_data">
     *    https://binance-docs.github.io/apidocs/delivery/en/#user-commission-rate-user_data</a>
     */
    public String getCommissionRate(LinkedHashMap<String, Object> parameters) {
        ParameterChecker.checkParameter(parameters, "symbol", String.class);
        return requestHandler.sendSignedRequest(productUrl, COMMISSION_RATE, parameters, HttpMethod.GET, showLimitUsage);
    }

    /**
     * <h2>USDⓈ-Margined Trade Endpoints</h2>
     * All endpoints under the
     * <a href="https://binance-docs.github.io/apidocs/futures/en/#account-trades-endpoints">Futures Account/Trade Endpoint</a>
     * section of the API documentation will be implemented in this class.
     * <br>
     * Response will be returned in <i>String format</i>.
     */
    public static class UMAccount extends Account {
        public UMAccount(String productUrl, String apiKey, String secretKey, boolean showLimitUsage, ProxyAuth proxy) {
            super(productUrl, apiKey, secretKey, showLimitUsage, proxy);
        }

        private final String MULTI_ASSETS_MARGIN = "/v1/multiAssetsMargin";
        /**
         * Change user's Multi-Assets mode (Multi-Assets Mode or Single-Asset Mode) on Every symbol
         * <br><br>
         * POST /v1/multiAssetsMargin
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * multiAssetsMargin -- mandatory/string <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#change-multi-assets-mode-trade">
         *     https://binance-docs.github.io/apidocs/futures/en/#change-multi-assets-mode-trade</a>
         */
        public String changeMultiAssetsMode(LinkedHashMap<String, Object> parameters) {
            ParameterChecker.checkParameter(parameters, "dualSidePosition", String.class);
            return getRequestHandler().sendSignedRequest(getProductUrl(), MULTI_ASSETS_MARGIN, parameters, HttpMethod.POST, getShowLimitUsage());
        }

        /**
         * Get user's Multi-Assets mode (Multi-Assets Mode or Single-Asset Mode) on Every symbol
         * <br><br>
         * GET /v1/multiAssetsMargin
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#get-current-multi-assets-mode-user_data">
         *     https://binance-docs.github.io/apidocs/futures/en/#get-current-multi-assets-mode-user_data</a>
         */
        public String getCurrentMultiAssetMode(LinkedHashMap<String, Object> parameters) {
            return getRequestHandler().sendSignedRequest(getProductUrl(), MULTI_ASSETS_MARGIN, parameters, HttpMethod.GET, getShowLimitUsage());
        }


        /**
         * Get all open orders on a symbol. Careful when accessing this with no symbol.
         * <br><br>
         * GET /v1/openOrders
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * symbol -- optional/string <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#current-all-open-orders-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#current-all-open-orders-user_data</a>
         */
        public String currentAllOpenOrders(LinkedHashMap<String, Object> parameters) {
            return super.currentAllOpenOrders(parameters);
        }

        /**
         * Get all open orders on a symbol. Careful when accessing this with no symbol.
         * <br><br>
         * GET /v1/allOrders
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * symbol -- mandatory/string <br>
         * orderId -- optional/long <br>
         * startTime -- optional/long <br>
         * endTime -- optional/long <br>
         * limit -- optional/integer <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#all-orders-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#all-orders-user_data</a>
         */
        public String allOrders(LinkedHashMap<String, Object> parameters) {
            ParameterChecker.checkParameter(parameters, "symbol", String.class);
            return super.allOrders(parameters);
        }

        private final String BALANCE = "/v2/balance";
        /**
         * Get Futures Account Balance
         * <br><br>
         * GET /v2/balance
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#futures-account-balance-v2-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#futures-account-balance-v2-user_data</a>
         */
        public String futuresAccountBalance(LinkedHashMap<String, Object> parameters) {
            return getRequestHandler().sendSignedRequest(getProductUrl(), BALANCE, parameters, HttpMethod.GET, getShowLimitUsage());
        }

        private final String ACCOUNT_INFORMATION = "/v2/account";
        /**
         * Get current account information. User in single-asset/ multi-assets mode will see different value, see comments in response section for detail.
         * <br><br>
         * GET /v2/account
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#account-information-v2-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#account-information-v2-user_data</a>
         */
        public String accountInformation(LinkedHashMap<String, Object> parameters) {
            return getRequestHandler().sendSignedRequest(getProductUrl(), ACCOUNT_INFORMATION, parameters, HttpMethod.GET, getShowLimitUsage());
        }

        private final String POSITION_RISK = "/v2/positionRisk";
        /**
         * Get current position information.
         * <br><br>
         * GET /v2/positionRisk
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * symbol -- optional/string <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#position-information-v2-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#position-information-v2-user_data</a>
         */
        public String positionInformation(LinkedHashMap<String, Object> parameters) {
            return getRequestHandler().sendSignedRequest(getProductUrl(), POSITION_RISK, parameters, HttpMethod.GET, getShowLimitUsage());
        }

        /**
         * Get trades for a specific account and symbol.
         * <br><br>
         * GET /v1/userTrades
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * symbol -- mandatory/string <br>
         * startTime -- optional/long <br>
         * endTime -- optional/long <br>
         * fromId -- optional/long <br>
         * limit -- optional/integer <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#account-trade-list-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#account-trade-list-user_data</a>
         */
        public String accountTradeList(LinkedHashMap<String, Object> parameters) {
            ParameterChecker.checkParameter(parameters, "symbol", String.class);
            return super.accountTradeList(parameters);
        }

        /**
         * Notional and Leverage Brackets
         * <br><br>
         * GET /v1/leverageBracket
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * symbol -- optional/string <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#notional-and-leverage-brackets-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#notional-and-leverage-brackets-user_data</a>
         */
        public String getLeverageBracket(LinkedHashMap<String, Object> parameters) {
            return super.getLeverageBracket(parameters);
        }

        private final String API_TRADING_STATUS = "/v1/apiTradingStatus";
        /**
         * Futures Trading Quantitative Rules Indicators
         * For more information on this, please refer to the <a href="https://www.binance.com/en/support/faq/4f462ebe6ff445d4a170be7d9e897272">Futures Trading Quantitative Rules</a>
         * <br><br>
         * GET /v1/apiTradingStatus
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * symbol -- optional/string <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#futures-trading-quantitative-rules-indicators-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#futures-trading-quantitative-rules-indicators-user_data</a>
         */
        public String getTradingRulesIndicators(LinkedHashMap<String, Object> parameters) {
            return getRequestHandler().sendSignedRequest(getProductUrl(), API_TRADING_STATUS, parameters, HttpMethod.GET, getShowLimitUsage());
        }

        private final String INCOME_ASYN = "/v1/income/asyn";
        /**
         * Get Download Id For Futures Transaction History
         * <br><br>
         * GET /v1/income/asyn
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * startTime -- optional/long <br>
         * endTime -- optional/long <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#get-download-id-for-futures-transaction-history-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#get-download-id-for-futures-transaction-history-user_data</a>
         */
        public String futuresDownloadId(LinkedHashMap<String, Object> parameters) {
            return getRequestHandler().sendSignedRequest(getProductUrl(), INCOME_ASYN, parameters, HttpMethod.GET, getShowLimitUsage());
        }

        private final String INCOME_ASYN_ID = "/v1/income/asyn/id";
        /**
         * Get Futures Transaction History Download Link by Id
         * <br><br>
         * GET /v1/income/asyn/id
         * <br>
         * @param
         * parameters LinkedHashedMap of String,Object pair
         *            where String is the name of the parameter and Object is the value of the parameter
         * <br><br>
         * downloadId -- mandatory/string <br>
         * recvWindow -- optional/long <br>
         * @return String
         * @see <a href="https://binance-docs.github.io/apidocs/futures/en/#get-futures-transaction-history-download-link-by-id-user_data">
         *    https://binance-docs.github.io/apidocs/futures/en/#get-futures-transaction-history-download-link-by-id-user_data</a>
         */
        public String futuresDownloadLink(LinkedHashMap<String, Object> parameters) {
            ParameterChecker.checkParameter(parameters, "downloadId", String.class);
            return getRequestHandler().sendSignedRequest(getProductUrl(), INCOME_ASYN_ID, parameters, HttpMethod.GET, getShowLimitUsage());
        }
    }
}