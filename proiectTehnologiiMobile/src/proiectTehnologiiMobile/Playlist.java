package proiectTehnologiiMobile;

//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;

public class Playlist {
	
	private HashSet<Song> playlist;

	public Playlist(HashSet<Song> playlist) {
		super();
		this.playlist = playlist;
	}

	public HashSet<Song> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(HashSet<Song> playlist) {
		this.playlist = playlist;
	}
	
	

}
