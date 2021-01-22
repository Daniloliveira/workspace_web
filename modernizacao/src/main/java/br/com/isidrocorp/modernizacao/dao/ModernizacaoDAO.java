package br.com.isidrocorp.modernizacao.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.isidrocorp.modernizacao.dto.Percentual;
import br.com.isidrocorp.modernizacao.dto.QuantidadeOcorrencias;
import br.com.isidrocorp.modernizacao.model.Comunidade;
import br.com.isidrocorp.modernizacao.model.Modernizacao;


public interface ModernizacaoDAO extends CrudRepository<Modernizacao,Integer>{
	
	
	public ArrayList<Modernizacao> findAllByComunidade(Comunidade comunidade);
	
	@Query("select new br.com.isidrocorp.modernizacao.dto.Percentual(sum(m.percentual))  "
		 + " from Modernizacao m where m.comunidade.id = :id")
	public Percentual buscarPercentualDaComunidade(@Param(value="id") int id);

	
	@Query("select new br.com.isidrocorp.modernizacao.dto.QuantidadeOcorrencias(count(numSeq)) "
		+  " from Modernizacao m where m.comunidade.id = :id and"
		+ "       year(m.data) = year(:data) and"
		+ "       month(m.data) = month(:data)")
	public QuantidadeOcorrencias buscarOcorrencias(@Param(value="id") int id, 
			                                       @Param(value="data") LocalDate data);
}
