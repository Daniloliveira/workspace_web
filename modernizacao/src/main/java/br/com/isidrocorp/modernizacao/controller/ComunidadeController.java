package br.com.isidrocorp.modernizacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.modernizacao.dao.ComunidadeDAO;
import br.com.isidrocorp.modernizacao.model.Comunidade;

@RestController
@CrossOrigin("*")
public class ComunidadeController {
	@Autowired
	ComunidadeDAO dao;
	
	@GetMapping("/comunidades/{id}")
	public Comunidade recuperaPeloId(@PathVariable int id) {
		return dao.findById(id).get();
	
	}
	
	
}
