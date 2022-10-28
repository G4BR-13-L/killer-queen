package queen.killerqueen.gestordecolaboradores.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import queen.killerqueen.gestordecolaboradores.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository <Colaborador, Long>{

    void deleteColaboradorById(Long id);

    Colaborador findColaboradorById(Long id);
    
}
