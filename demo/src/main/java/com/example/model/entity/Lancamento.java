package com.example.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.example.model.enums.StatusLancamento;
import com.example.model.enums.TipoLancamento;

@Entity
@Table (name = "lancamento")
public class Lancamento {
	
	
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column	
	private Integer mes;
	
	@Column	
	private Integer ano;
	
	@JoinColumn (name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@Column	
	private String descricao;
	
	@Column	
	private BigDecimal valor;
	
	@Column	(name = "data_cadastro")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataCadastro;
	
	@Column	
	@Enumerated(value = EnumType.STRING)
	private TipoLancamento tipo;
	
	@Column (name = "stats")
	@Enumerated(value = EnumType.STRING)
	private StatusLancamento status;
	

}
