package proiectTehnologiiMobile;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Random;

public class Playlist {
	
	private HashSet<Song> playlist;
	private String playListName;
	private int id;

	public Playlist(String playListName, HashSet<Song> playlist) {
		super();
		this.playlist = playlist;
		this.playListName = playListName;
	}

	public Playlist(int id, String playListName, HashSet<Song> playList) {
		this.id = id;
		this.playListName = playListName;
		this.playlist = playList;
	}
	public Playlist() {
		playlist = new HashSet<Song>();
	}

	public String getPlayListName() {
		return playListName;
	}
	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}
	
	public HashSet<Song> getPlaylist() {
		return playlist;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setPlaylist(HashSet<Song> playlist) {
		this.playlist = playlist;
	}
	
	public void play() throws IOException, URISyntaxException, InterruptedException {
		for(Song sng: this.playlist) {
			String uri = sng.getLink();
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			    Desktop.getDesktop().browse(new URI(uri));
			}
			Thread.sleep(5000);
		}
	}
	
	public void getRandomPlaylist(ArrayList<Song> list, int totalItems) {
        Random rand = new Random();
        while(playlist.size() < totalItems) {
            int randomIndex = rand.nextInt(list.size());
            playlist.add(list.get(randomIndex));
        }
		
	}

}
