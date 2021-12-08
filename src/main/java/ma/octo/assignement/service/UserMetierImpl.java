package ma.octo.assignement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.repository.UtilisateurRepository;

@Service
public class UserMetierImpl implements UserMetierI{
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	@Override
	public List<Utilisateur> listUtilisateurParMotCle(String motCle) {
		// TODO Auto-generated method stub
		return utilisateurRepository.listUtilisateurParMotCle(motCle);
	}
	

}
