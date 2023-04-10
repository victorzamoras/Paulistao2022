package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupo;
import model.Times;

public class GrupoDao implements IGrupoDao {
	private GenericDao gDao;

	public GrupoDao(GenericDao gDao) throws ClassNotFoundException, SQLException {
		this.gDao = gDao;
	}

	@Override
	public void gerarGrupos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "CALL sp_divideGrupos";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		cs.close();
		c.close();

	}

	@Override
	public List<Grupo> listarGrupos() throws SQLException, ClassNotFoundException {
		List<Grupo> grupos = new ArrayList<Grupo>();
		grupos.add(findByName("A"));
		grupos.add(findByName("B"));
		grupos.add(findByName("C"));
		grupos.add(findByName("D"));

		return grupos;

	}

	public Grupo findByName(String nome) throws SQLException, ClassNotFoundException {
		Grupo grupo = new Grupo();
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM vwGrupos WHERE grupo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			grupo.setNome(rs.getString("grupo"));
			Times t = new Times();
			t.setNome(rs.getString("participantes"));
			t.setCidade(rs.getString("cidade"));
			t.setEstadio(rs.getString("estadio"));
			t.setCodigoTime(rs.getInt("codigo_time"));
			t.setMaterial(rs.getString("material"));
			grupo.addTime(t);

		}

		rs.close();
		ps.close();
		c.close();

		return grupo;
	}
}


