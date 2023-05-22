package org.example.feature.secure;

import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

import static java.util.Objects.requireNonNull;

public class PasswordEncrypt {


    public static void test() throws Exception {
        String md5OldPwd = md5("test1");
        String md5NewPwd = md5("test2");
        String total = "salt" + md5OldPwd;

        String oldPassword = DigestUtils.md5DigestAsHex(total.getBytes());
        System.out.println(oldPassword);
    }

    static byte[] hex(String key) {
        String f = DigestUtils.md5DigestAsHex(key.getBytes());
        byte[] keys = f.getBytes();
        byte[] enk = new byte[24];
        System.arraycopy(keys, 0, enk, 0, 24);
        return enk;
    }

    public static String decode(String src, String key) {
        byte[] secret = hex(key);
        byte[] decode = Base64.getDecoder().decode(src);
        byte[] plain = decryptMode(secret, decode);
        return new String(requireNonNull(plain));
    }

    public static byte[] decryptMode(byte[] key, byte[] src) {
        try {
            //生成密钥
            SecretKey secretKey = new SecretKeySpec(key, "DESede");
            //解密
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String md5(String data) throws Exception {
        String strEncrpy = null;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md5.digest(data.getBytes());
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        strEncrpy = hexValue.toString();
        return strEncrpy;
    }

    public static void main(String[] args) throws Exception {
        test();

        String deEmail = decode("4t3ED1fbrXRIOTtxHu+ZeV/FbLaXR1jx", "IZ0Vqouwik1ufyE5y92CwvTdeKnGeLZqyXOp2RfaXWNzYh3RhgZS68OlwGx0TDwE");
        System.out.println(deEmail);
    }
}
