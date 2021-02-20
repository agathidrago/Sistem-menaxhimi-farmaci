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
@Table(name = "semundje_pacient")
public class SemundjePacient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semundje_pacient_id_seq")
	@SequenceGenerator(name = "semundje_pacient_id_seq", sequenceName = "farmaci.semundje_pacient_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	/*@JsonManagedReference
	@OneToMany(mappedBy = "semundjeP", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Semundje> semundjeP;*/
	private int semundje;

	/*@JsonManagedReference
	@OneToMany(mappedBy = "pacient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pacient> pacient;*/
	private int pacient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSemundje() {
		return semundje;
	}

	public void setSemundjeP(int semundje) {
		this.semundje = semundje;
	}

	public int getPacient() {
		return pacient;
	}

	public void setPacient(int pacient) {
		this.pacient = pacient;
	}

}
