package al.tetra.licence.service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import al.tetra.licence.entity.Ilace;
import io.micrometer.core.instrument.util.StringUtils;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

@Service("ilaceService")
@Transactional
public class IlaceService {
	@PersistenceContext
	private EntityManager entityManager;


	// per butonin search tek perditeso ilac 
	public Ilace kerkoIlacSipasEmrit(String emer) {
		try {
			Ilace i = entityManager.createQuery("select i from Ilace i where i.emer=:emer", Ilace.class)
					.setParameter("kerkoj", 1).getSingleResult();
			return i;

		} catch (Exception e) {

			return null;
		}
	}
	//butoni shit
	public Ilace shitIlace(String emer,String vetemMeRecete) {
		try {
			Ilace i = entityManager.createQuery("select i from Ilace i where i.emer=:emer "
					+ "and i.vetemMeRecete=:vetemMeRecete", Ilace.class)
					.setParameter("kerkoj", 1).getSingleResult();
			return i;

		} catch (Exception e) {

			return null;
		}
	}

//per fshiIlac butonin
	public Ilace fshiIlace(double cmimShitje, String data, String emer,
			double madhesia, double sasia, String vetemMeRecete, Label messageLabel) {
		try {
			Ilace i = entityManager.createQuery("delete from Ilace i where i.emer=:emer and i.cmimShitje=:cmimShitje"
					+ "and i.date_furnizimi=: data and i.madhesia=:madhesia and i.sasia=:sasia"
					+ "and i.vetemMeRecete=:vetemMeRecete", Ilace.class)
					.setParameter("fshire", 1).getSingleResult();
			return i;
		} catch (Exception e) {
			return null;
		}
	}

	// kur ruajme nje ilac te ri tek perditeso ilac
	public Ilace shtoIlac(double cmimShitje, String data, String emer,
			double madhesia, double sasia, String vetemMeRecete, Label messageLabel) {
		Ilace i = new Ilace();
		try {
			if (StringUtils.isBlank(emer))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(String.valueOf(data)))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(String.valueOf(sasia)))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(String.valueOf(madhesia)))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(String.valueOf(cmimShitje)))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(String.valueOf(i.isVetemMeRecete())))
				messageLabel.setText("Plotesoni te gjitha fushat !");

			if (messageLabel.getText().isEmpty() || StringUtils.isBlank(messageLabel.getText())) {
				i.setEmer(emer);
				i.setSasia(sasia);
				i.setMadhesia(madhesia);
				i.setCmimShitje(cmimShitje);
				i.setVetemMeRecete(i.isVetemMeRecete());
				i.setDate_furnizimi(data);
				entityManager.merge(i);
				return i;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
