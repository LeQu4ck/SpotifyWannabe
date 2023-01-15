package Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import Models.Playlist;
import Models.Song;

public interface IPlaylistService {
	void CreatePlaylist(String name, HashSet<Song> playlist) throws SQLException;

	ArrayList<Playlist> ReadPlaylist() throws SQLException;

	void DeletePlaylist(int playlistID) throws SQLException;

}
