import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesArq implements GerenciadorNomes {

    private static final String ARQUIVO_NOMES = "arquivo.txt";
    private Path filePath;

    public GerenciadorNomesArq() {
        this.filePath = Paths.get(ARQUIVO_NOMES);
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        try {
            nomes = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() > MAX_CARACTERES_NOMES) {
            System.out.println("Erro: Nome excede o limite de caracteres.");
            return;
        }
        try {
            Files.write(filePath, (nome + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
