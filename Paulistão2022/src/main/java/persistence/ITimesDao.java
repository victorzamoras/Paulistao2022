package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Times;

public interface ITimesDao {
	public List<Times> listaTimes() throws SQLException, ClassNotFoundException;


}
