package al.tetra.licence.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Ilace;
import al.tetra.licence.entity.Pacient;
import al.tetra.licence.entity.Perdorues;
import io.micrometer.core.instrument.util.StringUtils;
import javafx.scene.control.Label;

@Service("perdoruesService")
@Transactional
public class PerdoruesService {

	@PersistenceContext
	private EntityManager entityManager;

	public Perdorues updatePerdorues(String emer, String email, String username,String address, Long loggedUser) {
		System.err.println("hyri 1");
		Perdorues p = getPerodruesTeLoguar();
		if (StringUtils.isBlank(emer))
			emer = p.getEmer();
		if (StringUtils.isBlank(email))
			email = p.getEmail();
		if (StringUtils.isBlank(username))
			username = p.getUsername();
		if (StringUtils.isBlank(address))
			address = p.getAdresa();
		System.err.println("Peroduresi" + p.toString());

		try {

			p.setEmer(emer);
			p.setEmail(email);
			p.setUsername(username);
			p.setFjalekalim(p.getFjalekalim());
			p.setRoli(p.getRoli());
			p.setGjinia(p.getGjinia());
			p.setId(p.getId());
			p.setAdresa(address);
			entityManager.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;

	}
	public Perdorues updateFjalekalim(String newPass) {
		
		Perdorues p = getPerodruesTeLoguar();
		try {

			p.setEmer(p.getEmer());
			p.setEmail(p.getEmail());
			p.setUsername(p.getFjalekalim());
			p.setFjalekalim(newPass);
			p.setRoli(p.getRoli());
			p.setGjinia(p.getGjinia());
			p.setId(p.getId());
			p.setAdresa(p.getAdresa());
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
					.createQuery("select p from Perdorues p where p.eshteLoguar=:loguar", Perdorues.class)
					.setParameter("loguar", 1).getSingleResult();
			return p;

		} catch (Exception e) {

			return null;
		}

	}

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


	public Perdorues shtoPerdoruesTeRi(String emer, String mbiemer, String roli, String numerTel, String email,
			String address, String gjinia, String username, String password, String confirmPass, Label messageLabel) {
		Perdorues p = new Perdorues();
		try {
			if (StringUtils.isBlank(emer))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(mbiemer))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(numerTel))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(email))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(address))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(gjinia))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(password))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(password))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(confirmPass))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(confirmPass) && !password.equals(confirmPass) )
				messageLabel.setText("Passwordet nuk perputhen !");
			if (StringUtils.isBlank(username))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(roli)) {
				messageLabel.setText("Plotesoni te gjitha fushat !");
			} else if (StringUtils.isNotBlank(roli)
					&& !(roli.toLowerCase().equals("admin") ||roli.toLowerCase().equals("farmacist"))) {
				messageLabel.setText("Roli duhet te jete 'admin' ose 'farmacist' !");
			}
			if (messageLabel.getText().isEmpty()||StringUtils.isBlank(messageLabel.getText())) {
				p.setEmer(emer);
				p.setMbiemer(mbiemer);
				p.setNrTel(numerTel);
				p.setEmail(email);
				p.setAdresa(address);
				p.setGjinia(gjinia);
				p.setFjalekalim(password);
				p.setUsername(username);
				p.setRoli(roli);
				entityManager.merge(p);
				return p;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
