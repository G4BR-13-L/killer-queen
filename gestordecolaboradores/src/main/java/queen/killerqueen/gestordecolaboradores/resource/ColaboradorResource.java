package queen.killerqueen.gestordecolaboradores.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import queen.killerqueen.gestordecolaboradores.model.Colaborador;
import queen.killerqueen.gestordecolaboradores.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorResource {

    private final ColaboradorService colaboradorService;

    public ColaboradorResource(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Colaborador>> getAllColaboradores() {
        List<Colaborador> colaboradores = colaboradorService.findAllColaboradores();
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Colaborador> getColaboradorById(@PathVariable("id") Long id) {
        Colaborador colaborador = colaboradorService.findColaboradorById(id);
        return new ResponseEntity<>(colaborador, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Colaborador> addColaborador(@RequestBody Colaborador colaborador){
        Colaborador novoColaborador = colaboradorService.addColaborador(colaborador);
        return new ResponseEntity<>(colaborador, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Colaborador> updateColaborador(@RequestBody Colaborador colaborador){
        Colaborador updateColaborador = colaboradorService.updateColaborador(colaborador);
        return new ResponseEntity<>(colaborador, HttpStatus.CREATED);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteColaborador(@PathVariable("id") Long id){
        colaboradorService.deleteColaborador(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
