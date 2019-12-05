/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity 
@Table(name="cliente") // Nome da tabela no banco de dados
@SequenceGenerator(name="seq_cliente", sequenceName="cliente_id_seq", allocationSize=1)
// o nem é no escopo do java
// cliente_id_seq pega com comando no postgres \d cliente
// allocationSize=1 tamanho do passo dentro do incremento
public class Cliente {
    @Id
    @Column(name="id")//Não obrigatório se o nome da variável foi o nome da coluna.
    @GeneratedValue(generator="seq_cliente", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="nome")
    private String nome;
    private String cpf;
    @Column(name="telefone")
    private String telefone;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

        public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

    
    
}
