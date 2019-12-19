/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cdi.Auditavel;
import cdi.DAOQualifier;
import entidades.Cliente;
import java.util.List;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class ClienteDAOImpl implements ClienteDAO{
    @Inject
    private EntityManagerFactory fabrica;
    //private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("projetoweb2PU");
    @Inject
    private Event<Cliente> evento;
    
    public void save(Cliente cliente){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(cliente.getId()>0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
        em.getTransaction().commit();
        em.close();
        evento.fire(cliente);
    }
    public void delete(Cliente cliente){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(cliente)){
            cliente = em.merge(cliente);
        }
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
                
    }
    public Cliente find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Cliente.class, id);
    }
    public List<Cliente> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Cliente c ORDER BY c.id");
        // query na linguagem JPQL
        return q.getResultList();
    }
    
}
