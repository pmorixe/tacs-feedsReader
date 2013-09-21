package ar.edu.utn.frba.tacs.grupo1.connection;

import junit.framework.TestCase;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.connection.DbConnection;

import com.mysql.jdbc.Connection;

public class DbConnectionTest extends TestCase {

	@Test
	public void testGetConnection() throws Exception {
		Connection connection = new DbConnection().getConnection();
		assertNotNull(connection);
	}

	@Test
	public void testDesconectarDB() throws Exception {
		DbConnection dbConnection = new DbConnection();
		dbConnection.disconnect();
		Connection connection = dbConnection.getConnection();
		assertNull(connection);
	}

}
