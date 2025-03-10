import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorNomes gNomes;

        System.out.println("Escolha o tipo de armazenamento:");
        System.out.println("(1) Memória");
        System.out.println("(2) Arquivo");
        String opcao = scanner.nextLine();

        if ("1".equals(opcao)) {
            gNomes = new GerenciadorNomesMem();
        } else {
            gNomes = new GerenciadorNomesArq();
        }

        Ihm ihm = new Ihm(gNomes);
        ihm.dialogar();
    }
}
