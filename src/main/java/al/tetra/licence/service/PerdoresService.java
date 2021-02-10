package al.tetra.licence.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Perdorues;

@Service("perdoruesService")
public class PerdoresService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Perdorues autentifikoPerdorues(String username, String password) {
		try {
			Perdorues p=entityManager.createQuery("select p from Perdorues p where username=:username and password=:password",Perdorues.class)
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			return p;
		}catch(Exception e) {
			return null;
		}	
	}

}
