package com.example.user.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class UtilMethods {

    public static InputStream getDocument(String base64) {
        byte[] decodeXls = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
        return new ByteArrayInputStream(decodeXls);
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
