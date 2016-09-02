package com.politician;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	public static final ArrayList<CandidatesForum> ourRulers = new ArrayList<>();

	public Scanner sc = new Scanner(System.in);
	
	public static void connToDB() {
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			System.out.println("Connecting to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database \n");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
	}   // end of method connToDB
	
	public static void readFromDB() {
		connToDB();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM representatives.forum;");
			
			while (RES_SET.next()) {
				CandidatesForum saidPolitician = new CandidatesForum();
				
				saidPolitician.setId_Number(RES_SET.getInt("id_Number"));
				saidPolitician.setFirst_name(RES_SET.getString("First_Name"));
				saidPolitician.setLast_name(RES_SET.getString("Last_Name"));
				saidPolitician.setState(RES_SET.getString("State"));
				saidPolitician.setParty_affiliation(RES_SET.getString("Political_Party"));
				saidPolitician.setOccupation(RES_SET.getString("Occupation"));
				saidPolitician.setReligion(RES_SET.getString("Religion"));
				saidPolitician.setAlignment(RES_SET.getString("Alignment"));

				ourRulers.add(saidPolitician);
				
			}  // end of while loop
			
			for (CandidatesForum republic : ourRulers) {
				System.out.println(republic);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}   // end of try-catch
		
	}  // end of method readFromDB
	
	
	public static void writeToDB(CandidatesForum politician) {
		
		CandidatesForum addPolitician = new CandidatesForum();
		// addPolitician = aboutTheCandidate();
		addPolitician = politician;
		
		connToDB();
		
		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);
			PREP_STMT.setString(1, addPolitician.getFirst_name());
			PREP_STMT.setString(2, addPolitician.getLast_name());
			PREP_STMT.setString(3, addPolitician.getState());
			PREP_STMT.setString(4, addPolitician.getParty_affiliation());
			PREP_STMT.setString(5, addPolitician.getOccupation());
			PREP_STMT.setString(6, addPolitician.getReligion());
			PREP_STMT.setString(7, addPolitician.getAlignment());
			
			System.out.println(PREP_STMT);

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}  // end of method writeToDB
	
		
	
	private static String insertToDB = "INSERT INTO `representatives`.`forum`" + " (species, type_of_cage, food, name, weight)" + " VALUES " 
			+ "(?,?,?,?,?,?,?)";
			
			public static CandidatesForum aboutTheCandidate() {
				Scanner sc = new Scanner(System.in);

				CandidatesForum addPolitician = new CandidatesForum();
				
				System.out.println("What is the candidates first name?");
				addPolitician.setLast_name(sc.nextLine());
				
				System.out.println("What is the candidates last name?");
				addPolitician.setLast_name(sc.nextLine());
				
				System.out.println("From what claimed home state?");
				addPolitician.setState(sc.nextLine());
				System.out.println("From what political party is the candidate affiliated?");
				addPolitician.setParty_affiliation(sc.nextLine());
				
				System.out.println("What is the candidate's primary occupation outside of political office?");
				addPolitician.setOccupation(sc.nextLine());
				
				System.out.println("What is the religion of the candidate?");
				addPolitician.setReligion(sc.nextLine());
				
				System.out.println("What is the alignment of the candidate?");
				addPolitician.setAlignment(sc.nextLine());
	

				
				return addPolitician;
				} // end of aboutTheAnimal method

			public static void deleteFromDB() {
				Scanner sc = new Scanner(System.in);
				CandidatesForum politicianToDelete = new CandidatesForum();
				connToDB();	
				readFromDB();
				
				System.out.println("Which candidate would you like to delete? \n"
						+ "Please select and enter the correspondnig ID number of the candidate to DELETE");
				String checkInput = sc.nextLine();
				String regex = "^[a-zA-Z]+$";
				do {
					if (checkInput.matches(regex)) {
						System.out.println("Error! Invalid integer value.");
						System.out
								.println("Please select and enter the corresponding ID number of the candidate to DELETE");
						politicianToDelete.setId_Number(Integer.parseInt(sc.nextLine()));
					} else
						politicianToDelete.setId_Number(Integer.parseInt(checkInput));
				} while (!(sc.hasNextInt()));
				
				try {
					PREP_STMT = CONN.prepareStatement(removeFromDB);
							PREP_STMT.setInt(1, politicianToDelete.getId_Number());
							
							PREP_STMT.executeUpdate();


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
							
			}  // end of method deletFromDB

			private static String removeFromDB = "DELETE FROM `representatives`.`forum`" 
			+ "WHERE `animals_at_the_zoo`.`animal_id`="  + "(?)";

			
			public static void updateDB() {
				Scanner sc = new Scanner(System.in);
				CandidatesForum updatePolitician = new CandidatesForum();
				//updateAnimal = aboutTheAnimal();
				connToDB();
				String userMenuInput = null;
				String strUpdate = null;
				boolean menuChoiceNotCorrect = false;
				
				//species, type_of_cage, food, name, weight
				
				System.out.println("Please select and enter the correspondnig animal ID of the animal to UPDATE");
				String checkInput = sc.nextLine();
				String regex = "^[a-zA-Z]+$";
				do {
					if (checkInput.matches(regex)) {
						System.out.println("Error! Invalid integer value.");
						System.out
								.println("Please select and enter the correspondnig animal ID of the animal to UPDATE");
						updatePolitician.setId_Number(Integer.parseInt(sc.nextLine()));
					} else
						updatePolitician.setId_Number(Integer.parseInt(checkInput));
				} while (!(sc.hasNextInt()));
				
				do {
					System.out.println("Press 1 to update the First Name \n" + "Press 2 to update the Last Name \n"
							+ "Press 3 to update the State \n" + "Press 4 to update the Political Party of the candidate \n"
							+ "Press 5 to update the occupation of the candidate"
							+ "Press 6 to update the religion of the candidate"
							+ "Press 7 to update the alignment of the candidate");
					userMenuInput = sc.nextLine();
					switch (userMenuInput) {
					case "1":
						System.out.println("For First Name, please enter the new information");
						strUpdate = sc.nextLine();
						try {
							PREP_STMT = CONN.prepareStatement(
									updatingDB + "`First_Name` = ?" + "WHERE `forum`.`id_Number`= ?");
							PREP_STMT.setString(1, strUpdate);
							PREP_STMT.setInt(2, updatePolitician.getId_Number());
							PREP_STMT.executeUpdate();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "2":
						System.out.println("For Last Name, please enter the new information");
						strUpdate = sc.nextLine();
						try {
							PREP_STMT = CONN.prepareStatement(
									updatingDB + "`Last_Name` = ?" + "WHERE `forum`.`id_Number`= ?");
							PREP_STMT.setString(1, strUpdate);
							PREP_STMT.setInt(2, updatePolitician.getId_Number());

							PREP_STMT.executeUpdate();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "3":
						System.out.println("For State, please enter the new information");
						strUpdate = sc.nextLine();
						try {
							PREP_STMT = CONN.prepareStatement(
									updatingDB + "`State` = ?" + "WHERE `forum`.`id_Number`= ?");
							PREP_STMT.setString(1, strUpdate);
							PREP_STMT.setInt(2, updatePolitician.getId_Number());

							PREP_STMT.executeUpdate();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "4":
						System.out.println("For Political Party, please enter the new information");
						strUpdate = sc.nextLine();
						try {
							PREP_STMT = CONN.prepareStatement(
									updatingDB + "`Political_Party` = ?" + "WHERE `forum`.`id_Number`= ?");
							PREP_STMT.setString(1, strUpdate);
							PREP_STMT.setInt(2, updatePolitician.getId_Number());

							PREP_STMT.executeUpdate();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case "5":
						System.out.println("For Occupation, please enter the new information");
						strUpdate = sc.nextLine();
						try {
							PREP_STMT = CONN.prepareStatement(
									updatingDB + "`Occupation` = ?" + "WHERE `forum`.`id_Number`= ?");
							PREP_STMT.setString(1, strUpdate);
							PREP_STMT.setInt(2, updatePolitician.getId_Number());
							PREP_STMT.executeUpdate();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					default:
						System.out.println("You have entered an invalid option");
						menuChoiceNotCorrect = true;
						break;
					}
				} while (menuChoiceNotCorrect);

				
			}  // end of method updateDB
			
			private static String updatingDB = "UPDATE `representatives`.`forum` SET ";
					
			
			
}  // end of class