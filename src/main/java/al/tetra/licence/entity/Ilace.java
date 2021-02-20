package al.tetra.licence.entity;

import java.util.Date;

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
@Table(name = "ilace")
public class Ilace {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ilace_id_seq")
	@SequenceGenerator(name = "ilace_id_seq", sequenceName = "farmaci.ilace_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String emer;
	private double sasia;
	@Column(name = "cmim_blerje")
	private double cmimBlerje;
	@Column(name = "cmim_shitje")
	private double cmimShitje;
	private Date date_furnizimi;
	private double madhesia;
	@Column(name = "vetem_me_recete")
	private boolean vetemMeRecete;

	/*@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receteIlac", referencedColumnName = "id")
	private ReceteIlac receteIlac;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semundjeIlac", referencedColumnName = "id")
	private SemundjeIlac semundjeIlac;
*/
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

	public double getSasia() {
		return sasia;
	}

	public void setSasia(double sasia) {
		this.sasia = sasia;
	}

	public double getCmimBlerje() {
		return cmimBlerje;
	}

	public void setCmimBlerje(double cmimBlerje) {
		this.cmimBlerje = cmimBlerje;
	}

	public double getCmimShitje() {
		return cmimShitje;
	}

	public void setCmimShitje(double cmimShitje) {
		this.cmimShitje = cmimShitje;
	}

	public Date getDate_furnizimi() {
		return date_furnizimi;
	}

	public void setDate_furnizimi(Date date_furnizimi) {
		this.date_furnizimi = date_furnizimi;
	}

	public double getMadhesia() {
		return madhesia;
	}

	public void setMadhesia(double madhesia) {
		this.madhesia = madhesia;
	}

	public boolean isVetemMeRecete() {
		return vetemMeRecete;
	}

	public void setVetemMeRecete(boolean vetemMeRecete) {
		this.vetemMeRecete = vetemMeRecete;
	}

	/*public ReceteIlac getReceteIlac() {
		return receteIlac;
	}

	public void setReceteIlac(ReceteIlac receteIlac) {
		this.receteIlac = receteIlac;
	}

	public SemundjeIlac getSemundjeIlac() {
		return semundjeIlac;
	}

	public void setSemundjeIlac(SemundjeIlac semundjeIlac) {
		this.semundjeIlac = semundjeIlac;
	}*/

}
