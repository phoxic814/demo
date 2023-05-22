package secure;

import org.example.feature.secure.AESUtil;
import org.junit.jupiter.api.Test;

public class AESTest {

    String key = "0123456789ABCDEFGHIJKLMN";
    String str = "testString";
    String iv = "iviviviviviviviv";
    String add = "add";
    int length = 128;

    @Test
    public void ecb() {
        String encrypt = AESUtil.encryptECB(key, str);
        System.out.println(encrypt);

        String decrypt = AESUtil.decryptECB(key, encrypt);
        System.out.println(decrypt);

        System.out.println(decrypt.equals(str));
    }

    @Test
    public void cbc() {
        String encrypt = AESUtil.encryptCBC(key, str, iv);
        System.out.println(encrypt);

        String decrypt = AESUtil.decryptCBC(key, encrypt, iv);
        System.out.println(decrypt);

        System.out.println(decrypt.equals(str));
    }

    @Test
    public void gcm() {
        String encrypt = AESUtil.encryptGCM(key, str, iv, add, length);
        System.out.println(encrypt);

        String decrypt = AESUtil.decryptGCM(key, encrypt, iv, add, length);
        System.out.println(decrypt);

        System.out.println(decrypt.equals(str));
    }
}
