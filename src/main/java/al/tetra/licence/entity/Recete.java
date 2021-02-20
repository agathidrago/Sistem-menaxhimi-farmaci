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
@Table(name = "recete")
public class Recete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recete_id_seq")
	@SequenceGenerator(name = "recete_id_seq", sequenceName = "farmaci.recete_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private int mjek;
	@Column(name = "date_leshimi")
	private Date dateLeshimi;
	@Column(name = "emer_pacienti")
	private String pacienti;
	/*@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recete", referencedColumnName = "id")
	private ReceteIlac recete;*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMjek() {
		return mjek;
	}
	public void setMjek(int mjek) {
		this.mjek = mjek;
	}
	public Date getDateLeshimi() {
		return dateLeshimi;
	}
	public void setDateLeshimi(Date dateLeshimi) {
		this.dateLeshimi = dateLeshimi;
	}
	/*public ReceteIlac getRecete() {
		return recete;
	}
	public void setRecete(ReceteIlac recete) {
		this.recete = recete;
	}*/
	public String getPacienti() {
		return pacienti;
	}
	public void setPacienti(String pacienti) {
		this.pacienti = pacienti;
	}
	
	
	

}
