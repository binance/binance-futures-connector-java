package examples.signature;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import com.binance.connector.futures.client.utils.signaturegenerator.RsaSignatureGenerator;
import examples.PrivateConfig;
import java.util.LinkedHashMap;

public final class Rsa {
    private Rsa() {
    }

    public static void main(String[] args) {
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        RsaSignatureGenerator signGenerator = new RsaSignatureGenerator(PrivateConfig.TESTNET_PRIVATE_KEY_PATH); // Private Key file path as input
        CMFuturesClientImpl client = new CMFuturesClientImpl(PrivateConfig.TESTNET_API_KEY, signGenerator, PrivateConfig.CM_BASE_URL, false);

        try {
            String result = client.account().accountInformation(parameters);
            System.out.println(result);
        } catch (BinanceConnectorException e) {
            System.err.println((String) String.format("fullErrMessage: %s", e.getMessage()));
        } catch (BinanceClientException e) {
            System.err.println((String) String.format("fullErrMessage: %s \nerrMessage: %s \nerrCode: %d \nHTTPStatusCode: %d",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode()));
        }
    }
}