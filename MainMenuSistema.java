package trabalhoEstruturaDados;

import java.util.Random;
import java.util.Scanner;

public class MainMenuSistema {
	
	static int horas = 0;
	static int minutos = 0;
	static int idPaciente = 10;
	static int idAtendimento = 1;
	static ListaMedico listaMedico = new ListaMedico();
	static ListaSalaMedica listaSalaMedica = new ListaSalaMedica(10);
	static ListaAtendimento listaAtendimento = new ListaAtendimento();
	static PilhaPacienteObservacao pilhaPaciente = new PilhaPacienteObservacao();
	static FilaAtendimento[] filas = new FilaAtendimento[5];
   
    
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) filas[i] = new FilaAtendimento(i + 1);

        cadastrarDadosIniciais(listaMedico, listaSalaMedica, filas);

        int opcao;
        do {
            System.out.println("\n======= MENU SISTEMA HOSPITALAR =======");
            System.out.println("1 - Visualizar Médicos");
            System.out.println("2 - Visualizar Salas Médicas");
            System.out.println("3 - Visualizar Filas de Pacientes");
            System.out.println("4 - Visualizar lista de Atendimentos");
            System.out.println("5 - Relatório Geral");
            System.out.println("6 - Visualizar Pilha de Pacientes em Observação");
            System.out.println("99 - Passar tempo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	System.out.println("\n");
                    listaMedico.mostrarLista();
                    break;
                case 2:
                	System.out.println("\n");
                    listaSalaMedica.mostrarLista();
                    System.out.println("\nMostrar Relação Id : Ocupada");
                    listaSalaMedica.mostrarRelacaoIdOcupada();
                    break;
                case 3:
                	System.out.println("\n");
                    for (FilaAtendimento fila : filas) {
                        fila.mostrarFila();
                    }
                    break;
                case 4:
                	System.out.println("\n");
                    listaAtendimento.mostrarLista();
                    break;
                case 5:
                	System.out.println("\n");
                    mostrarRelatorioGeral(listaMedico, listaSalaMedica, listaAtendimento, filas);
                    break;
                case 6:
                	System.out.println("\n");
                	pilhaPaciente.mostrarPilha();
                    break;
                case 0:
                	System.out.println("\n");
                    System.out.println("Encerrando o sistema.");
                    break;
                case 99:
                	System.out.println("\n");
                	System.out.println("Passando uma unidade de tempo");
                    passarTempo();
                    break;
                default:
                	System.out.println("\n");
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
	
	public static void passarTempo() {
	    minutos += 15;
	    if (minutos >= 60) {
	        minutos = 0;
	        horas++;
	    }
	    if (horas >= 24) {
	        horas = 0; // reinicia o dia
	    }

	    System.out.printf("Tempo atual: %02d:%02d\n", horas, minutos);
	    
	    for (FilaAtendimento fila : filas) {
            while (listaSalaMedica.temSalaLivre() && listaMedico.temMedicoLivre() && !fila.vazia()) {
            	realizarAtendimentos(filas);
            }
        }
	    
	    listaAtendimento.atualizarTempo(pilhaPaciente);
	    
	    Random sorteio = new Random();
		int sairDaObservacao = sorteio.nextInt(100) + 1;
		if (sairDaObservacao <= 10) {
			pilhaPaciente.liberacaoLeitos();
		}
	    
		int novoPaciente = sorteio.nextInt(100) + 1;
		if (novoPaciente <= 20) {
			int quantosPaciente = sorteio.nextInt(2) + 1;
			for (int i=0;i<quantosPaciente;i++) {
				gerarPacienteAleatorio(idPaciente);
				idPaciente++;
			}
		}
	}

    private static void cadastrarDadosIniciais(ListaMedico listaMedico, ListaSalaMedica listaSalaMedica, FilaAtendimento[] filas) {
        // Médicos
        listaMedico.inserirFinal(new Medico(1, "Roberto", "Neuro", "10:00-22:00"));
        listaMedico.inserirFinal(new Medico(2, "Carlos", "Cardio", "10:00-22:00"));
        listaMedico.inserirFinal(new Medico(3, "Pedro", "Cirurgia", "09:00-23:00"));
        listaMedico.inserirInicio(new Medico(4, "Rafael", "Fisio", "00:00-12:00"));
        listaMedico.inserirInicio(new Medico(5, "Eduardo", "Neuro", "03:00-18:00"));

        // Salas
        for (int i = 1; i <= 9; i++) {
            listaSalaMedica.inserirInicio(new SalaMedica(i));
        }

        // Pacientes
        Paciente[] pacientes = {
            new Paciente(1, "Alberto Rodrigues", "Dor de cabeça, náuseas"),
            new Paciente(2, "Eduardo Silva", "Dor nas costas"),
            new Paciente(3, "Bernardo França", "Tontura, náusea"),
            new Paciente(4, "Rafael Menezgaz", "Dor de cabeça"),
            new Paciente(5, "Josué Ferreira", "Perdeu o dedo"),
            new Paciente(6, "Floriano Lipe", "Perna Quebrada"),
            new Paciente(7, "Pedro Malboro", "náuseas"),
            new Paciente(8, "Cassiano Tord", "Falta de Ar, Dor no pulmão esquerdo"),
            new Paciente(9, "Melhado Ganes", "Dor de cabeça")
        };

        for (Paciente p : pacientes) {
            p.triagem(filas[0], filas[1], filas[2], filas[3], filas[4]);
        }
    }

    private static void realizarAtendimentos(FilaAtendimento[] filas) {
       
        for (FilaAtendimento fila : filas) {
            while (listaSalaMedica.temSalaLivre() && listaMedico.temMedicoLivre() && !fila.vazia()) {
                Atendimento atendimento = new Atendimento(idAtendimento++, listaSalaMedica.salaLivre(), listaMedico.medicoLivre(), fila.irParaAtendimento());
                listaAtendimento.inserirFinal(atendimento);
            }
        }
        System.out.println("Atendimentos realizados com sucesso!");
    }

    private static void mostrarRelatorioGeral(ListaMedico listaMedico, ListaSalaMedica listaSalaMedica, ListaAtendimento listaAtendimento, FilaAtendimento[] filas) {
        System.out.println("\n---- RELATÓRIO GERAL ----");
        System.out.println("Médicos:");
        listaMedico.mostrarLista();

        System.out.println("\nSalas Médicas:");
        listaSalaMedica.mostrarLista();
        
        System.out.println("\nRelação Sala : Ocupada");
        listaSalaMedica.mostrarRelacaoIdOcupada();

        System.out.println("\nFila de Atendimento (por prioridade):");
        for (FilaAtendimento fila : filas) {
            fila.mostrarFila();
        }

        System.out.println("\nLista de Atendimentos:");
        listaAtendimento.mostrarLista();
    }
    
    public static void gerarPacienteAleatorio(int id) {
    	System.out.println("APARECEU UM NOVO PACIENTE");
		String[] nomes = { "Ana", "Bruno", "Carlos", "Daniela", "Eduarda", "Fernando", "Giovana", "Henrique" };
		String[] sintomas = {
			"Dor de cabeça", "Náusea", "Tontura", "Falta de ar", "Dor no peito", "Fratura", "Febre", "Desmaio"
		};
		Random r = new Random();
		Paciente paciente = new Paciente(id, nomes[r.nextInt(nomes.length)] + " " + (char)(r.nextInt(26) + 'A') + ".",
				sintomas[r.nextInt(sintomas.length)]);
		
		paciente.triagem(filas[0], filas[1], filas[2], filas[3], filas[4]);
		
		
		
	}
    
    
}
