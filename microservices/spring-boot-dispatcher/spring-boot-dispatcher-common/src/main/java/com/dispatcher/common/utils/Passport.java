package com.dispatcher.common.utils;

import io.zestic.coin.core.Base58;
import io.zestic.coin.core.ECKey;
import io.zestic.coin.core.NetworkParameters;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

/**
 * @author deebendukumar
 */
public class Passport {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Passport.class);

    private Passport() {
    }

    public static String generate(String value) {
        Objects.requireNonNull(value, "value must not be null");
        NetworkParameters params = NetworkParameters.prodNet();
        ECKey key = new ECKey(Base58.decodeToBigInteger(value));
        return key.toAddress(params).toString();
    }

    public static String generate(Long value) {
        Objects.requireNonNull(value, "value must not be null");
        NetworkParameters params = NetworkParameters.prodNet();
        ECKey key = new ECKey(Base58.decodeToBigInteger(Long.toString(value)));
        return key.toAddress(params).toString();
    }

    public static void main(String[] args) {
        System.out.println(Passport.generate("919872177944"));
    }

    private String generateUniqueId() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String digest;
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
        digest = Hex.encodeHexString(salt.digest());
        return digest;
    }
}
