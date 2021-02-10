package al.tetra.licence.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class EncryptionUtil {

	private static final String hashPass="!@#$%^^&*";
	
	private static StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(hashPass);
		config.setAlgorithm("PBEWithMD5AndTripleDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		return encryptor;
	}

	public static String encrypt(String text) {
		StringEncryptor textEncryptor = stringEncryptor();
		String encryptedText = textEncryptor.encrypt(text);
		return encryptedText;
	}

	public static String decrypt(String text) {
		StringEncryptor textEncryptor = stringEncryptor();
		String decryptedText = textEncryptor.decrypt(text);
		return decryptedText;
	}

}
