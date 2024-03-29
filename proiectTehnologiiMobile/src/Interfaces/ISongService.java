package Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.Song;

public interface ISongService {
	void CreateSong(Song s) throws SQLException;

	ArrayList<Song> ReadSongs() throws SQLException;

	void DeleteSong(int songID) throws SQLException;
	// void EditSong();
}
