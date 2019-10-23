package br.com.jpql;
import br.com.jpql.model.*;
import br.com.jpql.dao.*;

public class PersisteDadosPadrao {
	public static void main(String[] args) {
		
		Serie serie1 = new Serie("Gotham", 2013, "História do Batman");
        Serie serie2 = new Serie("The Walking Dead", 2008, "Tragédia com zumbis");
        Serie serie3 = new Serie("Stranger Things", 2016, "Mistério sobre experimentos com crianças");

        Temporada tempGotham1 = new Temporada(1, "O início da história");
        Temporada tempGotham2 = new Temporada(2, "A continuidade da história");
        Temporada tempTWD1 = new Temporada(1, "O começo de tudo");
        Temporada tempTWD2 = new Temporada(2, "Guerras e sobrevivência");
        Temporada tempTWD3 = new Temporada(3, "Novos desafios");
        Temporada tempStranger1 = new Temporada(1, "Como tudo começou");

        Episodio epGotham1 = new Episodio(1, "O começo", "Primeiro episódio da série");
        Episodio epGotham2 = new Episodio(2, "O segundo", "Segundo episódio da série");
        Episodio epGotham3 = new Episodio(1, "O reinício", "Primeiro episódio da segunda temporada");
        Episodio epGotham4 = new Episodio(2, "O segundo", "Segundo episódio da segunda temporada");

        Episodio eptwd1 = new Episodio(1, "A tragédia", "Começando a história");
        Episodio eptwd2 = new Episodio(2, "Continação da tragédia", "Continuando a história");
        Episodio eptwd3 = new Episodio(1, "O retorno de Rick", "Rick retorna para o grupo");
        Episodio eptwd4 = new Episodio(1, "O milagre de Glenn", "Glenn derrota zumbis");

        Episodio epstranger1 = new Episodio(1, "Coisas estranhas", "A criação do mistério");

        SerieDAO serieDao = new SerieDAO();
        serieDao.persist(serie1);
        serieDao.persist(serie2);
        serieDao.persist(serie3);

        TemporadaDAO temporadaDao = new TemporadaDAO();
        temporadaDao.persist(1, tempGotham1);
        temporadaDao.persist(1, tempGotham2);
        temporadaDao.persist(2, tempTWD1);
        temporadaDao.persist(2, tempTWD2);
        temporadaDao.persist(2, tempTWD3);
        temporadaDao.persist(3, tempStranger1);

        EpisodioDAO episodioDao = new EpisodioDAO();
        episodioDao.persist(1, epGotham1);
        episodioDao.persist(1, epGotham2);
        episodioDao.persist(2, epGotham3);
        episodioDao.persist(2, epGotham4);
        episodioDao.persist(3, eptwd1);
        episodioDao.persist(3, eptwd2);
        episodioDao.persist(4, eptwd3);
        episodioDao.persist(5, eptwd4);
        episodioDao.persist(6, epstranger1);
	}
}
