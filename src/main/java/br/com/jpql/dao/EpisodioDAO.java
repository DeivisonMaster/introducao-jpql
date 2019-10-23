package br.com.jpql.dao;

import br.com.jpql.model.Episodio;
import br.com.jpql.model.Temporada;

import javax.persistence.EntityManager;
import java.util.List;

public class EpisodioDAO {

    public void persist(long temporadaId, Episodio episodio) {
        EntityManager em = JPAUtil.getEntityManager();
        Temporada temporada;

        em.getTransaction().begin();
        temporada = em.getReference(Temporada.class, temporadaId);
        temporada.getEpisodios().add(episodio);
        episodio.setTemporada(temporada);
        em.persist(episodio);
        em.getTransaction().commit();
    }

    public void remove(Episodio episodio) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(episodio);
        em.getTransaction().commit();
    }

    public void update(Episodio episodio) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(episodio);
        em.getTransaction().commit();
    }

    public List<Episodio> list() {
        EntityManager em = JPAUtil.getEntityManager();

        return em.createQuery("SELECT e FROM Episodio e", Episodio.class)
                .getResultList();
    }

    public Episodio get(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.getReference(Episodio.class, id);
    }

}
