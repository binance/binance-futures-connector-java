package com.binance.connector.futures.client.utils.signaturegenerator;

public interface SignatureGenerator {
    String getSignature(String payload);
}
