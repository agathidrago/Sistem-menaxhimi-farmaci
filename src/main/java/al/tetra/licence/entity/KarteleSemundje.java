package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kartele_semundje")
public class KarteleSemundje {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kartele_semundje_id_seq")
	@SequenceGenerator(name = "kartele_semundje_id_seq", sequenceName = "farmaci.kartele_semundje_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private int kartele;
	private int semundje;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getKartele() {
		return kartele;
	}
	public void setKartele(int kartele) {
		this.kartele = kartele;
	}
	public int getSemundje() {
		return semundje;
	}
	public void setSemundje(int semundje) {
		this.semundje = semundje;
	}
	


}
