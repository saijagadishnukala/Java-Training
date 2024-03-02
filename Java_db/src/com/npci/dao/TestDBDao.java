package com.npci.dao;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import com.npci.beans.Profile;

public class TestDBDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// storing data with for loop

		for (int i = 1; i <= 5; i++) {
			Profile p = new Profile("Profile:" + i, LocalDate.now(), 9399393 * i);
			int status = save(p);
			System.out.println("***** " + status + " row created ******");
		}
		System.out.println("****** Retreiving all the records*****");
		List<Profile> list = findAll();
		list.forEach(item -> System.out.println("Id = "+item.getId()+" Name = "+item.getName()+" Phone = "+item.getPhone()+" DOB = "+item.getDob()));
	}

	// FindAll method that must return all the data in a collection
	public static List<Profile> findAll() {
		List<Profile> list = new ArrayList<>();

		try {
			Class.forName(Driver.class.getName()); // we can use this way also: forName(org.postgresql.Driver")
			// Establish a Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/npci_db", "postgres",
					"Welcome@123");

			// Creating Statements
			String sqlQuery = "select * from profile";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet result = statement.executeQuery();// executeUpdate returns int

			while (result.next()) {
				Profile profile = new Profile(result.getString(2), result.getDate(3).toLocalDate(), result.getLong(4));
				profile.setId(result.getInt(1));
				list.add(profile);
			}

			statement.close();
			connection.close();

			// Execute the query
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int save(Profile profile) {
		int count = 0;

		try {
			Class.forName(Driver.class.getName()); // we can use this way also: forName(org.postgresql.Driver")
			// Establish a Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/npci_db", "postgres",
					"Welcome@123");

			// Creating Statements
			String sqlQuery = "insert into profile(name,phone,dob) values(?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			// set profile table values using getter methods of profile object
			statement.setString(1, profile.getName());
			statement.setLong(2, profile.getPhone());
			// import java.sql.Date not java.util.Date
			statement.setDate(3, Date.valueOf(profile.getDob()));
			count = statement.executeUpdate();// executeUpdate returns int
			// Close the resources usually done in the finally block
			statement.close();
			connection.close();

			// Execute the query
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
