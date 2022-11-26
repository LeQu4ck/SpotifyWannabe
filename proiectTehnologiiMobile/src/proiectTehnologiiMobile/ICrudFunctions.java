package proiectTehnologiiMobile;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICrudFunctions {
	void CreateSong() throws SQLException;
	ArrayList<Song> ReadSongs() throws SQLException;
	void DeleteSong();
	//void EditSong();
}
