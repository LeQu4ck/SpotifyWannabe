package Models;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Playlist {

	private HashSet<Song> songlist;
	private String playListName;
	private int id;

	public Playlist(String playListName, HashSet<Song> songlist) {
		super();
		this.songlist = songlist;
		this.playListName = playListName;
	}

	public Playlist(int id, String playListName, HashSet<Song> songlist) {
		this.id = id;
		this.playListName = playListName;
		this.songlist = songlist;
	}

	public Playlist() {
		songlist = new HashSet<Song>();
	}

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public HashSet<Song> getPlaylist() {
		return songlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPlaylist(HashSet<Song> playlist) {
		this.songlist = playlist;
	}

	public void play() throws IOException, URISyntaxException, InterruptedException {

		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			for (Song sng : this.songlist) {
				String uri = sng.getLink();
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI(uri));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(sng.getDuration() * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void getRandomPlaylist(ArrayList<Song> list, int totalItems) {
		Random rand = new Random();
		while (songlist.size() < totalItems) {
			int randomIndex = rand.nextInt(list.size());
			songlist.add(list.get(randomIndex));
		}

	}

	@Override
	public String toString() {
		return "Playlist " + id + ": " + playListName + "\n" + "Songs: " + songlist;
	}

}
