package proiectTehnologiiMobile;


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class app implements ISongService {

	public static void main(String[] args) throws SQLException, IOException, URISyntaxException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner randomPlaylist = new Scanner(System.in);
		
		ISongService songService = new SongService();
		IPlaylistService playlistService =  new PlaylistService();
					
		Playlist generatedSongList = new Playlist();
		ArrayList<Song> songList = new ArrayList<Song>();
		ArrayList<Playlist> playList = new ArrayList<Playlist>();
		
		

		playList = playlistService.ReadPlaylist();
		songList = songService.ReadSongs();
		
		for(Playlist p: playList) {
			System.out.println(p);
		}

		int function = -2;

		do {
			String menu = "Tastati 1 pt. afisare lista cantece, " + "2 pt. stergere, " + "3 pt. introducere, "
					+ "4 pt. generare playlist random, " + "5 pt. redare Playlist " + " 0 pt. iesire din aplicatie.";
			System.out.print(menu);
			// System.out.println("function"+function);
			function = sc1.nextInt();
			sc1.nextLine();

			switch (function) {

			case 1:
				songList = songService.ReadSongs();
				for(Song s: songList) {
					System.out.println(s);
				}
				break;

			case 2:
				System.out.println("Alege numarul cantecului pe care vreti sa-l stergeti: ");
				int songID = sc1.nextInt();
				songService.DeleteSong(songID);
				songList = songService.ReadSongs();
				break;
			case 3:
				System.out.print("Introduceti artistul: ");
				String artist = sc2.nextLine();

				System.out.print("Introduceti titlul:");
				String title = sc2.nextLine();

				System.out.print("Introduceti durata:");
				String durata = sc2.next();

				System.out.print("Introduceti genul:");
				String genre = sc2.next();

				System.out.print("Introduceti link-ul:");
				String link = sc2.next();
				
				sc2.nextLine();
				Song s = new Song(artist, title, Integer.parseInt(durata), genre, link);
				if (s.validate()) {
					songService.CreateSong(s);
				} else {
					System.out.print("Verificati valorile introduse!");
				}
				break;
			case 4:
				System.out.print("Specificati lungimea playlist-ului ");
				int numberOfTracks = randomPlaylist.nextInt();
				randomPlaylist.nextLine();
				
				System.out.print("Alegeti un nume pentru playlist ");
				//randomPlaylist.next();
				String playlistName = randomPlaylist.nextLine();
				
				generatedSongList.getRandomPlaylist(songList, numberOfTracks);
     			playlistService.CreatePlaylist(playlistName, generatedSongList.getPlaylist());

				break;
			case 5:
				generatedSongList.play();
				break;
			case 0:
				function = 0;
				break; 
			}
		} while (function != 0);
		sc1.close();
		sc2.close();
		randomPlaylist.close();

	}

	@Override
	public void CreateSong(Song s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteSong(int songID) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Song> ReadSongs() {
		return null;
		// TODO Auto-generated method stub

	}

}
