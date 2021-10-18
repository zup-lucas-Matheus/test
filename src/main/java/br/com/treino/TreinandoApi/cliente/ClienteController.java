package br.com.treino.TreinandoApi.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listaDeClientes(){
      return   clienteService.allClients();
    }

    @PutMapping
    public void atualizarCliente(@RequestBody Cliente cliente){
        clienteService.updatCliente(cliente);
    }

    @DeleteMapping
    public void deletarClientePorId(String cpf){
        clienteService.delete(cpf);
    }

    @GetMapping("{/cpfCliente}")
    public Cliente encontrarClientePorId(@PathVariable(name = "cpfCliente") String cpf){
        return clienteService.findByIdCliente(cpf);
    }





}
