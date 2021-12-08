package ma.octo.assignement.service;

import ma.octo.assignement.domain.AuditVirement;
import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.util.EventType;

import ma.octo.assignement.repository.AuditVirementRepository;
import ma.octo.assignement.repository.CompteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AutiServiceVirement implements AutiServiceVirementI{

    Logger LOGGER = LoggerFactory.getLogger(AutiServiceVirement.class);

    @Autowired
    private AuditVirementRepository auditVirementRepository;
    @Autowired
    private CompteRepository compteRepository;

    public void auditVirement(String nrCompteEmetter,String nrCompteBenificaire,String message,double montant) {
    	Compte compteEmetteur=compteRepository.findByNrCompte(nrCompteEmetter);
    	Compte compteBenificiaire=compteRepository.findByNrCompte(nrCompteBenificaire);
        LOGGER.info("Audit de l'événement {}", EventType.VIREMENT);
        if(compteEmetteur.getSolde()<montant)
        	throw new RuntimeException("solde insuffisant");

        AuditVirement audit = new AuditVirement();
        audit.setEventType(EventType.VIREMENT);
        audit.setMessage(message);
        auditVirementRepository.save(audit);
        
        compteBenificiaire.setSolde(compteBenificiaire.getSolde()+montant);
        compteEmetteur.setSolde(compteEmetteur.getSolde()-montant);
        }

	public String auditVirementString(String string) {
		return string;
		// TODO Auto-generated method stub
		
	}
        
        
    }

