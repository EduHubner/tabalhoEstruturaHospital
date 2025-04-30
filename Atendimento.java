package trabalhoEstruturaDados;

import java.util.Random;

public class Atendimento {

	private int idAtendimento;
	private int tempoAtendimento;
	private boolean finalizado;
	protected SalaMedica salaUsada;
	protected Medico medico;
	protected Paciente paciente;
	
	public Atendimento (int id, SalaMedica salaMedica, Medico medico, Paciente paciente) {
		this.idAtendimento = id;
		this.medico = medico;
		this.paciente = paciente;
		this.salaUsada = salaMedica;
		this.finalizado = false;
		Random random = new Random();
		this.tempoAtendimento = (random.nextInt(4) + 1) * 15;
		
	}
	
	public int getIdAtendimento() {
		return idAtendimento;
	}
	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	public int getTempoAtendimento() {
		return tempoAtendimento;
	}
	public void setTempoAtendimento(int tempoAtendimento) {
		this.tempoAtendimento = tempoAtendimento;
	}
	public SalaMedica getSalaUsada() {
		return salaUsada;
	}
	public void setSalaUsada(SalaMedica salaUsada) {
		this.salaUsada = salaUsada;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atendimento [idAtendimento=");
		builder.append(idAtendimento);
		builder.append(", tempoAtendimento=");
		builder.append(tempoAtendimento);
		builder.append(", finalizado=");
		builder.append(finalizado);
		builder.append(", salaUsada=");
		builder.append(salaUsada);
		builder.append(", medico=");
		builder.append(medico);
		builder.append(", paciente=");
		builder.append(paciente);
		builder.append("]");
		return builder.toString();
	}

		
	
}
