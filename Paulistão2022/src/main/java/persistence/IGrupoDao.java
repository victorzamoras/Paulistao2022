package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Grupo;

public interface IGrupoDao {
	public void gerarGrupos() throws SQLException, ClassNotFoundException;

	public List<Grupo> listarGrupos() throws SQLException, ClassNotFoundException;
}
