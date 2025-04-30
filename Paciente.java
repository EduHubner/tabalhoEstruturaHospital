package trabalhoEstruturaDados;
import java.util.Random;
public class Paciente {

	private int id;
	private String nome;
	private String sintomas;
	private int nivelPrioridade;
	private int tempoFila;
	
	public Paciente(int id, String nome, String sintomas) {
		this.id = id;
		this.nome = nome;
		this.sintomas = sintomas;
		this.nivelPrioridade = 0;
		this.tempoFila = 0;
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
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public int getNivelPrioridade() {
		return nivelPrioridade;
	}
	public void setNivelPrioridade(int nivelPrioridade) {
		this.nivelPrioridade = nivelPrioridade;
	}
	public int getTempoFila() {
		return tempoFila;
	}
	public void setTempoFila(int tempoFila) {
		this.tempoFila = tempoFila;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", sintomas=");
		builder.append(sintomas);
		builder.append(", nivelPrioridade=");
		builder.append(nivelPrioridade);
		builder.append(", tempoFila=");
		builder.append(tempoFila);
		builder.append("]");
		return builder.toString();
	}
	
	public void triagem(FilaAtendimento filaPrioridade1, FilaAtendimento filaPrioridade2, FilaAtendimento filaPrioridade3, FilaAtendimento filaPrioridade4, FilaAtendimento filaPrioridade5) {
		Random random = new Random();
		this.nivelPrioridade = random.nextInt(5) + 1;
		
		switch (this.nivelPrioridade) {
		case 1: 
			filaPrioridade1.inserir(this);
			break;
		case 2: 
			filaPrioridade2.inserir(this);
			break;
		case 3: 
			filaPrioridade3.inserir(this);
			break;
		case 4: 
			filaPrioridade4.inserir(this);
			break;
		case 5: 
			filaPrioridade5.inserir(this);
			break;
		}
	}
	
}
