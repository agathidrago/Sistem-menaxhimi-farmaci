package al.tetra.licence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pacient")
public class Pacient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacient_id_seq")
	@SequenceGenerator(name = "pacient_id_seq", sequenceName = "farmaci.pacient_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String emer;
	private int mosha;
	private String adresa;
	private String gjinia;
	private Date datelindja;
	private String kontakt;
	/*@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacient", referencedColumnName = "id")
	private SemundjePacient pacient;*/
	
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
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	
/*	public SemundjePacient getPacient() {
		return pacient;
	}
	public void setPacient(SemundjePacient pacient) {
		this.pacient = pacient;
	}*/
	@Override
	public String toString() {
		return "Pacient [id=" + id + ", emer=" + emer + ", mosha=" + mosha + ", adresa=" + adresa + ", gjinia=" + gjinia
				+ ", datelindja=" + datelindja + ", kontakt=" + kontakt +  "]";
	}
	
	
	
	


}
