package al.tetra.licence.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service("licenceService")
public class LicenceService {

	public void test() {
		System.err.println("Test is running");
	}
	
	public String calculateSecurityHash(String stringInput, String algorithmName)
			 {
		String hexMessageEncode = "";
		byte[] buffer = stringInput.getBytes();
		MessageDigest messageDigest;
		try {
			messageDigest =MessageDigest.getInstance(algorithmName);
			messageDigest.update(buffer);
			byte[] messageDigestBytes = messageDigest.digest();
			for (int index = 0; index < messageDigestBytes.length; index++) {
				int countEncode = messageDigestBytes[index] & 0xff;
				if (Integer.toHexString(countEncode).length() == 1)
					hexMessageEncode = hexMessageEncode + "0";
				hexMessageEncode = hexMessageEncode + Integer.toHexString(countEncode);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hexMessageEncode;
	}

	public String separateHash(String tf1) {
		String serialNumberEncoded = calculateSecurityHash(tf1, "MD2")
				+ calculateSecurityHash(tf1, "MD5") + calculateSecurityHash(tf1, "SHA1");
	
		String serialNumberEncodedSpecific = "" + serialNumberEncoded.charAt(100) + serialNumberEncoded.charAt(50)
				+ serialNumberEncoded.charAt(32) + serialNumberEncoded.charAt(76) + "-" + serialNumberEncoded.charAt(73)
				+ serialNumberEncoded.charAt(72) + serialNumberEncoded.charAt(2) + serialNumberEncoded.charAt(91)
				+ serialNumberEncoded.charAt(47) + "-" + serialNumberEncoded.charAt(98) + serialNumberEncoded.charAt(65)
				+ serialNumberEncoded.charAt(27) + serialNumberEncoded.charAt(53) + "-" + serialNumberEncoded.charAt(18)
				+ serialNumberEncoded.charAt(85) + serialNumberEncoded.charAt(99) + serialNumberEncoded.charAt(15)
				+ serialNumberEncoded.charAt(102);
		return serialNumberEncodedSpecific;
	}
}
