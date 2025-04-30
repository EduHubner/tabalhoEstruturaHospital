package trabalhoEstruturaDados;

public class Nodo<E> {

	private E objeto;
	private Nodo<E> prox;
	
	public Nodo(E objeto) {
		this.objeto = objeto;
		this.prox = null;
	}
	public E getObjeto() {
		return objeto;
	}
	public void setObjeto(E objeto) {
		this.objeto = objeto;
	}
	public Nodo<E> getProx() {
		return prox;
	}
	public void setProx(Nodo<E> prox) {
		this.prox = prox;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nodo [objeto=");
		builder.append(objeto);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
	
}
