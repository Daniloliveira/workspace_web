package br.com.isidrocorp.modernizacao.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.modernizacao.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	// public Usuario findByRacfandSenha(String racf, String senha);
	public Usuario findByRacfOrEmail(String racf, String email);
	
}
