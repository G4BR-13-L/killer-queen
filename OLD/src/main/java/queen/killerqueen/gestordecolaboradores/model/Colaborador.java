package queen.killerqueen.gestordecolaboradores.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
@Entity
public class Colaborador implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nome;    
    private String email;
    private String cargo;
    private String telefone;
    private String imgUrl;    
    @Column(nullable = false, updatable = false)
    private String codigoColaborador;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImgUrl() {
        return imgUrl;
    }


    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getCodigoColaborador() {
        return codigoColaborador;
    }

    public void setCodigoColaborador(String codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }

}
