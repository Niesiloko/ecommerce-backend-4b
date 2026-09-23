package br.edu.unifio.ecommerce.Repositorios;

import br.edu.unifio.ecommerce.entidades.Categoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;




@SpringBootTest
public class CategoriaRepositorioTest {

    @Autowired
    private CategoriaRepository repositorios;

    @Test
    public void testBuscarPorId() {
        Optional<Categoria> resultado = repositorios.findById((short) 1);
        assertTrue(resultado.isPresent(), "A categoria com ID 1 deveria existir.");
    }
}