package proiectTehnologiiMobile;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICrudFunctions {
	void CreateSong(Song s) throws SQLException;
	ArrayList<Song> ReadSongs() throws SQLException;
	void DeleteSong(int songID) throws SQLException;
	//void EditSong();
}
