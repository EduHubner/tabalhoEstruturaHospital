package trabalhoEstruturaDados;

public class ListaSalaMedica {

	private int numeroDeSala;
	protected Nodo<SalaMedica> inicio;
	
	public ListaSalaMedica (int numeroDeSala) {
		this.numeroDeSala = numeroDeSala;
		this.inicio = null;
	}
	
	public int getNumeroDeSala() {
		return numeroDeSala;
	}
	public void setNumeroDeSala(int numeroDeSala) {
		this.numeroDeSala = numeroDeSala;
	}
	public Nodo<SalaMedica> getInicio() {
		return inicio;
	}
	public void setInicio(Nodo<SalaMedica> inicio) {
		this.inicio = inicio;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaSalaMedica [numeroDeSala=");
		builder.append(numeroDeSala);
		builder.append(", inicio=");
		builder.append(inicio);
		builder.append("]");
		return builder.toString();
	}
	
	public boolean vazia() {
		return inicio == null;
	}
	
	public boolean idSalaRepetido(int IdSala) {
		Nodo<SalaMedica> aux = inicio;
		
		while (aux != null) {
			if(aux.getObjeto().getIdSala() == IdSala) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
	
	public boolean temEspaco() {
		Nodo<SalaMedica> aux = inicio;
		int tam = 0;
		
		while (aux != null) {
			tam++;
			aux = aux.getProx();
		}
		
		return numeroDeSala > tam;
	}
	public void inserirInicio (SalaMedica SalaMedica) {
		if (!temEspaco()) {
			System.out.println("Não há mais espaço no hospital para colocar salas");
			return;
		}
		
		if (idSalaRepetido(SalaMedica.getIdSala())) {
			System.out.println("Já há uma sala médica com este IdSala (" + SalaMedica.getIdSala() + ") no sistema!");
			return;
		}
		
		Nodo<SalaMedica> novoNodo = new Nodo<SalaMedica>(SalaMedica);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	public void inserirFinal (SalaMedica SalaMedica) {
		if (!temEspaco()) {
			System.out.println("Não há mais espaço no hospital para colocar salas");
			return;
		}
		
		if (idSalaRepetido(SalaMedica.getIdSala())) {
			System.out.println("Já há uma sala médica com este IdSala no sistema!");
			return;
		}
		
		Nodo<SalaMedica> novoNodo = new Nodo<SalaMedica>(SalaMedica);
		
		if (vazia()) {
			inicio = novoNodo;
			return;
		}
		
		Nodo<SalaMedica> aux = inicio;
		
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		aux.setProx(novoNodo);
	}
	
	public void removerPorIdSala(int IdSala) {
		if (vazia()) { System.out.println("Lista está vazia, não há o que retornar"); return;}
		
		if(inicio.getObjeto().getIdSala() == IdSala) {
			if (inicio.getProx() == null) 
				inicio = null;
			else
				inicio = inicio.getProx();
			return;
		}
		
		Nodo<SalaMedica> aux = inicio;
		
		while (aux.getProx() != null) {
			if(aux.getProx().getObjeto().getIdSala() == IdSala) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
		
	}
	
	public void mostrarLista() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<SalaMedica> aux = inicio;
		
		while (aux != null) {
			System.out.print(aux.getObjeto().toString() + ";\n");
			aux = aux.getProx();
			
		}
	}
	
	public void mostrarListaPorIdSala() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<SalaMedica> aux = inicio;
		
		while (aux != null) {
			if (aux.getProx() != null) 
				System.out.print(aux.getObjeto().getIdSala() + ", ");
			else
				System.out.print(aux.getObjeto().getIdSala() + ".");
			aux = aux.getProx();
			
		}
	}
	
	public void mostrarRelacaoIdOcupada() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<SalaMedica> aux = inicio;
		
		while (aux != null) {
			System.out.println(aux.getObjeto().getIdSala() + ": " + aux.getObjeto().isOcupada());
			aux = aux.getProx();
		}
		
		return;
	}
	
	public SalaMedica salaLivre() {
		Nodo<SalaMedica> aux = inicio;
		
		while (aux != null) {
			if (!aux.getObjeto().isOcupada()) {
				aux.getObjeto().setOcupada(true);
				return aux.getObjeto();
			}
			aux = aux.getProx();
		}
		
		return null;
	}
	
	public boolean temSalaLivre() {
		Nodo<SalaMedica> aux = inicio;
		
		while (aux != null) {
			if (!aux.getObjeto().isOcupada()) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
	
}
