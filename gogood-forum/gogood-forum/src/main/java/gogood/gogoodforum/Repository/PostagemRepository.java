package gogood.gogoodforum.Repository;

import gogood.gogoodforum.DTO.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface PostagemRepository extends JpaRepository <Postagem,Integer> {

    List<Postagem> findByIdUsuario(Integer id);
}
