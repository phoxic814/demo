package org.example.feature.secure;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * reference: http://xxgblog.com/2021/08/03/java-aes/
 *
 */
public class AESUtil {

    private static String AES = "AES";

    /**
     * 填充方式: ECB, 缺點 同樣的明文同樣密碼快
     */
    public static final String AES_ECB = "AES/ECB/PKCS5Padding";

    public static final String AES_CBC = "AES/CBC/PKCS5Padding";

    public static final String AES_GCM = "AES/GCM/NoPadding";

    /**
     * key must be length 16/24/32
     * @param keyStr
     * @return
     */
    public static Key getKey(String keyStr) {
        return new SecretKeySpec(keyStr.getBytes(), AES);
    }

    public static Key getKey(String keyStr, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(keyStr.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), AES);
    }

    // default
    public static Cipher cipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(AES_ECB);
    }

    public static Cipher cipher(String aesType) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(aesType);
    }

    public static String encryptECB(String keyStr, String text) {
        byte[] encrypt = null;
        try {
            Key key = getKey(keyStr);
            Cipher cipher = cipher(AES_ECB);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(encrypt);
    }

    public static String decryptECB(String keyStr, String encrypt) {
        byte[] decrypt = null;
        try {
            Key key = getKey(keyStr);
            Cipher cipher = cipher(AES_ECB);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(Base64.getDecoder().decode(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(decrypt);
    }

    /**
     * CBC需定義iv向量, iv must be 16 length
     */
    public static String encryptCBC(String keyStr, String text, String iv) {
        byte[] encrypt = null;
        try {
            Key key = getKey(keyStr);
            Cipher cipher = cipher(AES_CBC);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv.getBytes()));
            encrypt = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(encrypt);
    }

    public static String decryptCBC(String keyStr, String encrypt, String iv) {
        byte[] decrypt = null;
        try {
            Key key = getKey(keyStr);
            Cipher cipher = cipher(AES_CBC);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv.getBytes()));
            decrypt = cipher.doFinal(Base64.getDecoder().decode(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(decrypt);
    }

    /**
     * iv: 向量
     * add: additional authenticated data (AAD)，可以为空
     * authentication tag 比特位数，必须是 128、120、112、104、96 之一
     */
    public static String encryptGCM(String keyStr, String text, String iv, String add, int length) {
        byte[] encrypt = null;
        try {
            Key key = getKey(keyStr);
            Cipher cipher = cipher(AES_GCM);
            cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(length, iv.getBytes()));
            cipher.updateAAD(add.getBytes());
            encrypt = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int bytesLength = length / 8;
        // 密文
        byte[] ciphertext = Arrays.copyOfRange(encrypt, 0, encrypt.length - bytesLength);
        // authentication tag
        byte[] tag = Arrays.copyOfRange(encrypt, encrypt.length - bytesLength, encrypt.length);

        return Base64.getEncoder().encodeToString(encrypt);
    }

    public static String decryptGCM(String keyStr, String encrypt, String iv, String add, int length) {
        byte[] decrypt = null;
        try {
            Key key = getKey(keyStr);
            Cipher cipher = cipher(AES_GCM);
            cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(length, iv.getBytes()));
            cipher.updateAAD(add.getBytes());
            decrypt = cipher.doFinal(Base64.getDecoder().decode(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(decrypt);
    }
}
