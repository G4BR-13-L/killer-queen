package queen.killerqueen.gestordecolaboradores.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import queen.killerqueen.gestordecolaboradores.model.Colaborador;
import queen.killerqueen.gestordecolaboradores.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepo;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepo) {
        this.colaboradorRepo = colaboradorRepo;
    }

    public Colaborador addColaborador(Colaborador colaborador) {
        colaborador.setCodigoColaborador(UUID.randomUUID().toString());
        return colaboradorRepo.save(colaborador);
    }

    public List<Colaborador> findAllColaboradores() {
        return colaboradorRepo.findAll();
    }

    public Colaborador updateColaborador(Colaborador colaborador) {
        return colaboradorRepo.save(colaborador);
    }

    public Colaborador findColaboradorById(Long id){
        return colaboradorRepo.findColaboradorById(id);
    }

    public void deleteColaborador(Long id) {
        colaboradorRepo.deleteColaboradorById(id);
    }
}
