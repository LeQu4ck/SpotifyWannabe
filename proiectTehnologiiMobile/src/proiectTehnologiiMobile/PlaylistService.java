package proiectTehnologiiMobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class PlaylistService implements IPlaylistService{
	
	private DbCon db = new DbCon();
	@Override
	public void CreatePlaylist(String name, HashSet<Song> songlist) throws SQLException {

		Connection con = db.connect();
		try {

			 String q1 = "INSERT INTO playlist (name) VALUES (?)";
			 String q2 = "INSERT INTO songplaylist (songID, playlistID) VALUES (?,?)";
			 
			 PreparedStatement statement = con.prepareStatement(q1, Statement.RETURN_GENERATED_KEYS);
			 
			 statement.setString(1, name);
			 statement.executeUpdate();
	            
	         int generatedKey = 0;
	         ResultSet playlistKey = statement.getGeneratedKeys();
	         if(playlistKey.next()) {
	            generatedKey = playlistKey.getInt(1);
	         }
	            
	         statement = con.prepareStatement(q2);
	           for (Song song : songlist) {
	            statement.setInt(1, song.getSongID());
	            statement.setInt(2, generatedKey);	
	            statement.executeUpdate();
	           }

		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
		}
	}
	
}
