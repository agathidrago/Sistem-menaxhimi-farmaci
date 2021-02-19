package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "semundje" )
public class Semundje {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semundje_id_seq")
@SequenceGenerator(name = "semundje_id_seq", sequenceName = "farmaci.semundje_id_seq", allocationSize = 1)
@Column(name = "id", updatable = false, nullable = false)
private Long id;

private String emer;
private String stadi;
private int pacienti;
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
public String getStadi() {
	return stadi;
}
public void setStadi(String stadi) {
	this.stadi = stadi;
}
public int getPacienti() {
	return pacienti;
}
public void setPacienti(int pacienti) {
	this.pacienti = pacienti;
}
@Override
public String toString() {
	return "Semundje [id=" + id + ", emer=" + emer + ", stadi=" + stadi + ", pacienti=" + pacienti + "]";
}

}
