package br.com.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jpql.dao.JPAUtil;
import br.com.jpql.model.Episodio;
import br.com.jpql.model.Serie;

public class ConsultasJPQL {
	
	// CONSULTA POR TODAS AS SERIES
	public static void listaTodasSeries(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT s FROM Serie s");
		
		List<Serie> listaSerie = query.getResultList();
		
		for (Serie serie : listaSerie) {
			System.out.println(serie.getDescricao());
		}
	}
	
	// CONSULTA POR SERIES DO ANO DE 2008
	public static void listaTodasSeriesDe2008(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT s FROM Serie s WHERE s.anoCriacao = 2008", Serie.class);
		
		List<Serie> listaSerie = query.getResultList();
		
		for (Serie serie : listaSerie) {
			System.out.println(serie.getDescricao());
		}
	}
	
	// CONSULTA POR SÉRIES DE ANO ESPECIFICADO
	public static void listaTodasSeriesDeAnoEspecificado(int ano){
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Serie s WHERE s.anoCriacao =:ano", Serie.class);
		query.setParameter("ano", ano);
		
		List<Serie> listaSerie = query.getResultList();
		
		for (Serie serie : listaSerie) {
			System.out.println(serie.getDescricao());
		}
	}
	
	// CONSULTA POR SÉRIES QUE CONTENHA PARTES DE UM NOME
	public static void listaTodasSeriesCujoNomeContenha(String nome){
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Serie s WHERE s.nome LIKE :nome", Serie.class);
		query.setParameter("nome", nome);
		
		List<Serie> listaSerie = query.getResultList();
		
		for (Serie serie : listaSerie) {
			System.out.println(serie.getDescricao());
		}
	}
	
	// CONSULTA POR SERIE ATRAVES DO ANO E NOME
	public static void recuperaSeriePorAnoENome(String nome, int ano){
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Serie s WHERE s.nome LIKE :nome AND s.anoCriacao = :ano", Serie.class);
		query.setParameter("nome", nome);
		query.setParameter("ano", ano);
		
		Serie serie = (Serie) query.getSingleResult();
		
		System.out.println(serie.getDescricao());
	}
	
	// CONSULTA POR EPISODIOS DE UMA SERIE ATRAVES DO NOME DA SERIE
	public static void listaEpisodiosDaSerie(String nome){
		EntityManager em = JPAUtil.getEntityManager();
		
		// se utiliza composição quando o atributo não for complexo (temporada é tipo unico) e.getTemporada().getSerie().getNome()	= sem uso de join
		Query query = em.createQuery("SELECT e FROM Episodio e WHERE e.temporada.serie.nome LIKE :nome", Episodio.class);
		query.setParameter("nome", nome);
		
		List<Episodio> listaSerie = query.getResultList();
		
		for (Episodio e : listaSerie) {
			System.out.println(e.getDescricao());
		}
	}
	
	
	// CONSULTA POR EPISODIOS DE UMA SERIE ATRAVES DO NOME DA SERIE
	public static void listaSeriesComNumeroMinimoDeTemporadas(int temporadas){
		EntityManager em = JPAUtil.getEntityManager();
			
			// declara-se o JOIN quando não se faz uso de atributos complexos como uma coleção "temporadas" que contem uma lista de itens
		Query query = em.createQuery("SELECT s FROM Serie s JOIN s.temporadas t WHERE t.numero = :qtdTemporada", Serie.class);
		query.setParameter("qtdTemporada", temporadas);
			
		List<Serie> listaSerie = query.getResultList();
			
		for (Serie e : listaSerie) {
			System.out.println(e.getDescricao());
		}
	}
	
	
	public static void main(String[] args) {
		// Modelo SQL			= SELECT * FROM <entidade>
		// Modelo JPQL 			= <apelidoEntidade> FROM <entidade> <apelidoEntidade>
		// Modelo JPQL Serie 	= SELECT s FROM Serie s
		
		int ano = 2008;
		listaSeriesComNumeroMinimoDeTemporadas(3);
		
	}
}
