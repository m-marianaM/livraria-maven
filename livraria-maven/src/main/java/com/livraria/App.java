package com.livraria;

import com.livraria.entity.Autor;
import com.livraria.entity.Editora;
import com.livraria.entity.Livro;
import com.livraria.entity.TipoPublicacao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrariaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Autor autor = new Autor("Machado de Assis", "Brasileira");
        Editora editora = new Editora("Companhia das Letras", "São Paulo");

        em.persist(autor);
        em.persist(editora);

        Livro livro = new Livro(
                "Dom Casmurro",
                1899,
                "978-85-359-0277-7",
                new BigDecimal("39.90"),
                TipoPublicacao.IMPRESSO,
                autor,
                editora
        );

        em.persist(livro);

        em.getTransaction().commit();

        System.out.println("Livro salvo com sucesso: " + livro);

        em.close();
        emf.close();
    }
}
