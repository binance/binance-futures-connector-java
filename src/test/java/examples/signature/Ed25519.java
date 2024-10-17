package examples.signature;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.CMFuturesClientImpl;
import com.binance.connector.futures.client.utils.signaturegenerator.Ed25519SignatureGenerator;
import examples.PrivateConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

public final class Ed25519 {
    private Ed25519() {
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        Ed25519SignatureGenerator signGenerator = new Ed25519SignatureGenerator(PrivateConfig.TESTNET_PRIVATE_KEY_PATH); // Private Key file path as input
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