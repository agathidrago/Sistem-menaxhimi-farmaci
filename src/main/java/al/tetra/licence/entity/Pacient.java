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
@Table(name = "pacient" )
public class Pacient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacient_id_seq")
	@SequenceGenerator(name = "pacient_id_seq", sequenceName = "farmaci.pacient_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String emer;
	private int mosha;
	private Date datelindja;
	private String adresa;
	private String gjinia;
	private String kontakt;
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
	public int getMosha() {
		return mosha;
	}
	public void setMosha(int mosha) {
		this.mosha = mosha;
	}
	public Date getDatelindja() {
		return datelindja;
	}
	public void setDatelindja(Date datelindja) {
		this.datelindja = datelindja;
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
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	@Override
	public String toString() {
		return "Pacient [id=" + id + ", emer=" + emer + ", mosha=" + mosha + ", datelindja=" + datelindja + ", adresa="
				+ adresa + ", gjinia=" + gjinia + ", kontakt=" + kontakt + "]";
	}
	
}
