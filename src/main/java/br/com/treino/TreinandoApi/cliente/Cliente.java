package br.com.treino.TreinandoApi.cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;
@Data
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private String email;


}
