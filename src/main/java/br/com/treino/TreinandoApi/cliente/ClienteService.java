package br.com.treino.TreinandoApi.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //Created
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    //Read
    public List<Cliente> allClients(){
        return (List<Cliente>) clienteRepository.findAll();
    }
    //Update
    public void updatCliente(Cliente cliente){
        Cliente clienteUpdate = findByIdCliente(cliente.getCpf());

        clienteUpdate.setEmail(cliente.getEmail());
        clienteUpdate.setNome(cliente.getNome());
        clienteUpdate.setTelefone(cliente.getTelefone());

        clienteRepository.save(clienteUpdate);

    }
    //Delete
    public void delete(String cpf){
        clienteRepository.delete(findByIdCliente(cpf));
    }

    //FindByClientForId
    public Cliente findByIdCliente(String cpf){
       return clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    }

}
