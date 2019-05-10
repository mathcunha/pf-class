package com.pfclass.jpa.repository;

import com.pfclass.jpa.entity.Vet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class VetDAO {

    private final Logger log = LoggerFactory.getLogger(VetDAO.class);

    //TODO - https://www.devmedia.com.br/jpa-e-hibernate-acessando-dados-em-aplicacoes-java/32711
    //TODO - https://www.objectdb.com/java/jpa/query/jpql/structure
    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED )
    public void save(Vet v){
        em.persist(v);
    }

    public Optional<Vet> findById(Long id){
        return Optional.of(em.find(Vet.class, id));
    }

    public List<Vet> findByLastName(String lastName){
        TypedQuery<Vet> query = em.createQuery("SELECT v FROM Vet AS v WHERE v.lastName = :lastName", Vet.class);
        return query.setParameter("lastName", lastName).getResultList();
    }

    public List<Vet> findAll(){
        return em.createQuery("SELECT v FROM Vet AS v", Vet.class).getResultList();
    }
}
