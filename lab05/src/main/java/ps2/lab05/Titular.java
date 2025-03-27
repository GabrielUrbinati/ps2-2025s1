package ps2.lab05;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Titular{
    @Id
    private Long id;
    private String nome;
    private String cpf;
    public Titular(){};
    public Titular(Long id, String n,String c){
        this.id=id;
        nome=n;
        cpf=c;

    }
    public void setId( long id){
        this.id=id;
    }
    public long getId(){
        return id;
    }
    public void setNome(String n){
        nome=n;

    }
    public String getNome(){
        return nome;
    }

    public void setCpf(String c) {
        cpf = c;
    }
    public String getCpf() {
        return cpf;
    }
}