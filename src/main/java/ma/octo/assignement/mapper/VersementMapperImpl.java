package ma.octo.assignement.mapper;


import org.mapstruct.Mapper;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.dto.VirementDto;

//@Mapper
public class VersementMapperImpl implements VersementMapper{
	 private static VersementDto versementDto;


	@Override
	public VersementDto map(Versement versement) {
		versementDto = new VersementDto();
		versementDto.setNrCompteBeneficiaire(versement.getCompteBeneficiaire().getNrCompte());
		versementDto.setDate(versement.getDateExecution());
		versementDto.setMotif(versement.getMotifVersement()); 
		versementDto.setMontantVersement(versement.getMontantVersement());
		versementDto.setNom_prenom_emetteur(versement.getNom_prenom_emetteur());
		return versementDto;
	}

}
