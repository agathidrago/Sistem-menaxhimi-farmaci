package al.tetra.licence.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Perdorues;

@Service("perdoruesService")
public class PerdoresService {

	@PersistenceContext
	private EntityManager entityManager;

	public Perdorues autentifikoPerdorues(String username, String fjalekalim) {
		try {
			Perdorues p = entityManager
					.createQuery("select p from Perdorues p where username=:username and fjalekalim=:fjalekalim",
							Perdorues.class)
					.setParameter("username", username).setParameter("fjalekalim", fjalekalim).getSingleResult();
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("null")
	public Perdorues updatePerdorues(String emer, String email, String username, Long id) {
		Perdorues p = null;

		try {
		p.setEmer(emer);
		p.setEmail(email);
		p.setUsername(username);
		p.setId(id);
		entityManager.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;

	}
	
	public Perdorues getPerodruesTeLoguar() {
		try {
			Perdorues p = entityManager
					.createQuery("select p from Perdorues p where p.eshteLoguar=1",
							Perdorues.class).getSingleResult();
			System.err.println("Hyri ketu.PErdorues: "+p.toString());
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	

}
