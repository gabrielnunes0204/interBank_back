package br.com.interBank.dtos.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponseDTO {

	private String mensagem;
	private BigDecimal valorTaxado;
	private Boolean isSucesso;
}
