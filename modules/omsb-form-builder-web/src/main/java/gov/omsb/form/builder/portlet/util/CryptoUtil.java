package gov.omsb.form.builder.portlet.util;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import gov.omsb.form.builder.constants.FormBuilderConstants;

public class CryptoUtil {
	/**
	 * Generate Key from password
	 * 
	 * @param password
	 * @param saltBytes
	 * @return
	 * @throws GeneralSecurityException
	 */
	public static SecretKey generateKeyFromPassword(String password, byte[] saltBytes) throws GeneralSecurityException {

		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), saltBytes, 100, 128);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);

		return new SecretKeySpec(secretKey.getEncoded(), "AES");
	}

	/**
	 * convert String into hex byte[]
	 * 
	 * @param java.lang.String
	 * @return byte[] 
	 */
	public static byte[] hexStringToByteArray(String s) {

		int len = s.length();
		byte[] data = new byte[len / 2];

		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}

		return data;

	}

	/**
	 * Decrypt data from encrypted string, secret key spec and iv parameter spec
	 * 
	 * @param encryptedData
	 * @param sKey
	 * @param ivParameterSpec
	 * @return java.lang.String
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws Exception
	 */
	public static String decrypt(String encryptedData, SecretKeySpec sKey, IvParameterSpec ivParameterSpec)
			throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

		Cipher c = Cipher.getInstance(FormBuilderConstants.ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, sKey, ivParameterSpec);
		/* byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData); */
		byte[] decordedValue = Base64.getMimeDecoder().decode(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);

		return decryptedValue;
	}
	
	public static IvParameterSpec generateIv(byte[] iv) {
		return new IvParameterSpec(iv);
	}
	
	public static byte[] getRandomNonce(int numBytes) {
		byte[] nonce = new byte[numBytes];
		new SecureRandom().nextBytes(nonce);
		return nonce;
	}
	
	public static String encrypt(String algorithm, String input, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
}
