package model;

import java.util.ArrayList;
import java.util.List;

public class Times {
	private int codigoTime;
	private String nome;
	private String cidade;
	private String estadio;
	private String material;
	private List<Times> times;
	
	public Times() {
		this.times = new ArrayList<Times>();
	}

	public int getCodigoTime() {
		return codigoTime;
	}

	public void setCodigoTime(int codigoTime) {
		this.codigoTime = codigoTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Time [CodigoTime=" + codigoTime + ", NomeTime=" + nome + ", Cidade=" + cidade + ", Estadio=" + estadio
				+ ", Material=" + material + "]";
	}
	public void addTime(Times time) {
		this.times.add(time);
	}
	
	public List<Times> getTimes() {
		return times;
	}



}
