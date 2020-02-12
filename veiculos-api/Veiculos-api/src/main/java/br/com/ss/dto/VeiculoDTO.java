package br.com.ss.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ss.model.Veiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDTO {

	private Long id;

	private String marca;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Integer ano;

	private String descricao;

	private boolean vendido;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar dataCriacao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar dataAtualizacao;

	public Veiculo toObject() {
		return new Veiculo(id, marca, ano, descricao, vendido, dataCriacao, dataAtualizacao);
	}
}
