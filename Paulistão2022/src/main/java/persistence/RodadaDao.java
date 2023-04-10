package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Rodada;

public class RodadaDao implements IRodadaDao{
        private GenericDao rDao;
    
        public RodadaDao(GenericDao rDao) throws ClassNotFoundException, SQLException {
            this.rDao = rDao;
        }

    @Override
	public void gerarJogos() throws SQLException, ClassNotFoundException {
		Connection c = rDao.getConnection();
		String sql = "CALL sp_jogos";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		cs.close();
		c.close();
	}
    @Override
	public void auxGerarJogos() throws SQLException, ClassNotFoundException {
		Connection c = rDao.getConnection();
		String sql = "CALL sp_auxGerarJogos";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		cs.close();
		c.close();

	}

    @Override
	public void gerarDatas() throws SQLException, ClassNotFoundException {
		Connection c = rDao.getConnection();
		String sql = "CALL sp_divideGrupos";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		cs.close();
		c.close();

	}

    public Rodada listarJogos() throws SQLException, ClassNotFoundException {
        Connection c = rDao.getConnection();
        String sql = "SELECT * FROM vwJogos WHERE dia = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Rodada jogos = new Rodada();

        while (rs.next()) {
            Rodada r = new Rodada();
            r.setNome(rs.getString("nomeTime"));
            r.setCidade(rs.getString("cidade"));
            r.setEstadio(rs.getString("estadio"));
            r.setMaterial(rs.getString("material"));
            r.setCodigoTime(rs.getInt("codigoTime"));
            jogos.addJogo(r);
        }

        rs.close();
        ps.close();
        c.close();

        return jogos;
    }
}
