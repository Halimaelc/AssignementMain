package ma.octo.assignement.mapper;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;
@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2021-11-6T19:21:44+0100",
	    comments = ".. "
	)
@Component
public class VirementMapperImpl implements virementMapper {

    private static VirementDto virementDto;

	@Override
	public VirementDto map(Virement virement) {
		virementDto = new VirementDto();
		virementDto.setNrCompteEmetteur(virement.getCompteEmetteur().getNrCompte());
		virementDto.setDate(virement.getDateExecution());
		virementDto.setMotif(virement.getMotifVirement()); 
		virementDto.setMontantVirement(virement.getMontantVirement());
		return virementDto;
	}
}
