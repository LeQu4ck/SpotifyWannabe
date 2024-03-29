package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import DBConnection.DbCon;
import Interfaces.IPlaylistService;
import Models.Playlist;
import Models.Song;

public class PlaylistService implements IPlaylistService {

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
			if (playlistKey.next()) {
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

	@Override
	public ArrayList<Playlist> ReadPlaylist() throws SQLException {
		Connection con = db.connect();

		ArrayList<Playlist> playlists = new ArrayList<Playlist>();
		try {

			CallableStatement cstmt = con.prepareCall("{call get_PlayLists()}");
			ResultSet set = cstmt.executeQuery();

			int currentPlaylistId = -1;

			while (set.next()) {
				int playlistId = set.getInt("playlistId");
				String name = set.getString("name");
				int songID = set.getInt("songId");
				String artist = set.getString("artist");
				String title = set.getString("title");
				int duration = set.getInt("duration");
				String genre = set.getString("genre");
				String link = set.getString("link");

				Song song = new Song(songID, artist, title, duration, genre, link);

				if (currentPlaylistId == -1 || currentPlaylistId != playlistId) {
					currentPlaylistId = playlistId;
					HashSet<Song> songs = new HashSet<>();
					songs.add(song);

					Playlist playlist = new Playlist(playlistId, name, songs);
					playlists.add(playlist);
				} else {
					playlists.get(playlists.size() - 1).getPlaylist().add(song);
				}
			}

		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
		}
		return playlists;
	}

	@Override
	public void DeletePlaylist(int playlistID) throws SQLException {
		Connection con = db.connect();
		try {

			String q1 = "DELETE FROM playlist WHERE playlistID = (?)";

			PreparedStatement statement = con.prepareStatement(q1);
			statement.setInt(1, playlistID);
			statement.execute();

		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
		}

	}

}
