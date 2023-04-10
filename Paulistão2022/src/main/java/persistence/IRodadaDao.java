package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Rodada;

public class IRodadaDao {
    public void gerarJogos() throws SQLException, ClassNotFoundException;
    public void auxGerarJogos() throws SQLException, ClassNotFoundException;
    public void gerarDatas() throws SQLException, ClassNotFoundException;

    public List<Rodada> listaJogos() throws SQLException, ClassNotFoundException;
}
