package al.tetra.licence.util;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class SignUtil {

	public static final String XML_SCHEMA_NS = "https://eFiskalizimi.tatime.gov.al/FiscalizationService/schema";
	public static final String XML_REGISTER_INVOICE_RESPONSE_ELEMENT = "RegisterInvoiceResponse";
	public static final String XML_REGISTER_INVOICE_REQUEST_ELEMENT = "RegisterInvoiceRequest";
	public static final String XML_REGISTER_TCR_RESPONSE_ELEMENT = "RegisterTCRResponse";
	public static final String XML_REGISTER_TCR_REQUEST_ELEMENT = "RegisterTCRRequest";
	public static final String XML_REGISTER_TCR_CASH_BALANCE_RESPONSE_ELEMENT = "RegisterTCRCashBalanceResponse";
	public static final String XML_REGISTER_TCR_CASH_BALANCE_REQUEST_ELEMENT = "RegisterTCRCashBalanceRequest";
	public static final String XML_REGISTER_WTN_RESPONSE_ELEMENT = "RegisterWTNResponse";
	public static final String XML_REGISTER_WTN_REQUEST_ELEMENT = "RegisterWTNRequest";
	public static final String XML_SIGNATURE_ELEMENT = "Signature";
	public static final String XML_SIG_METHOD = "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
	public static final String XML_REQUEST_ID = "Request";
	public static final String XML_RESPONSE_ID = "Response";
	public static final String KEY_ALGORITHM = "RSA";

	private static final XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance("DOM");

	private SignUtil() {
	}

	public static String signDocument(Document doc, String eleToSign, String eleToSignId, X509Certificate signCert,
			Key signKey) throws Exception {

		NodeList nodeToSignList = doc.getElementsByTagNameNS(XML_SCHEMA_NS, eleToSign);
		if (nodeToSignList.getLength() == 0) {
			throw new Exception(String.format("XML element %s not found", eleToSign));
		}
		Node nodeToSign = nodeToSignList.item(0);

		List<Transform> transformList = new ArrayList<>();
		transformList.add(xmlSigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
		transformList.add(xmlSigFactory.newTransform(CanonicalizationMethod.EXCLUSIVE, (C14NMethodParameterSpec) null));

		Reference ref = xmlSigFactory.newReference("#" + eleToSignId,
				xmlSigFactory.newDigestMethod(DigestMethod.SHA256, null), transformList, null, null);

		SignatureMethod signatureMethod = xmlSigFactory.newSignatureMethod(XML_SIG_METHOD,
				(SignatureMethodParameterSpec) null);

		SignedInfo signedInfo = xmlSigFactory.newSignedInfo(xmlSigFactory
				.newCanonicalizationMethod(CanonicalizationMethod.EXCLUSIVE, (C14NMethodParameterSpec) null),
				signatureMethod, Collections.singletonList(ref));

		List<X509Certificate> certificateList = new ArrayList<>();
		certificateList.add(signCert);

		KeyInfoFactory keyInfoFactory = xmlSigFactory.getKeyInfoFactory();
		X509Data x509Data = keyInfoFactory.newX509Data(certificateList);
		KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

		DOMSignContext dsc = new DOMSignContext(signKey, nodeToSign);
		dsc.setIdAttributeNS((Element) nodeToSign, null, "Id");

		XMLSignature signature = xmlSigFactory.newXMLSignature(signedInfo, keyInfo);

		signature.sign(dsc);

		TransformerFactory transformFactory = TransformerFactory.newInstance();
		Transformer transformer = transformFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter sw = new StringWriter();

		StreamResult streamRes = new StreamResult(sw);
		transformer.transform(new DOMSource(doc), streamRes);
		return sw.toString();

		
		// System.err.println("Signed document is: " + sw.toString());
	}

	public static Key getSignKey(String keyStoreType, String keyStoreLocation, String keyStorePass, String keyAlias,
			String keyPass) throws Exception {

		/*
		 * URL res = SignUtil.class.getClassLoader().getResource(keyStoreLocation);
		 * 
		 * String path = Paths.get(res.toURI()).toFile().getAbsolutePath(); path =
		 * path.replace("\\", "\\\\"); System.err.println(path);
		 */

		try (FileInputStream fileInputStream = new FileInputStream(keyStoreLocation)) {
			KeyStore keyStore = KeyStore.getInstance(keyStoreType);
			keyStore.load(fileInputStream, keyStorePass.toCharArray());
			return keyStore.getKey(keyAlias, keyPass.toCharArray());
		} catch (Exception e) {
			throw e;
		}

	}

	public static X509Certificate getSignCert(String keyStoreType, String keyStoreLocation, String keyStorePass,
			String keyAlias, String keyPass) throws Exception {

		/*
		 * URL res = SignUtil.class.getClassLoader().getResource(keyStoreLocation);
		 * 
		 * String path = Paths.get(res.toURI()).toFile().getAbsolutePath(); path =
		 * path.replace("\\", "\\\\"); System.err.println(path);
		 */

		try (FileInputStream fileInputStream = new FileInputStream(keyStoreLocation)) {
			KeyStore keyStore = KeyStore.getInstance(keyStoreType);
			keyStore.load(fileInputStream, keyStorePass.toCharArray());
			return (X509Certificate) keyStore.getCertificate(keyAlias);
		} catch (Exception e) {
			throw e;
		}

	}

	public static Node getSignatureNode(Document doc) throws Exception {

		NodeList signatureNodeList = doc.getElementsByTagNameNS(XMLSignature.XMLNS, SignUtil.XML_SIGNATURE_ELEMENT);
		if (signatureNodeList.getLength() == 0) {
			throw new Exception(String.format("XML element %s not found.", SignUtil.XML_SIGNATURE_ELEMENT));
		}
		return signatureNodeList.item(0);
	}


	public static String signConcatenateValue(String concatenatedValues, Key signKey) throws Exception {

		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign((PrivateKey) signKey);
		signature.update(concatenatedValues.getBytes());
		byte[] signatureValueHex = signature.sign();
		return DatatypeConverter.printHexBinary(signatureValueHex).toUpperCase();
	}

	public static String calculateMD5(String value) throws Exception {

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md5Value = md.digest(value.getBytes());
		return DatatypeConverter.printHexBinary(md5Value).toUpperCase();
	}

	
}
