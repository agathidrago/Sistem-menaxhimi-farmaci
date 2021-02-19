package al.tetra.licence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "semundje_ilac")
public class SemundjeIlac {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semundje_ilac_id_seq")
	@SequenceGenerator(name = "semundje_ilac_id_seq", sequenceName = "farmaci.semundje_ilac_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@JsonManagedReference
	@OneToMany(mappedBy = "semundjeI", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Semundje> semundjeI;

	@JsonManagedReference
	@OneToMany(mappedBy = "semundjeIlac", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ilace> ilac;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Semundje> getSemundje() {
		return semundjeI;
	}

	public void setSemundje(List<Semundje> semundjeI) {
		this.semundjeI = semundjeI;
	}

	public List<Ilace> getIlac() {
		return ilac;
	}

	public void setIlac(List<Ilace> ilac) {
		this.ilac = ilac;
	}
	
	

}
