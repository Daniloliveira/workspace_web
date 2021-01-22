package br.com.isidrocorp.modernizacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name="itmn_usuario")

public class Usuario {

	@Id  // @Id indica que o atributo pe chave primario
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Configuração informando que é auto gerado
	@Column(name="id_usuario") //Definido no Banco de Dados
	private int id;
	
	@Column(name="nome_usuario", length=100 , nullable=false)
	private String nome;
	
	@Column(name="email_usuario" , length= 100 , nullable=false)
	private String email;
	
	@Column(name="racfusuario" , length= 7 , nullable=false)
	private String racf;
	
	@Column(name="senha_usuario" , length= 50 , nullable=false)
	private String senha;
	
	@Column(name="link_foto" , length= 255 , nullable=false)
	private String linkfoto;
	
	
	@OneToMany(mappedBy = "teamLeader", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("teamLeader")
	private List<Comunidade> comunidades;	

	
	public List<Comunidade> getComunidades() {
		return comunidades;
	}
	public void setComunidades(List<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLinkfoto() {
		return linkfoto;
	}
	public void setLinkfoto(String linkfoto) {
		this.linkfoto = linkfoto;
	}
	

	
}
