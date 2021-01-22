package br.com.isidrocorp.modernizacao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="itmn_modernizacao")
public class Modernizacao {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_seq")
	private int numSeq;
	
	@Column(name="descricao" , length = 100 , nullable = false)
	private String descricao;
	
	@Column(name="data_modernizacao" , nullable = false)
	private LocalDate data;
	
	@Column(name="percentual" , nullable = false)
	private float percentual;
	
	@ManyToOne
	@JoinColumn(name="id_comunidade")
	private Comunidade comunidade;

	
	
	
	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public float getPercentual() {
		return percentual;
	}

	public void setPercentual(float percentual) {
		this.percentual = percentual;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}


}
