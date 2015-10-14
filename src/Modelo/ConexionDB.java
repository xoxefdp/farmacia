/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author josediaz
 */
public class ConexionDB implements EntornoDB{
	Connection connect;
	Statement query;

	// Constructor DBAccessor comienza aquí
	ConexionDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NamingException {

		// Para PostgreSQL sería
			// Class.forName("org.postgresql.Driver");
			// conn = DriverManager.getConnection("jdbc:postgresql:sample","db2admin", "123");
		// Para MySQL sería
		
			// Class.forName("com.mysql.jdbc.Driver");
			// conn = DriverManager.getConnection("jdbc:mysql://localhost/Sample", "db2admin", "123");
			// conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbctest?" + "user=root&password=");
			// conn = DriverManager.getConnection("jdbc:mysql://localhost/farmacia?" + "user=root&password=mysqlroot");
		
		// Para ibm??? sería
			//Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			// conn = DriverManager.getConnection("jdbc:db2:Sample","db2admin", "123");

		Class.forName(DRIVER).newInstance();
		connect = DriverManager.getConnection(URL_CONEXION,USER,PASS);
		query = connect.createStatement();
	}
	
	void insertData() throws SQLException {

		query.executeUpdate("INSERT INTO componente "+"(idComponente,nombreDelComponente)"                                      +" VALUES ('1000','Acetaminofen')");
		query.executeUpdate("INSERT INTO componente "+"(idComponente,nombreDelComponente)"                                      +" VALUES ('1001','Ibuprofeno')");
		query.executeUpdate("INSERT INTO componente "+"(idComponente,nombreDelComponente)"                                      +" VALUES ('1002','Paracetamol')");
		query.executeUpdate("INSERT INTO componente "+"(idComponente,nombreDelComponente)"                                      +" VALUES ('1003','Amoxicilina')");
		query.executeUpdate("INSERT INTO componente "+"(idComponente,nombreDelComponente)"                                      +" VALUES ('1004','Penincilina')");

		query.executeUpdate("INSERT INTO laboratorio "+"(idLaboratorio,nombreDelLaboratorio)"                                     +" VALUES ('2000','Novartis')");
		query.executeUpdate("INSERT INTO laboratorio "+"(idLaboratorio,nombreDelLaboratorio)"                                     +" VALUES ('2001','Kempfart')");
		query.executeUpdate("INSERT INTO laboratorio "+"(idLaboratorio,nombreDelLaboratorio)"                                     +" VALUES ('2002','Genven')");
		query.executeUpdate("INSERT INTO laboratorio "+"(idLaboratorio,nombreDelLaboratorio)"                                     +" VALUES ('2003','Pfizer')");
		query.executeUpdate("INSERT INTO laboratorio "+"(idLaboratorio,nombreDelLaboratorio)"                                     +" VALUES ('2004','Elter')");

		query.executeUpdate("INSERT INTO unidaddemedida "+"(idUnidadDeMedida,nombreDeLaUnidadDeMedida)"				  +" VALUES ('3000','ml')");
		query.executeUpdate("INSERT INTO unidaddemedida "+"(idUnidadDeMedida,nombreDeLaUnidadDeMedida)"				  +" VALUES ('3001','UI')");
		query.executeUpdate("INSERT INTO unidaddemedida "+"(idUnidadDeMedida,nombreDeLaUnidadDeMedida)"				  +" VALUES ('3002','mg')");
		query.executeUpdate("INSERT INTO unidaddemedida "+"(idUnidadDeMedida,nombreDeLaUnidadDeMedida)"				  +" VALUES ('3003','g')");

		query.executeUpdate("INSERT INTO medicamento "+"(idMedicamento,idLaboratorio,nombreComercial)"			  +" VALUES ('4000','2000','Agurin')");

		query.executeUpdate("INSERT INTO producto "+"(idMedicamento,idComponente,idUnidadDeMedida,cantidadDelComponente)"+" VALUES ('4000','1002','3003','1')");

		query.close();
	}

	void retrieveData() throws SQLException {

		ResultSet rs;
		query = connect.createStatement();

		rs = query.executeQuery("SELECT * FROM componente");
		System.out.println("\n");
		System.out.println("componente table ...\n");
		while (rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2));
		}

		rs = query.executeQuery("SELECT * FROM laboratorio");
		System.out.println("\n");
		System.out.println("laboratorio table ...\n");
		while (rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2));
		}

		rs = query.executeQuery("SELECT * FROM unidaddemedida");
		System.out.println("\n");
		System.out.println("unidaddemedida table ...\n");
		while (rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2));
		}


		rs = query.executeQuery("SELECT * FROM medicamento");
		System.out.println("\n");
		System.out.println("medicamento table ...\n");
		while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}

		rs = query.executeQuery("SELECT * FROM producto");
		System.out.println("\n");
		System.out.println("producto table...\n");
		while (rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}

		System.out.println("\n");
		rs.close();
	}

}
