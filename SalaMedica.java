package trabalhoEstruturaDados;

public class SalaMedica {

	private int idSala;
	private boolean ocupada;
	
	public SalaMedica (int idSala) {
		this.idSala = idSala;
		this.ocupada = false;
	}

	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaMedica [idSala=");
		builder.append(idSala);
		builder.append(", ocupada=");
		builder.append(ocupada);
		builder.append("]");
		return builder.toString();
	}
	
}
