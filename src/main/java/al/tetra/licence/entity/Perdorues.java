package al.tetra.licence.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "perdorues" )
public class Perdorues {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perdorues_id_seq")
	@SequenceGenerator(name = "perdorues_id_seq", sequenceName = "farmaci.perdorues_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String emer;
	private String email;
	private String adresa;
	private String gjinia;
	private Date datelindja;
	private String roli;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmer() {
		return emer;
	}
	public void setEmer(String emer) {
		this.emer = emer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getGjinia() {
		return gjinia;
	}
	public void setGjinia(String gjinia) {
		this.gjinia = gjinia;
	}
	public Date getDatelindja() {
		return datelindja;
	}
	public void setDatelindja(Date datelindja) {
		this.datelindja = datelindja;
	}
	public String getRoli() {
		return roli;
	}
	public void setRoli(String roli) {
		this.roli = roli;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Perdorues [id=" + id + ", emer=" + emer + ", email=" + email + ", adresa=" + adresa + ", gjinia="
				+ gjinia + ", datelindja=" + datelindja + ", roli=" + roli + ", password=" + password + "]";
	}
	
}
