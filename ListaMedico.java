package trabalhoEstruturaDados;

public class ListaMedico {
	
	private int limite;
	protected Nodo<Medico> inicio;
	
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public Nodo<Medico> getInicio() {
		return inicio;
	}
	public void setInicio(Nodo<Medico> inicio) {
		this.inicio = inicio;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaMedico [limite=");
		builder.append(limite);
		builder.append(", inicio=");
		builder.append(inicio);
		builder.append("]");
		return builder.toString();
	}
	
	public boolean vazia() {
		return inicio == null;
	}
	
	public boolean idRepetido(int id) {
		Nodo<Medico> aux = inicio;
		
		while (aux != null) {
			if(aux.getObjeto().getId() == id) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
	
	public void inserirInicio (Medico medico) {
		if (idRepetido(medico.getId())) {
			System.out.println("Já há um médico com este ID no sistema!");
			return;
		}
		
		Nodo<Medico> novoNodo = new Nodo<Medico>(medico);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	public void inserirFinal (Medico medico) {
		if (idRepetido(medico.getId())) {
			System.out.println("Já há um médico com este ID no sistema!");
			return;
		}
		
		Nodo<Medico> novoNodo = new Nodo<Medico>(medico);
		
		if (vazia()) {
			inicio = novoNodo;
			return;
		}
		
		Nodo<Medico> aux = inicio;
		
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		aux.setProx(novoNodo);
	}
	
	public void removerPorId(int id) {
		if (vazia()) { System.out.println("Lista está vazia, não há o que retornar"); return;}
		
		if(inicio.getObjeto().getId() == id) {
			if (inicio.getProx() == null) 
				inicio = null;
			else
				inicio = inicio.getProx();
			return;
		}
		
		Nodo<Medico> aux = inicio;
		
		while (aux.getProx() != null) {
			if(aux.getProx().getObjeto().getId() == id) {
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
		
		Nodo<Medico> aux = inicio;
		
		while (aux != null) {
			System.out.print(aux.getObjeto().toString() + ";\n");
			aux = aux.getProx();
			
		}
	}
	
	public void mostrarListaPorId() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<Medico> aux = inicio;
		
		while (aux != null) {
			if (aux.getProx() != null) 
				System.out.print(aux.getObjeto().getId() + ", ");
			else
				System.out.print(aux.getObjeto().getId() + ".");
			aux = aux.getProx();
			
		}
	}
	
	public void mostrarListaPorNome() {
		if(vazia()) {
			System.out.println("Lista vazia");
			return;
		}
		
		Nodo<Medico> aux = inicio;
		
		while (aux != null) {
			if (aux.getProx() != null) 
				System.out.print(aux.getObjeto().getNome() + ", ");
			else
				System.out.print(aux.getObjeto().getNome() + ".");
			aux = aux.getProx();
		}
	}
	
	public Medico medicoLivre() {
		Nodo<Medico> aux = inicio;
		
		while (aux != null) {
			if (!aux.getObjeto().isOcupado()) {
				aux.getObjeto().setOcupado(true);
				return aux.getObjeto();
			}
			aux = aux.getProx();
		}
		
		return null;
	}
		
	public boolean temMedicoLivre() {
		Nodo<Medico> aux = inicio;
		
		while (aux != null) {
			if (!aux.getObjeto().isOcupado()) {
				return true;
			}
			aux = aux.getProx();
		}
		
		return false;
	}
}
