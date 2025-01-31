package br.com.interBank.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.interBank.TransferRepository;
import br.com.interBank.dtos.request.TransferenciaRequestDTO;
import br.com.interBank.dtos.response.CreateResponseDTO;
import br.com.interBank.dtos.response.TransferenciaResponseDTO;
import br.com.interBank.entities.TransferEntity;
import br.com.interBank.mappers.TransferMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransferService {

	private static final String AGENDAMENTO_NAO_EFETUADO = "Erro. Agendamento não efetuado";
	private static final String AGENDAMENTO_REALIZADO = "Agendamento realizado com sucesso";

	@Autowired
	private TransferRepository transferRepository;
	
	@Autowired
	private TransferMapper transferMapper;
	
	public List<TransferenciaResponseDTO> getTransfer() {
		return this.transferMapper.listEntityToDto(this.transferRepository.findAll());
	}
	
	public CreateResponseDTO createTransfer(TransferenciaRequestDTO request) {
		
		try {
			
			TransferEntity entity = new TransferEntity();
			
			if (request != null) {
				entity = this.transferMapper.transferDtoToEntity(request);
			}
			
			entity.setDataHoraAgendamento(LocalDateTime.now());
			BigDecimal valorTaxa = this.aplicarTaxa(
					entity.getDataHoraAgendamento(),
					entity.getDataHoraTransferencia());
			
			entity.setValorTransferencia(entity.getValorTransferencia().add(valorTaxa));
			this.transferRepository.save(entity);
			
			return new CreateResponseDTO(
					AGENDAMENTO_REALIZADO,
					valorTaxa,
					true);
			
		} catch (Exception e) {
			log.info("Erro ao agendar transferência: ", e.getMessage());
			return new CreateResponseDTO(
					AGENDAMENTO_NAO_EFETUADO,
					BigDecimal.ZERO,
					false);
		}
	}
	
	private BigDecimal aplicarTaxa(LocalDateTime dataHoraAtual, LocalDateTime dataHoraAgendamento) {
        Long diasDeDiferenca = ChronoUnit.DAYS.between(dataHoraAtual, dataHoraAgendamento);
        BigDecimal taxa = BigDecimal.ZERO;
        
		if (diasDeDiferenca == 0) {
			taxa = new BigDecimal(3);
			taxa = taxa.add(taxa.multiply(BigDecimal.ONE.add(new BigDecimal("0.025")))); //2.5%
		
		} else if (diasDeDiferenca >= 0 && diasDeDiferenca <= 10) {
			taxa = taxa.add(new BigDecimal(12));
		
		} else if (diasDeDiferenca >= 11 && diasDeDiferenca <= 20) {
			taxa = taxa.multiply(BigDecimal.ONE.add(new BigDecimal("0.082"))); //8.2%
		
		} else if (diasDeDiferenca >= 21 && diasDeDiferenca <= 30) {
			taxa = taxa.multiply(BigDecimal.ONE.add(new BigDecimal("0.069"))); //6.9%
		
		} else if (diasDeDiferenca >= 31 && diasDeDiferenca <= 40) {
			taxa = taxa.multiply(BigDecimal.ONE.add(new BigDecimal("0.047"))); //4.7%
		
		} else if (diasDeDiferenca >= 41 && diasDeDiferenca <= 50) {
			taxa = taxa.multiply(BigDecimal.ONE.add(new BigDecimal("0.017"))); //1.7%
		}
		
		return taxa;
	}
}
