package proiectTehnologiiMobile;

import java.sql.SQLException;
import java.util.HashSet;

public interface IPlaylistService {
	void CreatePlaylist(String name, HashSet<Song> playlist) throws SQLException;

}
