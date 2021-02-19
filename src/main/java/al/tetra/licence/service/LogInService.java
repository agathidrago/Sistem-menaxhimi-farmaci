package al.tetra.licence.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Perdorues;

@Service("loginService")
public class LogInService {
	
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


}
