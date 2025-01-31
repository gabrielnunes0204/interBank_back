package br.com.interBank.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaResponseDTO {

	private Long id;
	private String nomeUsuario;
	private String documentoUsuario;
	private Long contaOrigem;
	private Long contaDestino;
	private BigDecimal valorTransferencia;
	private BigDecimal valorTaxa;
	private LocalDateTime dataHoraTransferencia;
	private LocalDateTime dataHoraAgendamento;
}
