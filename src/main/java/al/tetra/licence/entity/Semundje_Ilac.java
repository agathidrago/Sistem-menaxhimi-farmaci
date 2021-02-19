package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "semundje_ilac" )
public class Semundje_Ilac {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semundje_ilac_id_seq")
	@SequenceGenerator(name = "semundje_ilac_id_seq", sequenceName = "farmaci.semundje_ilac_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private int semundje;
	private int ilac;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSemundje() {
		return semundje;
	}
	public void setSemundje(int semundje) {
		this.semundje = semundje;
	}
	public int getIlac() {
		return ilac;
	}
	public void setIlac(int ilac) {
		this.ilac = ilac;
	}
	@Override
	public String toString() {
		return "Semundje_Ilac [id=" + id + ", semundje=" + semundje + ", ilac=" + ilac + "]";
	}
	
}
