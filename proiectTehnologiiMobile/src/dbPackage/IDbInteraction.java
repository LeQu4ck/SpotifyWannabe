package dbPackage;

import java.sql.SQLException;
import java.util.ArrayList;

import proiectTehnologiiMobile.Song;

public interface IDbInteraction {
	void InsertSongDB(Song s) throws SQLException;
	ArrayList<Song> ReturnSongsDB() throws SQLException;
	void DeleteSongDB(int songID) throws SQLException;
}
