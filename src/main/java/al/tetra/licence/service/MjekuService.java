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
import al.tetra.licence.entity.Perdorues;
import al.tetra.licence.entity.Recete;
import al.tetra.licence.entity.ReceteIlac;

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
			
			
			//r.setRecete(ri);
			System.err.println("Erdhi ketu 3");
			
			
			
			return r;
		} catch (Exception e) {
			return null;
		}
	}

}
