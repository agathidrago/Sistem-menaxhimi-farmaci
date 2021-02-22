package al.tetra.licence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.tetra.licence.entity.Ilace;
import al.tetra.licence.entity.Kartele;
import al.tetra.licence.entity.KarteleIlac;
import al.tetra.licence.entity.KarteleSemundje;
import al.tetra.licence.entity.Pacient;
import al.tetra.licence.entity.PacientIlac;
import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.entity.Recete;
import al.tetra.licence.entity.ReceteIlac;
import al.tetra.licence.entity.Semundje;
import al.tetra.licence.entity.SemundjeIlac;
import al.tetra.licence.entity.SemundjePacient;
import io.micrometer.core.instrument.util.StringUtils;
import javafx.scene.control.Label;

@Service("mjekuService")
@Transactional
public class MjekuService {
	@Autowired
	private PerdoruesService perdoruesService;

	@PersistenceContext
	private EntityManager entityManager;

	public Recete leshoRecete(String emerPacienti, String ilacet, String mjeku) {
		try {
			System.err.println("Erdhi ketu 1");
			Recete r = new Recete();
			r.setPacienti(emerPacienti);
			r.setDateLeshimi(new Date());
			r.setMjek(perdoruesService.getPerodruesTeLoguar().getId().intValue());
			System.err.println(r.toString());
			entityManager.persist(r);
			String[] arrSplit = ilacet.split(",");
			for (int i = 0; i < arrSplit.length; i++) {
				Ilace ilac = new Ilace();
				ilac.setEmer(arrSplit[i]);
				entityManager.persist(ilac);
				ReceteIlac ri = new ReceteIlac();
				ri.setIlac(ilac.getId().intValue());
				ri.setRecete(r.getId().intValue());
				entityManager.persist(ri);
			}

			// r.setRecete(ri);
			System.err.println("Erdhi ketu 3");

			return r;
		} catch (Exception e) {
			return null;
		}
	}

	public Kartele ruajKartele(Long idPacienti, String ilace, String semundje) {
		try {
			System.err.println("Erdhi ketu 1");
			Kartele k = new Kartele();
			k.setPacient(idPacienti.intValue());
			entityManager.persist(k);
			String[] ilacet = ilace.split(",");
			for (int i = 0; i < ilacet.length; i++) {
				Ilace ilac = getIlacByName(ilacet[i]);
				KarteleIlac ki = new KarteleIlac();
				ki.setIlac(ilac.getId().intValue());
				ki.setKartele(k.getId().intValue());
				entityManager.persist(ki);
				/*SemundjeIlac si= new SemundjeIlac();
				si.setIlac(ilac.get);*/
			}
			String[] semundjet = semundje.split(",");
			for (int i = 0; i < semundjet.length; i++) {
				Semundje s = getSemundjeByName(semundjet[i]);
				KarteleSemundje ks = new KarteleSemundje();
				ks.setSemundje(s.getId().intValue());
				ks.setKartele(k.getId().intValue());
				entityManager.persist(ks);
				SemundjePacient sp=new SemundjePacient();
				sp.setPacient(idPacienti.intValue());
				sp.setSemundjeP(s.getId().intValue());
				entityManager.persist(sp);
			}

			// r.setRecete(ri);
			System.err.println("Erdhi ketu 3");

			return k;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public Pacient getPacientByName(String emer) {
		try {
			Pacient p = entityManager.createQuery("select p from Pacient p where emer=:emer", Pacient.class)
					.setParameter("emer", emer).getSingleResult();
			System.err.println(p.toString());

			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public Recete getReceteByName(String emer) {
		try {
			Recete r = entityManager.createQuery("select p from Recete p where pacienti=:emer", Recete.class)
					.setParameter("emer", emer).getSingleResult();
			System.err.println(r.toString());

			return r;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public Perdorues getPerodruesById(int mjekId) {
		try {
			Perdorues p = entityManager.createQuery("select p from Perdorues p where id=:mjekId", Perdorues.class)
					.setParameter("mjekId", new Long(mjekId)).getSingleResult();
			System.err.println(p.toString());

			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public Ilace getIlacByName(String emer) {
		try {
			Ilace ilace = entityManager.createQuery("select ilace from Ilace ilace where emer=:emer", Ilace.class)
					.setParameter("emer", emer).getSingleResult();
			System.err.println(ilace.toString());

			return ilace;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public Semundje getSemundjeByName(String emer) {
		try {
			Semundje semundje = entityManager
					.createQuery("select semundje from Semundje semundje where emer=:emer", Semundje.class)
					.setParameter("emer", emer).getSingleResult();
			System.err.println(semundje.toString());

			return semundje;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public String getIlacePacient(Long idPacienti) {
		try {
			String ilac = "";
			List<PacientIlac> pi = entityManager
					.createQuery("select p from PacientIlac p where pacient=:idPacienti", PacientIlac.class)
					.setParameter("idPacienti", idPacienti.intValue()).getResultList();
			System.err.println("pi" + pi.toString());
			for (int i = 0; i < pi.size(); i++) {
				Ilace ilace = entityManager.createQuery("select i from Ilace i where id=:idPacienti", Ilace.class)
						.setParameter("idPacienti", new Long(pi.get(i).getIlac())).getSingleResult();
				ilac += ilace.getEmer() + " ,";

			}
			System.err.println("ILACE" + ilac);
			return ilac;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	public String getSemundjePacient(Long idPacienti) {
		try {
			String semundjet = "";
			List<SemundjePacient> pi = entityManager
					.createQuery("select p from SemundjePacient p where pacient=:idPacienti", SemundjePacient.class)
					.setParameter("idPacienti", idPacienti.intValue()).getResultList();

			for (int i = 0; i < pi.size(); i++) {
				System.err.println("Semundje pacient:" + pi.get(i).getSemundje());

				Semundje semundje = entityManager
						.createQuery("select semundje from Semundje semundje where id=:id", Semundje.class)
						.setParameter("id", new Long(pi.get(i).getSemundje())).getSingleResult();
				semundjet += semundje.getEmer() + " ,";
			}

			return semundjet;
		} catch (Exception e) {
			return null;
		}
	}

	public Ilace updateIlac(String emerAktual, String emer, double sasia, double madhesia, Date data, double cmimiSh,
			double cmimiB, boolean meRecete, Long idIlaci) {
		Ilace i;
		if (idIlaci != null) {
			i = getIlacByName(emerAktual);
		} else {
			i = new Ilace();
		}

		try {

			i.setEmer(emer);
			i.setSasia(sasia);
			i.setMadhesia(madhesia);
			i.setDate_furnizimi(data);
			i.setCmimShitje(cmimiSh);
			i.setCmimBlerje(cmimiB);
			i.setVetemMeRecete(meRecete);
			if (idIlaci != null)
				i.setId(idIlaci);
			entityManager.persist(i);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	@Transactional
	public void deleteIlaceById(Long id) {
		try {
			entityManager.createQuery("delete ReceteIlac  where ilac=:id").setParameter("id", id.intValue())
					.executeUpdate();
			entityManager.createQuery("delete SemundjeIlac  where ilac=:id").setParameter("id", id.intValue())
					.executeUpdate();
			entityManager.createQuery("delete PacientIlac  where ilac=:id").setParameter("id", id.intValue())
					.executeUpdate();
			entityManager.createQuery("delete Ilace  where id=:id").setParameter("id", id).executeUpdate();

			System.err.println("Hyri !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteReceteById(Long id) {
		try {
			entityManager.createQuery("delete ReceteIlac  where recete=:id").setParameter("id",id.intValue()).executeUpdate();
			entityManager.createQuery("delete Recete  where id=:id").setParameter("id", id).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIlaceByRecete(String emer) {
		String ilacet = "";
		Recete r = getReceteByName(emer);
		List<ReceteIlac> rilace = entityManager
				.createQuery("select ilace from ReceteIlac ilace where recete=:recete", ReceteIlac.class)
				.setParameter("recete", r.getId().intValue()).getResultList();
		for (int i = 0; i < rilace.size(); i++) {
			Ilace ilace = entityManager.createQuery("select ilace from Ilace ilace where id=:id", Ilace.class)
					.setParameter("id", new Long(rilace.get(i).getIlac())).getSingleResult();
			if (StringUtils.isBlank(ilacet)) {
				ilacet += ilace.getEmer();
			} else {
				ilacet += "," + ilace.getEmer();

			}

		}
		return ilacet;

	}
	public Pacient shtoPacientTeRi(String emer, int mosha,String numerTel,String address, Date date,String gjinia, Label messageLabel) {
		Pacient p = new Pacient();
		try {
			if (StringUtils.isBlank(emer))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(numerTel))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(address))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			if (StringUtils.isBlank(gjinia))
				messageLabel.setText("Plotesoni te gjitha fushat !");
			
			if (messageLabel.getText().isEmpty()||StringUtils.isBlank(messageLabel.getText())) {
				p.setEmer(emer);
				p.setKontakt(numerTel);
				p.setAdresa(address);
				p.setGjinia(gjinia);
				p.setMosha(mosha);
				p.setDatelindja(date);
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
