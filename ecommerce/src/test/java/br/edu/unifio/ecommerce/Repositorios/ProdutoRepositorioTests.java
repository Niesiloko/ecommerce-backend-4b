package br.edu.unifio.ecommerce.Repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.ecommerce.entidades.Categoria;
import br.edu.unifio.ecommerce.entidades.Produto;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
@DataJpaTest 

public class ProdutoRepositorioTests {
    @Autowired 
    private CategoriaRepository categoriaRepositorio;

    @Autowired 
    private ProdutoRepository produtoRepositorio;

    @Test
    @DisplayName ("Deve inserir um produto com relacionamento de categoria")
    public void testInserirProduto() {
        // Estabelecendo os relacionamentos necessários
        Categoria categoria = new Categoria();
        categoria.setNome("Hardware");
        categoria = categoriaRepositorio.save(categoria);

        // Criando e preenchendo os atributos
        Produto produto = new Produto();
        produto.setNome ("SSD XPG 1TB");
        produto.setPreco (450.00);
        produto.setCategoria(categoria); // Associando a uma categoria existente[cite: 6]

        // Persistindo o objeto[cite: 6]
        Produto produtoSalvo = produtoRepositorio.save(produto);

        // Utilizando assert para verificar a operação[cite: 6]
        Assertions.assertNotNull(produtoSalvo.getId(), "O ID não deve ser nulo após o insert");
        Assertions.assertEquals("SSD XPG 1TB", produtoSalvo.getNome());
        Assertions.assertEquals(categoria.getId(), produtoSalvo.getCategoria().getId());
    }

    // 2. Busca por ID[cite: 6]
    @Test
    @DisplayName("Deve buscar um produto pelo ID e validar seus atributos")
    public void testBuscarPorId() {
        Categoria categoria = categoriaRepositorio.save(new Categoria("Periféricos"));
        Produto produtoInserido = produtoRepositorio.save(new Produto("Teclado Mecânico", 350.00, categoria)); // Insere um registro[cite: 6]

        // Realiza a busca utilizando o ID[cite: 6]
        Optional<Produto> produtoEncontrado = produtoRepositorio.findById(produtoInserido.getId());

        // Verifica se corresponde e valida dois atributos[cite: 6]
        Assertions.assertTrue(produtoEncontrado.isPresent());
        Assertions.assertEquals("Teclado Mecânico", produtoEncontrado.get().getNome());
        Assertions.assertEquals(350.00, produtoEncontrado.get().getPreco());
    }

    // 3. Listagem[cite: 6]
    @Test
    @DisplayName("Deve listar todos os registros persistidos")
    public void testListarProdutos() {
        Categoria categoria = categoriaRepositorio.save(new Categoria("Componentes"));
        
        // Insere pelo menos dois registros[cite: 6]
        produtoRepositorio.save(new Produto("Processador", 1200.00, categoria));
        produtoRepositorio.save(new Produto("Placa Mãe", 800.00, categoria));

        // Utiliza o método de listagem[cite: 6]
        List<Produto> produtos = produtoRepositorio.findAll();

        // Valida a quantidade de registros retornados[cite: 6]
        Assertions.assertTrue(produtos.size() >= 2, "A lista deve conter no mínimo 2 registros");
    }

    // 4. Alteração[cite: 6]
    @Test
    @DisplayName("Deve alterar um atributo de um registro existente")
    public void testAlterarProduto() {
        Categoria categoria = categoriaRepositorio.save(new Categoria("Games"));
        Produto produto = produtoRepositorio.save(new Produto("Mouse Gamer", 150.00, categoria)); // Insere um registro[cite: 6]

        // Altera pelo menos um atributo[cite: 6]
        produto.setPreco(120.00);
        
        // Persiste a alteração (modificando o registro existente)[cite: 6]
        produtoRepositorio.save(produto); 

        // Nova consulta e assert para comprovar a mudança[cite: 6]
        Produto produtoAtualizado = produtoRepositorio.findById(produto.getId()).get();
        Assertions.assertEquals(120.00, produtoAtualizado.getId().getPreco(), "O valor do produto não foi alterado corretamente");
    }

    // 5. Exclusão[cite: 6]
    @Test
    @DisplayName("Deve excluir um registro via ID")
    public void testExcluirProduto() {
        Categoria categoria = categoriaRepositorio.save(new Categoria("Monitores"));
        Produto produto = produtoRepositorio.save(new Produto("Monitor Ultrawide", 1500.00, categoria)); // Insere um registro[cite: 6]
        Integer idProduto = produto.getId();

        Assertions.assertTrue(produtoRepositorio.findById(idProduto).isPresent());

 
        produtoRepositorio.deleteById(idProduto);

        
        Assertions.assertTrue(produtoRepositorio.findById(idProduto).isEmpty(), "O registro deveria ter sido excluído do banco");
    }
}