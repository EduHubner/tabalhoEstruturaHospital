package trabalhoEstruturaDados;

import java.util.Random;

public class ListaAtendimento {

	protected Nodo<Atendimento> inicio;

	public Nodo<Atendimento> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<Atendimento> inicio) {
		this.inicio = inicio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaAtendimento [inicio=");
		builder.append(inicio);
		builder.append("]");
		return builder.toString();
	}
	
	public boolean vazia() {
		return inicio == null;
	}
	
	public boolean idAtendimentoRepetido(int IdAtendimento) {
		Nodo<Atendimento> aux = inicio;
		
		while (aux != null) {
			if(aux.getObjeto().getIdAtendimento() == IdAtendimento) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
	
	public void inserirFinal (Atendimento atendimento) {
		if (idAtendimentoRepetido(atendimento.getIdAtendimento())) {
			System.out.println("Já há um atendimento com este ID no sistema!");
			return;
		}
		
		Nodo<Atendimento> novoNodo = new Nodo<Atendimento>(atendimento);
		
		if (vazia()) {
			inicio = novoNodo;
			return;
		}
		
		Nodo<Atendimento> aux = inicio;
		
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		aux.setProx(novoNodo);
	}
	
	public void removerPorIdAtendimento(int idAtendimento) {
		if (vazia()) { System.out.println("Lista está vazia, não há o que retornar"); return;}
		
		if(inicio.getObjeto().getIdAtendimento() == idAtendimento) {
			if (inicio.getProx() == null) 
				inicio = null;
			else
				inicio = inicio.getProx();
			return;
		}
		
		Nodo<Atendimento> aux = inicio;
		
		while (aux.getProx() != null) {
			if(aux.getProx().getObjeto().getIdAtendimento() == idAtendimento) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
		
	}
	
	public void mostrarListaToString() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<Atendimento> aux = inicio;
		
		while (aux != null) {
			System.out.print(aux.getObjeto().toString() + ".\n");
			aux = aux.getProx();
			
		}
	}
	
	public void mostrarLista() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<Atendimento> aux = inicio;
		
		while (aux != null) {
			System.out.print("Atendimento id: " + aux.getObjeto().getIdAtendimento() + " | tempo do atendimento: " + aux.getObjeto().getTempoAtendimento() + 
					"| id da sala usada: " + aux.getObjeto().getSalaUsada().getIdSala() + "| Nome do Médico: " + aux.getObjeto().getMedico().getNome() + "| Nome Paciente: " + aux.getObjeto().getPaciente().getNome()
					+ "| Prioridade do Paciente: " + aux.getObjeto().getPaciente().getNivelPrioridade() + " | Finalizado: " + aux.getObjeto().isFinalizado() + ".\n");
			aux = aux.getProx();
			
		}
	}
	
	public void atualizarTempo(PilhaPacienteObservacao pilhaPaciente) {
		Nodo<Atendimento> aux = inicio;
		
		while (aux != null) {
			aux.getObjeto().setTempoAtendimento(aux.getObjeto().getTempoAtendimento()-15);
			if(aux.getObjeto().getTempoAtendimento() == 0) {
				System.out.println("O Atendimento do " + aux.getObjeto().getPaciente().getNome() + " (id:" + aux.getObjeto().getPaciente().getId() + "), foi finalizado");
				aux.getObjeto().medico.setOcupado(false);
				aux.getObjeto().salaUsada.setOcupada(false);
				aux.getObjeto().setFinalizado(true);
				Random sorteio = new Random();
				int vaiPraObservacao = sorteio.nextInt(100) + 1;
				if (vaiPraObservacao <= 30) {
					pilhaPaciente.emObservacao(aux.getObjeto().getPaciente());
				}
			}
			aux = aux.getProx();
		}
		return;
	}
	
	
}
