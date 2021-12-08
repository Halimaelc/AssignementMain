package ma.octo.assignement.mapper;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;

//@Mapper(componentModel = "spring")
public interface virementMapper {
	 public VirementDto map(Virement virement);

}
