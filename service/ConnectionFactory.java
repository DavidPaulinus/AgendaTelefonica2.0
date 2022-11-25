package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataS;

	public ConnectionFactory() {
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl("jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC");
		combo.setUser("root");
		combo.setPassword("31031985Rs");

		combo.setMaxPoolSize(5);

		this.dataS = combo;
	}

	public Connection returnConnection() throws SQLException {
		return this.dataS.getConnection();

	}

}
