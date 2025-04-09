package com.example.lab07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.out;

@SpringBootApplication
public class Lab06bApplication implements CommandLineRunner {

    @Autowired
    private MusicaRepo musicaRepo;

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(Lab06bApplication.class, args);
    }

    @Override
    public void run(String... args) {
        out.println("# Gerenciador de cadastro de músicas!");
        boolean sair = false;

        while (!sair) {
            out.println("\nMenu:");
            out.println("1 - Cadastrar música");
            out.println("2 - Listar músicas");
            out.println("3 - Atualizar música");
            out.println("4 - Deletar música");
            out.println("5 - Sair");

            out.print("Escolha uma opção: ");
            int opc = Integer.parseInt(entrada.nextLine());

            switch (opc) {
                case 1 -> cadastrarMusica();
                case 2 -> listarMusicas();
                case 3 -> atualizarMusica();
                case 4 -> deletarMusica();
                case 5 -> {
                    sair = true;
                    out.println("Saindo...");
                }
                default -> out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarMusica() {
        out.print("Título: ");
        String titulo = entrada.nextLine();
        out.print("Compositor: ");
        String compositor = entrada.nextLine();
        out.print("Ano: ");
        int ano = Integer.parseInt(entrada.nextLine());

        Musica m = new Musica(titulo, compositor, ano);
        musicaRepo.save(m);
        out.println("Música cadastrada com sucesso!");
    }

    private void listarMusicas() {
        Iterable<Musica> musicas = musicaRepo.findAll();
        for (Musica m : musicas) {
            out.println("[" + m.getId() + "] " + m.getTitulo() + " - " + m.getCompositor() + " (" + m.getAno() + ")");
        }
    }

    private void atualizarMusica() {
        out.print("ID da música que deseja atualizar: ");
        Long id = Long.parseLong(entrada.nextLine());
        Optional<Musica> optional = musicaRepo.findById(id);

        if (optional.isPresent()) {
            Musica m = optional.get();
            out.print("Novo título (atual: " + m.getTitulo() + "): ");
            m.setTitulo(entrada.nextLine());
            out.print("Novo compositor (atual: " + m.getCompositor() + "): ");
            m.setCompositor(entrada.nextLine());
            out.print("Novo ano (atual: " + m.getAno() + "): ");
            m.setAno(Integer.parseInt(entrada.nextLine()));

            musicaRepo.save(m);
            out.println("Música atualizada com sucesso!");
        } else {
            out.println("Música não encontrada.");
        }
    }

    private void deletarMusica() {
        out.print("ID da música que deseja deletar: ");
        Long id = Long.parseLong(entrada.nextLine());

        if (musicaRepo.existsById(id)) {
            musicaRepo.deleteById(id);
            out.println("Música deletada com sucesso.");
        } else {
            out.println("Música não encontrada.");
        }
    }
}
