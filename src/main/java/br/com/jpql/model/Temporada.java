package br.com.jpql.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="temporadas")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int numero;
    private String descricao;

    @ManyToOne
    private Serie serie;

    @OneToMany(mappedBy = "temporada", orphanRemoval = true)
    private List<Episodio> episodios;

    public Temporada() {
    }

    public Temporada(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "id=" + id +
                ", numero=" + numero +
                ", descricao='" + descricao + '\'' +
                ", serie=" + serie.getNome() +
                "}\n";
    }
}
