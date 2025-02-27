import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GerenciadorNomesArq implements GerenciadorNomes {


    public static void obterNomes(String nomes){

       Path path = Paths.get("/workspaces/ps2-2025s1/Lab03/src/arquivo.txt");
		try {
			byte[] bs = Files.readAllBytes(path);
			List<String> strings = Files.readAllLines(path);
			
			System.out.println("Read bytes: \n"+new String(bs));
			System.out.println("Read lines: \n"+strings);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    public adicionarNomes(String nomeArq, String conteudo){
            Path filePath = Paths.get(arquivo.txt);
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
        for (String str : stringList ) {
            Files.writeString(filePath, str + System.lineSeparator(),
            StandardOpenOption.APPEND);
}
return filePath.toString();
    }
    

    
}
