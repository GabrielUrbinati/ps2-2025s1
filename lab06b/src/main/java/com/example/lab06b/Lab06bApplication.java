package com.example.lab06b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.Scanner;


@SpringBootApplication
public class Lab06bApplication implements CommandLineRunner {

	@Autowired
	private ProfessorRepo professorRepo;

	@Autowired
	private FaculdadeRepo faculdadeRepo;

	private static Scanner entrada = new Scanner(System.in);



	public static void main(String[] args) {
		SpringApplication.run(Lab06bApplication.class, args);
	}

	@Override
	public void run(String... args) {
		out.println("# Gerenciador de Professores e Faculdades!");
		boolean sair = false;
		while (!sair){
			out.println("1 - cadastrar faculdade");
			out.println("2 - listar faculdade");
			out.println("3 - cadastrar professor");
			out.println("4 - listar professor");
			out.println("5 - sair");

			out.println("escolha uma opção");

			int opc = Integer.parseInt(entrada.nextLine());
			switch (opc){
				case 1 : cadFacul();break;
				case 2 : listFacul();break;
				case 3 : cadProf();break;
				case 4 : listProf();break;

				default:
				out.println("Pressione ENTER para terminar o programa...");
				

		}

		private void cadFacul(){
			out.println("Criação de nova faculdade");
			out.println("Nome:");

			String nome = entrada.nextLine();
			out.print("ano");
			int ano = Integer.parseInt(entrada.nextLine());
			Faculdade f = new Faculdade(nome,ano);
			faculdadeRepo.save(f);

		}

		private void listFacul(){
			out.print("Lista");
			Iterable<Faculdade> faculdades = faculdadeRepo.findAll();
			//faculdades.forEach(System.out::println);
			for (Faculdade f : faculdades){
				out.println("["+ f.getId()+"]" + f.getAnoFundacao() + "["+f.getNome()+"]")
			}

		private void cadProf(){
			out.print("Cadastrar Professor");
			out.print("Qual o nome do professor?");
			String nome = entrada.nextLine();
			out.print("Qual o cpf do professor?");
			int cpf = Integer.parseInt(entrada.nextLine());
			out.print("Qual a matricula do professor?");
			int m = Integer.parseInt(entrada.nextLine());


			Professor p = new Professor();
			professorRepo.save(p);

		}

		private void listProf(){
			out.print("Lista de professores");
			Iterable<Professor> professores = professorRepo.findAll();
			for( Professor p: professores){
				out.println("["+p.getNome()+"]"+"["+p.getCpf()+"["+p.getMatricula()+"]");
			}





		}



	
	}



