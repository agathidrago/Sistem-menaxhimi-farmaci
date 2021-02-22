package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kartele")
public class Kartele {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kartele_id_seq")
	@SequenceGenerator(name = "kartele_id_seq", sequenceName = "farmaci.kartele_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private int pacient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPacient() {
		return pacient;
	}

	public void setPacient(int pacient) {
		this.pacient = pacient;
	}

}
