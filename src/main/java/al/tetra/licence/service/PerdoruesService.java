package al.tetra.licence.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Perdorues;
import io.micrometer.core.instrument.util.StringUtils;

@Service("perdoruesService")
@Transactional
public class PerdoruesService {

	@PersistenceContext
	private EntityManager entityManager;

	public Perdorues updatePerdorues(String emer, String email, String username, Long id,Long loggedUser) {
		System.err.println("hyri 1");
		Perdorues p = getPerodruesTeLoguar();
		if(StringUtils.isBlank(emer))
			emer=p.getEmer();
		if(StringUtils.isBlank(email))
			email=p.getEmail();
		if(StringUtils.isBlank(username))
			username=p.getUsername();
		System.err.println("Peroduresi"+p.toString());

		try {

			p.setEmer(emer);
			p.setEmail(email);
			p.setUsername(username);
			p.setDatelindja(p.getDatelindja());
			p.setFjalekalim(p.getFjalekalim());
			p.setRoli(p.getRoli());
			p.setGjinia(p.getGjinia());
			p.setId(id);
			entityManager.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;

	}

	public Perdorues getPerodruesTeLoguar() {
		try {
			System.err.println("hyri");
			Perdorues p = entityManager
					.createQuery("select p from Perdorues p where p.eshteLoguar=:loguar",Perdorues.class)
					.setParameter("loguar", 1).getSingleResult();
			return p;
		} catch (Exception e) {

			return null;
		}

	}

}
