/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import entidades.Cliente;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class Utils {
    @Produces
    public EntityManagerFactory criarFabrica(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoweb2PU");
        return factory;
    }
    @Produces
    public EntityManager criaConexao(EntityManagerFactory fabrica){
        
        return fabrica.createEntityManager();
    }
    
    public void enviaremail(@Observes Cliente cliente ){
        System.out.println("Email enviado");
        
    }
}
