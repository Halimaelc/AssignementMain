package ma.octo.assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.repository.CompteRepository;

@Service
public class CompteMetierImpl implements compteMetierI{
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte ajouterCompte(Compte compte) {
		// TODO Auto-generated method stub
		return compteRepository.save(compte);
	}

	@Override
	public Compte consulterCompte(String rib)  {
		// TODO Auto-generated method stub
		Compte compte=compteRepository.findOne(rib);
		if(compte==null) {
			throw new RuntimeException("pas de compte");
			
		}
		return compte;
	}
	

}
