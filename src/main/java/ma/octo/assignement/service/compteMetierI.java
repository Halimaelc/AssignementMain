package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;

public interface compteMetierI {
	public Compte ajouterCompte(Compte compte);
	public Compte consulterCompte(String  rib);

}
