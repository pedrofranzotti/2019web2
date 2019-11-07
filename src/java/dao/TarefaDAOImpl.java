/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Tarefa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class TarefaDAOImpl implements TarefaDAO{
    private EntityManagerFactory fac = 
            Persistence.createEntityManagerFactory("projetoweb2PU");
    public void save (Tarefa tarefa){
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();
        if(tarefa.getId()>0){
            em.merge(tarefa);
        }else{
            em.persist(tarefa);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Tarefa tarefa){
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();
     
        if(!em.contains(tarefa)){
            em.refresh(tarefa);
        }
        
        em.remove(tarefa);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public Tarefa find(int id){
        EntityManager em = fac.createEntityManager();
        return em.find(Tarefa.class, id);
    }
    
    public List<Tarefa> list(){
        EntityManager em = fac.createEntityManager();
        Query q = em.createQuery("SELECT t FROM Tarefa as t ORDER BY t.id");
        return q.getResultList();
    }


}
