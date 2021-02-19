package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ilace" )
public class Ilace {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ilace_id_seq")
	@SequenceGenerator(name = "ilace_id_seq", sequenceName = "farmaci.ilace_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String emer;
	private int sasia;
	private float cmim_blerje;
	private float cmim_shitje;
	private String furnitor;
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
	public int getSasia() {
		return sasia;
	}
	public void setSasia(int sasia) {
		this.sasia = sasia;
	}
	public float getCmim_blerje() {
		return cmim_blerje;
	}
	public void setCmim_blerje(float cmim_blerje) {
		this.cmim_blerje = cmim_blerje;
	}
	public float getCmim_shitje() {
		return cmim_shitje;
	}
	public void setCmim_shitje(float cmim_shitje) {
		this.cmim_shitje = cmim_shitje;
	}
	public String getFurnitor() {
		return furnitor;
	}
	public void setFurnitor(String furnitor) {
		this.furnitor = furnitor;
	}
	@Override
	public String toString() {
		return "Ilace [id=" + id + ", emer=" + emer + ", sasia=" + sasia + ", cmim_blerje=" + cmim_blerje
				+ ", cmim_shitje=" + cmim_shitje + ", furnitor=" + furnitor + "]";
	}
	
}
