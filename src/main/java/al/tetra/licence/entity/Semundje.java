package al.tetra.licence.entity;

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
@Table(name = "semundje")
public class Semundje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semundje_id_seq")
	@SequenceGenerator(name = "semundje_id_seq", sequenceName = "farmaci.semundje_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String emer;
	private String stadi;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semundjeI", referencedColumnName = "id")
	private SemundjeIlac semundjeI;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semundjeP", referencedColumnName = "id")
	private SemundjePacient semundjeP;

	
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
	public String getStadi() {
		return stadi;
	}
	public void setStadi(String stadi) {
		this.stadi = stadi;
	}
	public SemundjeIlac getSemundjeIlac() {
		return semundjeI;
	}
	public void setSemundjeIlac(SemundjeIlac semundjeI) {
		this.semundjeI = semundjeI;
	}
	public SemundjeIlac getSemundjeI() {
		return semundjeI;
	}
	public void setSemundjeI(SemundjeIlac semundjeI) {
		this.semundjeI = semundjeI;
	}
	public SemundjePacient getSemundjeP() {
		return semundjeP;
	}
	public void setSemundjeP(SemundjePacient semundjeP) {
		this.semundjeP = semundjeP;
	}
	

	

}
