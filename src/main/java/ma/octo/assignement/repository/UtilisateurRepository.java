package ma.octo.assignement.repository;

import ma.octo.assignement.domain.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	public Utilisateur findById(String nom_prenom_emetteur);
	
	@Query("select utilisateur from Utilisateur where utilisateur.username like :x")
	public List<Utilisateur> listUtilisateurParMotCle(@Param("x")String motCle);
}
