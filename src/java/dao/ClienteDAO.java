/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface ClienteDAO {
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public Cliente find(int id);
    public List<Cliente> list();
}
