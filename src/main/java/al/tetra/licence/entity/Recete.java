package al.tetra.licence.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "recete" )
public class Recete {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recete_id_seq")
	@SequenceGenerator(name = "recete_id_seq", sequenceName = "farmaci.recete_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private Date data_leshimit;
	private boolean date_leshimi;
	private int ilace;
	private int mjeku;
	private int pacienti;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData_leshimit() {
		return data_leshimit;
	}
	public void setData_leshimit(Date data_leshimit) {
		this.data_leshimit = data_leshimit;
	}
	public boolean isDate_leshimi() {
		return date_leshimi;
	}
	public void setDate_leshimi(boolean date_leshimi) {
		this.date_leshimi = date_leshimi;
	}
	public int getIlace() {
		return ilace;
	}
	public void setIlace(int ilace) {
		this.ilace = ilace;
	}
	public int getMjeku() {
		return mjeku;
	}
	public void setMjeku(int mjeku) {
		this.mjeku = mjeku;
	}
	public int getPacienti() {
		return pacienti;
	}
	public void setPacienti(int pacienti) {
		this.pacienti = pacienti;
	}
	@Override
	public String toString() {
		return "Recete [id=" + id + ", data_leshimit=" + data_leshimit + ", date_leshimi=" + date_leshimi + ", ilace="
				+ ilace + ", mjeku=" + mjeku + ", pacienti=" + pacienti + "]";
	}
	
}
