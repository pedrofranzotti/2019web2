package cdi;

import dao.ClienteDAO;
import entidades.Cliente;
import java.util.List;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class ClienteDAODecorator implements ClienteDAO{

    @Inject @Delegate @Any
    private ClienteDAO dao;
    
    @Inject
    private EntityManager manager;
    
    public void save(Cliente cliente) {
        Query q = manager.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf");
        q.setParameter("cpf", cliente.getCpf());
        List c = q.getResultList();
        System.out.println(c.isEmpty());
        if(c.isEmpty()){
            dao.save(cliente);
        } else{
            System.out.println("CPF já cadastrado");
        }
        
        dao.save(cliente);
    }

    
    public void delete(Cliente cliente) {
        dao.delete(cliente);
    }

    
    public Cliente find(int id) {
        return dao.find(id);
                
    }

    
    public List<Cliente> list() {
        return dao.list();
    }
    
}
