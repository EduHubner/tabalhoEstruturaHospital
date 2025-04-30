package trabalhoEstruturaDados;

public class Medico {

	private int id;
	private String nome;
	private String especialidade;
	private String escala;
	private boolean ocupado;
	
	public Medico(int id, String nome, String especialidade, String escala) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.escala = escala;
		this.ocupado = false;

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEscala() {
		return escala;
	}
	public void setEscala(String escala) {
		this.escala = escala;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", especialidade=");
		builder.append(especialidade);
		builder.append(", escala=");
		builder.append(escala);
		builder.append(", ocupado=");
		builder.append(ocupado);
		builder.append("]");
		return builder.toString();
	}

	
}
