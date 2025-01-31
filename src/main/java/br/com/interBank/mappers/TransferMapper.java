package br.com.interBank.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import br.com.interBank.dtos.request.TransferenciaRequestDTO;
import br.com.interBank.dtos.response.TransferenciaResponseDTO;
import br.com.interBank.entities.TransferEntity;

@Mapper(componentModel = "spring")
public interface TransferMapper {

	TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);
	
	TransferEntity transferDtoToEntity(TransferenciaRequestDTO request);
	List<TransferenciaResponseDTO> listEntityToDto(List<TransferEntity> listaEntity);
}
