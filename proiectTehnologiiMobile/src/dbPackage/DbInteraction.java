package dbPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import proiectTehnologiiMobile.Song;

public class DbInteraction implements IDbInteraction{
	private DbCon db = new DbCon();

	@Override
	public void InsertSongDB(Song s) throws SQLException {
		
		  Connection con = db.connect(); 
		  try{
		  
		  String artist = s.getArtist(); 
		  String title = s.getTitle(); 
		  Double durata = s.getDuration(); 
		  String genre = s.getSongType(); 
		  String link = s.getLink();
		  
		  String query = "INSERT INTO songs (artist, title, duration, genre, link) VALUES(?,?,?,?,?)";
		  
		  PreparedStatement statement = con.prepareStatement(query);
		  
		  statement.setString(1, artist); 
		  statement.setString(2, title);
		  statement.setDouble(3, Double.valueOf(durata)); 
		  statement.setString(4, genre); 
		  statement.setString(5, link);
		  
		  statement.execute(); 

		  }catch(SQLException e){
		  System.out.println("ERROR while executing select query!");
		  System.out.println(e.toString()); }
		
	}

	@Override
	public void DeleteSongDB(int songID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = db.connect();
		try {

			String query = "DELETE FROM songs WHERE songID = ?";

			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, songID);
			statement.execute();
		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
		}
	}

	@Override
	public ArrayList<Song> ReturnSongsDB() throws SQLException {
		
		Connection con = db.connect();
		ArrayList<Song> songList = new ArrayList<Song>();
		try {

			String query = "SELECT * FROM songs";

			PreparedStatement statement = con.prepareStatement(query);

			ResultSet set = statement.executeQuery();

			while (set.next()) {

				int songID = set.getInt(1);
				String artist = set.getString(2);
				String title = set.getString(3);
				Double durata = set.getDouble(4);
				String genre = set.getString(5);
				String link = set.getString(6);

				Song song = new Song(songID, artist, title, durata, genre, link);
				songList.add(song);
			}
			// return result;
		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
		}
		return songList;
		
	}
	
	
}
