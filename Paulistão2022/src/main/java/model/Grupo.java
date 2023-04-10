package model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	private List<Times> times;
	private String nome;

	public Grupo() {
		this.times = new ArrayList<Times>();
	}

	public List<Times> getTimes() {
		return times;
	}

	public void addTime(Times time) {
		this.times.add(time);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
