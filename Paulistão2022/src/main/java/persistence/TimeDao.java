package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Times;

public class TimeDao implements ITimesDao {
	private GenericDao gDao;

	public TimeDao(GenericDao gDao) throws ClassNotFoundException, SQLException {
		this.gDao = gDao;
	}
    @Override
    public List<Times> listaTimes() throws SQLException, ClassNotFoundException {
        List<Times> times = new ArrayList<Times>();
        times.add(listaTimesTime());

        return times;
    }
	public Times listaTimesTime() throws SQLException, ClassNotFoundException {
			Connection c = gDao.getConnection();
			String sql = "SELECT * FROM Times ORDER BY nomeTime";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
            Times time = new Times();

            while (rs.next()) {
                Times t = new Times();
				t.setNome(rs.getString("nomeTime"));
				t.setCidade(rs.getString("cidade"));
				t.setEstadio(rs.getString("estadio"));
				t.setMaterial(rs.getString("material"));
				t.setCodigoTime(rs.getInt("codigoTime"));
                time.addTime(t);
			}

			rs.close();
			ps.close();
			c.close();

			return time;
		}
}



