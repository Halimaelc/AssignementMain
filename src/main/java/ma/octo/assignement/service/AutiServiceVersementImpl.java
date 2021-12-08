package ma.octo.assignement.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.AuditVersement;
import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.util.EventType;
import ma.octo.assignement.repository.AuditVersementRepository;
import ma.octo.assignement.repository.CompteRepository;
@Service
@Transactional
public class AutiServiceVersementImpl implements AutiServiceVersement{
	
	Logger LOGGER = LoggerFactory.getLogger(AutiServiceVirement.class);

	@Autowired
	private AuditVersementRepository auditVirsementRepository;
	@Autowired
	private CompteRepository compteRepository;

	
	@Override
	public void auditVersement(String nrCompte,String message,double montant) {
		 Compte compte=compteRepository.findByNrCompte(nrCompte);
		 LOGGER.info("Audit de l'événement {}", EventType.VERSEMENT);
		 
		 AuditVersement audit = new AuditVersement();
		 audit.setEventType(EventType.VERSEMENT); audit.setMessage(message);
		 auditVirsementRepository.save(audit);
		 compte.setSolde(compte.getSolde()+montant);}
	
	public String auditVirementString(String string) {
		return string;
		// TODO Auto-generated method stub
		
	}
		 
		
	}
	


