package gogood.gogoodforum.Controller;

import gogood.gogoodforum.DTO.Postagem;
import gogood.gogoodforum.Repository.PostagemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequestMapping("/postagens")
@RestController
public class PostagemController {

    @Autowired
    private PostagemRepository repository;


    @PostMapping()
    public ResponseEntity<Postagem> add(@RequestBody @Valid Postagem novaPostagem){
        repository.save(novaPostagem);
        return ResponseEntity.ok().body(novaPostagem);
    }

    @GetMapping()
    public ResponseEntity<List<Postagem>> exibeAll(){
        var lista = repository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @GetMapping("{id}")
    public  ResponseEntity<List<Postagem>> exibePorId(@PathVariable Integer id){
        var lista = repository.findByIdUsuario(id);
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
