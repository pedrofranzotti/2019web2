/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entidades.Tarefa;

import java.util.List;
public interface TarefaDAO {
    public void save(Tarefa tarefa);
    public void delete(Tarefa tarefa);
    public Tarefa find(int id);
    public List<Tarefa> list();


}
