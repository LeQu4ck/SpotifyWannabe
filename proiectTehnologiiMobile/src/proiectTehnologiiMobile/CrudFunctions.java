package proiectTehnologiiMobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.util.Scanner;



public class CrudFunctions implements ICrudFunctions {
	
	private dbCon db = new dbCon();

	public void CreateSong() throws SQLException{
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduceti artistul:" + "\n");
		String artist = sc.nextLine();

		System.out.println("Introduceti titlul:" + "\n");
		String title = sc.nextLine();

		System.out.println("Introduceti durata:" + "\n");
		String durata = sc.next();

		System.out.println("Introduceti genul:" + "\n");
		String genre = sc.next();

		System.out.println("Introduceti link-ul:" + "\n");
		String link = sc.next();
		
		sc.close();
		
		Song song = new Song(artist, title, Double.valueOf(durata), genre, link);

		if(song.validate()) {
			Connection con = db.connect();
		    try{
				/*
				 * String artist = song.getArtist(); String title = song.getTitle(); Double
				 * durata = song.getDuration(); String genre = song.getSongType(); String link =
				 * song.getLink();
				 */
				
		    	String query = "INSERT INTO songs (artist, title, duration, genre, link) VALUES(?,?,?,?,?)";
		    	
		        PreparedStatement statement = con.prepareStatement(query); 
		        
		        statement.setString(1, artist);
		        statement.setString(2, title);
		        statement.setDouble(3, Double.valueOf(durata));
		        statement.setString(4, genre);
		        statement.setString(5, link);

		        statement.execute();
		        //return result;
		      }catch(SQLException e){
		        System.out.println("ERROR while executing select query!");
		        System.out.println(e.toString());
		      }
		}

	}
	public ArrayList<Song> ReadSongs() throws SQLException {
		Connection con = db.connect();
		ArrayList<Song> songList = new ArrayList<Song>();
	    try{

	    	String query = "SELECT * FROM songs";
	    	
	        PreparedStatement statement = con.prepareStatement(query); 
	        
	        ResultSet set = statement.executeQuery();
	        
	        while(set.next()) {
	        	int songID = set.getInt(1);
	        	String artist = set.getString(2);
	    		String title = set.getString(3);
	    		Double durata = set.getDouble(4);
	    		String genre = set.getString(5);
	    		String link = set.getString(6);
	    		
	    		Song song = new Song(songID, artist, title, durata, genre, link);
	    		songList.add(song);
	        }
	        //return result;
	      }catch(SQLException e){
	        System.out.println("ERROR while executing select query!");
	        System.out.println(e.toString());
	      }
		return songList;
	}
	public void DeleteSong() {
		
	}
}
