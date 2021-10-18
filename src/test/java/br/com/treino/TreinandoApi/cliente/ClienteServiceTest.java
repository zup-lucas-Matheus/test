package br.com.treino.TreinandoApi.cliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private ClienteRepository clienteRepositoryMock;

    private Cliente cliente;

    @BeforeEach
    void setUp(){
        this.cliente = new Cliente();
        Mockito.when(clienteRepositoryMock.save(Mockito.any(Cliente.class)))
                .thenReturn(cliente);

        List<Cliente> clientes = Arrays.asList(cliente);
        Mockito.when(clienteRepositoryMock.findAll())
                .thenReturn(clientes);


    }

    @Test
    @DisplayName("Metódo que cadastrar o usuario com sucesso")
    void save_CadastrarCliente_CaminhoPositivo(){

        Cliente clienteEsperado = clienteService.saveCliente(cliente);
                Assertions.assertEquals(cliente, clienteEsperado);

    }
    @Test
    @DisplayName("Lista onde trás todos os clientes já cadastrados no BD")
    void read_ListaDeTodosOsCliente_CaminhoPositivo(){
        List<Cliente> clientes = Arrays.asList(cliente);
        Assertions.assertEquals(clientes, clienteService.allClients());

    }

/*
    @Test
    @DisplayName("Metódo que atualiza Usuario ao Encontrar Pelo Id")
    void update_atualizarUsuarioAoEncontrarPeloId_CaminhoPositivo(){

    }
*/



}
