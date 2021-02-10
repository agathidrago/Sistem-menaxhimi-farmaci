package al.tetra.licence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "perdorues" )
public class Perdorues {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perdorues_id_seq")
	@SequenceGenerator(name = "perdorues_id_seq", sequenceName = "farmaci.perdorues_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String emer;
	private String email;
	private String username;
	private String password;
	private String roli;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoli() {
		return roli;
	}
	public void setRoli(String roli) {
		this.roli = roli;
	}
	@Override
	public String toString() {
		return "Perdorues [id=" + id + ", emer=" + emer + ", email=" + email + ", username=" + username + ", password="
				+ password + ", roli=" + roli + "]";
	}
	
	
}
