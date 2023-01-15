package proiectTehnologiiMobile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public interface IPlaylistService {
	void CreatePlaylist(String name, HashSet<Song> playlist) throws SQLException;

	ArrayList<Playlist> ReadPlaylist() throws SQLException;

	void DeletePlaylist(int playlistID) throws SQLException;

}
