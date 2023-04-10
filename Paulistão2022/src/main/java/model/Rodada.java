package model;

import java.util.ArrayList;
import java.util.List;

public class Rodada {  
    private String dia;
    private List<Rodada> jogo;

    public Rodada() {
		this.jogo = new ArrayList<Rodada>();
	}

	public List<Rodada> getJogos() {
		return jogo;
	}

	public void addJogo(Rodada jogo) {
		this.jogo.add(jogo);
	}



    public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
    
}
