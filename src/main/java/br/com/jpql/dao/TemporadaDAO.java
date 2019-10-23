package br.com.jpql.dao;

import br.com.jpql.model.Serie;
import br.com.jpql.model.Temporada;

import javax.persistence.EntityManager;
import java.util.List;

public class TemporadaDAO {

    public void persist(long serieId, Temporada temporada) {
        EntityManager em = JPAUtil.getEntityManager();
        Serie serie;

        em.getTransaction().begin();
        serie = em.getReference(Serie.class, serieId);
        serie.getTemporadas().add(temporada);
        temporada.setSerie(serie);
        em.persist(temporada);
        em.getTransaction().commit();
    }

    public void remove(Temporada temporada) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(temporada);
        em.getTransaction().commit();
    }

    public void update(Temporada temporada) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(temporada);
        em.getTransaction().commit();
    }

    public List<Temporada> list() {
        EntityManager em = JPAUtil.getEntityManager();

        return em.createQuery("SELECT t FROM Temporada t", Temporada.class)
                .getResultList();
    }

    public Temporada get(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.getReference(Temporada.class, id);
    }
}
