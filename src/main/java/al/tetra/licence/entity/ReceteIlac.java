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
@Table(name = "recete_ilac")
public class ReceteIlac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recete_ilac_id_seq")
	@SequenceGenerator(name = "recete_ilac_id_seq", sequenceName = "farmaci.recete_ilac_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	/*@JsonManagedReference
	@OneToMany(mappedBy = "recete", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Recete> recete;*/
	/*@JsonManagedReference
	@OneToMany(mappedBy = "recete", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)*/
	private int recete;
	
	/*@JsonManagedReference
	@OneToMany(mappedBy = "receteIlac", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ilace> ilac;*/
	/*@JsonManagedReference
	@OneToMany(mappedBy = "receteIlac", cascade = CascadeType.ALL, orphanRemoval = true)*/
	private int ilac;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRecete() {
		return recete;
	}

	public void setRecete(int recete) {
		this.recete = recete;
	}

	/*public List<Ilace> getIlac() {
		return ilac;
	}

	public void setIlac(List<Ilace> ilac) {
		this.ilac = ilac;
	}*/
	public int getIlac() {
		return ilac;
	}

	public void setIlac(int ilac) {
		this.ilac = ilac;
	}

	
}
