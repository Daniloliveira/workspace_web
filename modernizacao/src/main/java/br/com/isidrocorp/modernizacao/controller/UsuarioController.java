package br.com.isidrocorp.modernizacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.modernizacao.dao.UsuarioDAO;
import br.com.isidrocorp.modernizacao.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired //Injeção de Dependencias
	UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos(){
		
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerlogin(@RequestBody Usuario dadosLogin) {
		Usuario resultado;
		
		resultado = dao.findByRacfOrEmail(dadosLogin.getRacf(), dadosLogin.getEmail());
		
		if (resultado != null) {
			if (dadosLogin.getSenha().contentEquals(resultado.getSenha())) {
				resultado.setSenha("********");
				return ResponseEntity.ok(resultado);
			}
			else {
				return ResponseEntity.status(403).build();
			}
			
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
		
		
		
		
		}
		
	}

