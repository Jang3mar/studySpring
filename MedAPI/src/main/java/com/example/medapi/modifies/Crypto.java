package com.example.medapi.modifies;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Crypto {

    private static final String ALGORITHM = "AES";

    public static String encrypt(String data) throws Exception {
        // Генерируем случайный ключ
        SecretKey secretKey = generateSecretKey();

        // Шифруем строку
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        // Конкатенируем зашифрованные данные с ключом, разделяя их символом ":"
        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes) + ":" +
                Base64.getEncoder().encodeToString(secretKey.getEncoded());

        return encryptedString;
    }

    public static String decrypt(String encryptedData) throws Exception {
        // Разбиваем зашифрованные данные и ключ по символу ":"
        String[] parts = encryptedData.split(":");
        String encryptedString = parts[0];
        String keyString = parts[1];

        // Декодируем ключ
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        SecretKey secretKey = new SecretKeySpec(keyBytes, ALGORITHM);

        // Расшифровываем строку
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes);
    }
    private static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128); // Размер ключа (может быть 128, 192 или 256 бит)
        return keyGenerator.generateKey();
    }
}
