import java.util.List;
import java.util.ArrayList;

public class GerenciadorNomesMem implements GerenciadorNomes{

    private List<String> nomes = new ArrayList<String>();

    @Override

    public List<String> obterNomes(){
        return nomes;
    }

    public void adicionarNome(String nome){
        nomes.add(nome);
    }

}

