package queen.killerqueen.gestordecolaboradores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import queen.killerqueen.gestordecolaboradores.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository <Colaborador, Long>{
    
}
