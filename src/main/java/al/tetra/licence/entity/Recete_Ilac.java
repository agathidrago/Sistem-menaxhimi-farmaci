package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "recete_ilac" )
public class Recete_Ilac {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recete_ilac_id_seq")
	@SequenceGenerator(name = "recete_ilac_id_seq", sequenceName = "farmaci.recete_ilac_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	 private int ilac;
	 private int recete;
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
	public int getRecete() {
		return recete;
	}
	public void setRecete(int recete) {
		this.recete = recete;
	}
	@Override
	public String toString() {
		return "Recete_Ilac [id=" + id + ", ilac=" + ilac + ", recete=" + recete + "]";
	}
	 
}
