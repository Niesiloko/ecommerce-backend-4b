package br.edu.unifio.ecommerce.Recursos;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unifio.ecommerce.entidades.Produto;
import br.edu.unifio.ecommerce.Repositorios.ProdutoRepository;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping ("produtos") 
public class ProdutoRecurso {
    private final ProdutoRepository produtoRepositorio;

    public ProdutoRecurso(ProdutoRepository produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }
    
    @GetMapping 
    public List<Produto> listar () {
        return produtoRepositorio.findAll(Sort.by("nome"));
    }

    @GetMapping ("{id}")
    public Produto buscarPorId (@PathVariable Integer id) {
        return produtoRepositorio.findById(id).orElseThrow();
    }
}