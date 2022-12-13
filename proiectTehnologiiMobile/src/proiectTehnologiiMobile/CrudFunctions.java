package proiectTehnologiiMobile;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import dbPackage.DbCon;
import dbPackage.DbInteraction;
import dbPackage.IDbInteraction;



public class CrudFunctions implements ICrudFunctions, IDbInteraction {

	IDbInteraction dbInter = new DbInteraction();

	public void CreateSong(Song s) throws SQLException {
		dbInter.InsertSongDB(s);
	}

	public ArrayList<Song> ReadSongs() throws SQLException {
		ArrayList<Song> songList = new ArrayList<Song>();
		songList = dbInter.ReturnSongsDB();
		return songList;
	}

	public void DeleteSong(int songID) throws SQLException {
		dbInter.DeleteSongDB(songID);
	}

	
	@Override
	public void InsertSongDB(Song s) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteSongDB(int songID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Song> ReturnSongsDB() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
