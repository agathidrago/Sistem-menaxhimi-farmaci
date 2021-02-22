package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pacient_ilac")
public class PacientIlac {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacient_ilac_id_seq")
	@SequenceGenerator(name = "pacient_ilac_id_seq", sequenceName = "farmaci.pacient_ilac_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private int ilac;
	private int pacient;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getIlac() {
		return ilac;
	}
	public void setIlac(int ilac) {
		this.ilac = ilac;
	}
	public int getPacient() {
		return pacient;
	}
	public void setPacient(int pacient) {
		this.pacient = pacient;
	}
	
	

}
