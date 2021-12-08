package ma.octo.assignement.service;

import java.util.List;

import ma.octo.assignement.domain.Utilisateur;

public interface UserMetierI {
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
	public List<Utilisateur> listUtilisateur();
	public List<Utilisateur> listUtilisateurParMotCle(String motCle);

	

}
