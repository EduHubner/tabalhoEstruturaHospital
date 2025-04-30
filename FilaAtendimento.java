package trabalhoEstruturaDados;

public class FilaAtendimento {

	private int tamanho;
	private int prioridade;
	protected Nodo<Paciente> inicio;
	protected Nodo<Paciente> fim;
	
	public FilaAtendimento(int prioridade) {
		this.tamanho = 0;
		this.prioridade = prioridade;
		this.inicio = null;
		this.fim = null;		
	}
	
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public Nodo<Paciente> getInicio() {
		return inicio;
	}
	public void setInicio(Nodo<Paciente> inicio) {
		this.inicio = inicio;
	}
	public Nodo<Paciente> getFim() {
		return fim;
	}
	public void setFim(Nodo<Paciente> fim) {
		this.fim = fim;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilaAtendimento [tamanho=");
		builder.append(tamanho);
		builder.append(", prioridade=");
		builder.append(prioridade);
		builder.append(", inicio=");
		builder.append(inicio);
		builder.append(", fim=");
		builder.append(fim);
		builder.append("]");
		return builder.toString();
	}
	
	public boolean vazia() {
		return inicio == null;
	}
	
	public boolean idRepetido(int id) {
		Nodo<Paciente> aux = inicio;
		
		while (aux != null) {
			if(aux.getObjeto().getId() == id) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
	
	public boolean estaNaFilaErrada(int prioridade) {
		Nodo<Paciente> aux = inicio;
		
		while (aux != null) {
			if(aux.getObjeto().getNivelPrioridade() != prioridade) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
	
	public void inserir(Paciente paciente) {
		if (estaNaFilaErrada(paciente.getNivelPrioridade())) {
			System.out.println("Este Paciente não pode ser inserido nesta fila, pois seu nível de pioridade não condiz com o da fila");
			return;
		}
		
		if (idRepetido(paciente.getId())) {
			System.out.println("Já há um paciente com este id (" + paciente.getId() + ") no sistema!");
			return;
		}
		
		Nodo<Paciente> novoNodo = new Nodo<Paciente>(paciente);
		
		if (vazia()) {
			inicio = novoNodo;
			fim = novoNodo;
		} else {
			fim.setProx(novoNodo);
			fim = novoNodo;
		}
		tamanho++;
		
	}
	
	public void remover() {
		if (!vazia()) {
			System.out.println("O paciente " + inicio.getObjeto().getNome() + " com o id=" + inicio.getObjeto().getId() + " foi movido da fila de atendimento, pois será atendido\n");
			inicio = inicio.getProx();
			tamanho--;
			if (vazia()) fim = null;
		} else 
			System.out.println("Fila vazia!");
	}
	
	public int tamanhoFila() {
		return this.tamanho;
	}
	
	public void mostrarFila() {
		System.out.println("\nEstá é a fila de paciente de prioridade " + this.prioridade + ": ");
		
		if(vazia()) {
			System.out.println("Fila vazia");
			return;
		}
		
		Nodo<Paciente> aux = inicio;
		int i=1;
		while (aux != null) {
			System.out.print(i + "º da Fila: " + aux.getObjeto().getNome() + ", id: " + aux.getObjeto().getId() + ", tempo na fila: " + aux.getObjeto().getTempoFila() 
					+ ", prioridade: " + aux.getObjeto().getNivelPrioridade() + "\n");
			aux = aux.getProx();
			i++;
			
		}
	}
	
	public Paciente irParaAtendimento() {
		Nodo<Paciente> aux = inicio;
		remover();
		return aux.getObjeto();
		

	}
	
	public void passarTempoFila() {
		Nodo<Paciente> aux = inicio;
		
		while (aux != null) {
			aux.getObjeto().setTempoFila(aux.getObjeto().getTempoFila() + 15);
			
			aux = aux.getProx();
		}
	}
	
}
