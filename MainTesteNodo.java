package trabalhoEstruturaDados;

public class MainTesteNodo {

	public static void main(String[] args) {
		System.out.println("-----------------TESTE MEDICOS----------------------");
		
		Medico medico1 = new Medico(1, "Roberto", "Neuro", "10:00-22:00");
		Medico medico2 = new Medico(2, "Carlos", "Cardio", "10:00-22:00");
		Medico medico3 = new Medico(3, "Pedro", "Cirurgia", "09:00-23:00");
		Medico medico4 = new Medico(4, "Rafael", "Fisio", "00:00-12:00");
		Medico medico5 = new Medico(5, "Eduardo", "Neuro", "03:00-18:00");
		
		ListaMedico listaMedico = new ListaMedico();
		
		listaMedico.inserirFinal(medico1);	
		listaMedico.inserirFinal(medico2);
		listaMedico.inserirFinal(medico3);
		
		System.out.println(listaMedico.toString());
		
		System.out.println("---------------------------------------");
		
		listaMedico.inserirInicio(medico4);
		listaMedico.inserirInicio(medico5);
		
		System.out.println("A seguir, lista de médicos separada por linha:");
		listaMedico.mostrarLista();
		
		System.out.println("---------------------------------------");
		
		System.out.println("A seguir, lista de nome dos médico:");
		listaMedico.mostrarListaPorNome();

		System.out.println("\n\n-----------------TESTE SALAS MEDICAS----------------------");
		
		SalaMedica sala1 = new SalaMedica(1);
		SalaMedica sala2 = new SalaMedica(2);
		SalaMedica sala3 = new SalaMedica(3);
		SalaMedica sala4 = new SalaMedica(4);
		SalaMedica sala5 = new SalaMedica(5);
		SalaMedica sala5copia = new SalaMedica(5);
		SalaMedica sala6 = new SalaMedica(6);
		SalaMedica sala7 = new SalaMedica(7);
		SalaMedica sala8 = new SalaMedica(8);
		SalaMedica sala9 = new SalaMedica(9);
		
		
		ListaSalaMedica listaSalaMedica = new ListaSalaMedica(10);
		
		listaSalaMedica.inserirFinal(sala1);
		listaSalaMedica.inserirFinal(sala2);
		listaSalaMedica.inserirFinal(sala3);
		listaSalaMedica.inserirInicio(sala4);
		listaSalaMedica.inserirInicio(sala5);
		listaSalaMedica.inserirInicio(sala5copia);// testando id repetido
		listaSalaMedica.inserirInicio(sala6);
		listaSalaMedica.inserirInicio(sala7);
		listaSalaMedica.inserirInicio(sala8);
		listaSalaMedica.inserirInicio(sala9);
	
		
		System.out.println(listaSalaMedica.toString());
		
		System.out.println("---------------------------------------");
		
		System.out.println("A seguir, lista de salas médicas separada por linha:");
		listaSalaMedica.mostrarLista();
		
		System.out.println("---------------------------------------");
		
		System.out.println("A seguir, relação entre sala médica e se esta está ocupadsa, separada por linha:");
		listaSalaMedica.mostrarRelacaoIdOcupada();
		
		System.out.println("\n\n-----------------TESTE PACIENTE E FILA ATENDIMENTO----------------------");
		
		FilaAtendimento[] fila = new FilaAtendimento[5];
        for (int i = 0; i < 5; i++) fila[i] = new FilaAtendimento(i + 1);
		
		/*FilaAtendimento filaPrioridade1 = new FilaAtendimento(1);
		FilaAtendimento filaPrioridade2 = new FilaAtendimento(2);
		FilaAtendimento filaPrioridade3 = new FilaAtendimento(3);
		FilaAtendimento filaPrioridade4 = new FilaAtendimento(4);
		FilaAtendimento filaPrioridade5 = new FilaAtendimento(5);
		
		Paciente paciente1 = new Paciente(1, "Alberto Rodrigues", "Dor de cabeça, náuseas");
		Paciente paciente2 = new Paciente(2, "Eduardo Silva", "Dor nas costas");
		Paciente paciente3 = new Paciente(3, "Bernardo França", "Tontura, náusea");
		Paciente paciente4 = new Paciente(4, "Rafael Menezgaz", "Dor de cabeça");
		Paciente paciente5 = new Paciente(5, "Josué Ferreira", "Perdeu o dedo");
		Paciente paciente6 = new Paciente(6, "Floriano Lipe", "Perna Quebrada");
		Paciente paciente7 = new Paciente(7, "Pedro Malboro", "náuseas");
		Paciente paciente8 = new Paciente(8, "Cassiano Tord", "Falta de Ar, Dor no pulmão esquerdo");
		Paciente paciente9 = new Paciente(9, "Melhado Ganes", "Dor de cabeça");*/
		
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
            p.triagem(fila[0], fila[1], fila[2], fila[3], fila[4]);
        }
		
		/*paciente1.triagem(fila, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente2.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente3.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente4.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente5.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente6.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente7.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente8.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		paciente9.triagem(filaPrioridade1, filaPrioridade2, filaPrioridade3, filaPrioridade4, filaPrioridade5);
		
		filaPrioridade1.mostrarFila();
		filaPrioridade2.mostrarFila();
		filaPrioridade3.mostrarFila();
		filaPrioridade4.mostrarFila();
		filaPrioridade5.mostrarFila();*/
		
		
		System.out.println("\n\n-----------------TESTE ATENDIMENTO E FILA ATENDIMENTO----------------------");
		
		ListaAtendimento listaAtendimento = new ListaAtendimento();
		
		
		int idAtendimento = 1;
		while (listaSalaMedica.temSalaLivre() && !fila[0].vazia() && listaMedico.temMedicoLivre()) {
			Atendimento atendimento = new Atendimento(idAtendimento, listaSalaMedica.salaLivre(), listaMedico.medicoLivre(), fila[0].irParaAtendimento());
			listaAtendimento.inserirFinal(atendimento);
			idAtendimento++;
		}
		while (listaSalaMedica.temSalaLivre() && !fila[1].vazia() && listaMedico.temMedicoLivre()) {
			Atendimento atendimento = new Atendimento(idAtendimento, listaSalaMedica.salaLivre(), listaMedico.medicoLivre(), fila[1].irParaAtendimento());
			listaAtendimento.inserirFinal(atendimento);
			idAtendimento++;
		}
		while (listaSalaMedica.temSalaLivre() && !fila[2].vazia() && listaMedico.temMedicoLivre()) {
			Atendimento atendimento = new Atendimento(idAtendimento, listaSalaMedica.salaLivre(), listaMedico.medicoLivre(), fila[2].irParaAtendimento());
			listaAtendimento.inserirFinal(atendimento);
			idAtendimento++;
		}
		while (listaSalaMedica.temSalaLivre() && !fila[3].vazia() && listaMedico.temMedicoLivre()) {
			Atendimento atendimento = new Atendimento(idAtendimento, listaSalaMedica.salaLivre(), listaMedico.medicoLivre(), fila[3].irParaAtendimento());
			listaAtendimento.inserirFinal(atendimento);
			idAtendimento++;
		}
		while (listaSalaMedica.temSalaLivre() && !fila[4].vazia() && listaMedico.temMedicoLivre()) {
			Atendimento atendimento = new Atendimento(idAtendimento, listaSalaMedica.salaLivre(), listaMedico.medicoLivre(), fila[4].irParaAtendimento());
			listaAtendimento.inserirFinal(atendimento);
			idAtendimento++;
		}
		
		System.out.println("\nA seguir, lista de atendimento separada por linha to String:");
		listaAtendimento.mostrarListaToString();
		
		System.out.println("\nA seguir, lista de atendimento separada por linha:");
		listaAtendimento.mostrarLista();
		
		System.out.println("\nA seguir, relação entre sala médica e se esta está ocupadsa, separada por linha:");
		listaSalaMedica.mostrarRelacaoIdOcupada();
		
		System.out.println("\nA seguir, lista de médicos separada por linha:");
		listaMedico.mostrarLista();
		
		System.out.println("-------------------------FILA DE ATENDIMENTO APÓS OS ATENDIMENTOS-------------------------");
		fila[0].mostrarFila();
		fila[1].mostrarFila();
		fila[2].mostrarFila();
		fila[3].mostrarFila();
		fila[4].mostrarFila();
		
		
		
		
		
		
		
	}

}
