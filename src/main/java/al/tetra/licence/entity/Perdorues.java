package al.tetra.licence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "perdorues")
public class Perdorues {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perdorues_id_seq")
	@SequenceGenerator(name = "perdorues_id_seq", sequenceName = "farmaci.perdorues_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String emer;
	private String mbiemer;
	private String email;
	private String adresa;
	private String gjinia;
	private String username;
	private String fjalekalim;
	private String roli;
	@Column(name = "nr_tel")
	private String nrTel;
	@Column(name = "eshte_loguar")
	private int eshteLoguar;
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
	public String getMbiemer() {
		return mbiemer;
	}
	public void setMbiemer(String mbiemer) {
		this.mbiemer = mbiemer;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFjalekalim() {
		return fjalekalim;
	}
	public void setFjalekalim(String fjalekalim) {
		this.fjalekalim = fjalekalim;
	}
	public String getRoli() {
		return roli;
	}
	public void setRoli(String roli) {
		this.roli = roli;
	}
	public int getEshteLoguar() {
		return eshteLoguar;
	}
	public void setEshteLoguar(int eshteLoguar) {
		this.eshteLoguar = eshteLoguar;
	}
	
	public String getNrTel() {
		return nrTel;
	}
	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}

	
	
	
	
}
