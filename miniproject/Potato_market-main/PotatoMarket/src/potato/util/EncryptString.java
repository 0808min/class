package potato.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptString {
	final private static String KEY = "v2o5ebsVnv6Xa2PXGtpDZqO4Gp3zNtuJ";
	private static String iv = "JvMxynz9rYXPq6Ay";
	public static String alg = "AES/CBC/PKCS5Padding";
	
	public static String encryptAES256(String str) throws Exception {
		Cipher cipher = Cipher.getInstance(alg);
		SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
		IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

		byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));

		return Base64.getEncoder().encodeToString(encrypted);
	}
}
