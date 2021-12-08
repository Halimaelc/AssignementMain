package ma.octo.assignement.web;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Versement;

import ma.octo.assignement.dto.VersementDto;

import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;

import ma.octo.assignement.repository.CompteRepository;
import ma.octo.assignement.repository.UtilisateurRepository;
import ma.octo.assignement.repository.VersementRepository;
import ma.octo.assignement.service.AutiServiceVersement;

@RestController(value = "/versements")
class VersementController {
	 public static final int MONTANT_MAXIMAL = 10000;
	 Logger LOGGER = LoggerFactory.getLogger(VersementController.class);
	 @Autowired
	    private CompteRepository rep1;
	    @Autowired
	    private VersementRepository re2;
	    @Autowired
	    private AutiServiceVersement monservice;
	    @Autowired
	    private UtilisateurRepository re3;
	    
	    @GetMapping("lister_versements")
	    List<Versement> loadAll() {
	        List<Versement> all = re2.findAll();

	        if (CollectionUtils.isEmpty(all)) {
	            return null;
	        } else {
	            return all;
	        }
	    }

	    @GetMapping("lister_comptes")
	    List<Compte> loadAllCompte() {
	        List<Compte> all = rep1.findAll();

	        if (CollectionUtils.isEmpty(all)) {
	            return null;
	        } else {
	            return all;
	        }
	    }

	    @GetMapping("lister_utilisateurs")
	    List<Utilisateur> loadAllUtilisateur() {
	        List<Utilisateur> all = re3.findAll();

	        if (CollectionUtils.isEmpty(all)) {
	            return null;
	        } else {
	            return all;
	        }
	    }
	    @PostMapping("/executerVersements")
	    @ResponseStatus(HttpStatus.CREATED)
	    public void createTransaction(@RequestBody VersementDto versementDto)
	            throws SoldeDisponibleInsuffisantException, CompteNonExistantException {
	        Utilisateur c1 = re3.findById(versementDto.getNom_prenom_emetteur());
	        Compte f12 = rep1.findByNrCompte(versementDto.getNrCompteBeneficiaire());
	        if (f12 == null) {
	            System.out.println("Compte Non existant");
	            throw new CompteNonExistantException("Compte Non existant");
	        }

	        if (versementDto.getMontantVersement().equals(null)) {
	            System.out.println("Montant vide");
	           
	        } else if (versementDto.getMontantVersement().intValue() == 0) {
	            System.out.println("Montant vide");
	            
	        } else if (versementDto.getMontantVersement().intValue() < 10) {
	            System.out.println("Montant minimal de versement non atteint");
	   
	        } else if (versementDto.getMontantVersement().intValue() > MONTANT_MAXIMAL) {
	            System.out.println("Montant maximal de versement dépassé");
	        }

	        if (versementDto.getMotif().length() < 0) {
	            System.out.println("Motif vide");
	        }


	        f12.setSolde((f12.getSolde() + versementDto.getMontantVersement().intValue()));
	        rep1.save(f12);

	        Versement versement = new Versement();
	        versement.setDateExecution(versementDto.getDate());
	        versement.setCompteBeneficiaire(f12);
	        versement.setNom_prenom_emetteur(c1.getFirstname()+c1.getLastname());
	        versement.setMontantVersement(versementDto.getMontantVersement());

	        re2.save(versement);

	        monservice.auditVirementString("Virement de " + versementDto.getNom_prenom_emetteur() + " vers " + versementDto
	                        .getNrCompteBeneficiaire() + " d'un montant de " + versementDto.getMontantVersement()
	                        .toString());
	    }

	    private void save(Versement Versement) {
	        re2.save(Versement);
	    }

}
