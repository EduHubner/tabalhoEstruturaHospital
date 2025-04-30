package trabalhoEstruturaDados;

public class PilhaPacienteObservacao {

	private int limite;
	private int tamanho;
	protected Nodo<Paciente> topo;
	
	public PilhaPacienteObservacao() {
		this.limite = 20;
		this.tamanho = 0;
		this.topo = null;
	}
	
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public Nodo<Paciente> getInicio() {
		return topo;
	}
	public void setInicio(Nodo<Paciente> topo) {
		this.topo = topo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PilhaPacienteObservacao [limite=");
		builder.append(limite);
		builder.append(", tamanho=");
		builder.append(tamanho);
		builder.append(", inicio=");
		builder.append(topo);
		builder.append("]");
		return builder.toString();
	}
	
	public boolean vazia() {
		return tamanho == 0;
	}
	
	public boolean temEspaco() {
		return limite > tamanho;
	}
	
	public void emObservacao(Paciente paciente) {
		if (temEspaco()) {
			Nodo<Paciente> novoPaciente = new Nodo<Paciente>(paciente);
			novoPaciente.setProx(topo);
			topo = novoPaciente;
			tamanho++;
		} else {
			System.out.println("Pilha cheia!");
		}
	}
	
	//Remoção
	public void liberacaoLeitos() {
		if(!vazia()) {
			System.out.println(topo.getObjeto().getNome() + "(id:" + topo.getObjeto().getId() + ") foi removido da pilha");
			topo = topo.getProx();
			tamanho--;
		} else {
			System.out.println("Pilha está vazia!");
		}
	}
	
	public void mostrarPilha() {
		if(vazia()) {
			System.out.println("Pilha de Observação vazia");
			return;
		}
		
		System.out.println("Pilha de Observação:");
		Nodo<Paciente> aux = topo;
		
		while (aux != null) {
			if (aux.getProx() != null) 
				System.out.print(aux.getObjeto().getNome() + ", ");
			else
				System.out.print(aux.getObjeto().getNome() + ".\n");
			aux = aux.getProx();
		}
	}
}
