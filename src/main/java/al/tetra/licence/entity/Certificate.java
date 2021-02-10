package al.tetra.licence.entity;

import java.util.Date;

public class Certificate {

	private String fileLocation;
	private String alias;
	private String pass;
	private String keyPass;
	private Date expirationDate;

	public Certificate() {
		super();
	}

	public Certificate(String fileLocation, String alias, String pass, String keyPass, Date expirationDate) {
		super();
		this.fileLocation = fileLocation;
		this.alias = alias;
		this.pass = pass;
		this.keyPass = keyPass;
		this.expirationDate = expirationDate;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getKeyPass() {
		return keyPass;
	}

	public void setKeyPass(String keyPass) {
		this.keyPass = keyPass;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Certificate [fileLocation=" + fileLocation + ", alias=" + alias + ", pass=" + pass + ", keyPass="
				+ keyPass + ", expirationDate=" + expirationDate + "]";
	}

}
