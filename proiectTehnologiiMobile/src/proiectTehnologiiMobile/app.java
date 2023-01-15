package proiectTehnologiiMobile;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//import java.io.File;
//import java.util.regex.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class app implements ISongService {

	/*
	 * public static HashSet<Song> getRandomElement(ArrayList<Song> list, int
	 * totalItems) { Random rand = new Random();
	 * 
	 * HashSet<Song> newList = new HashSet<>(totalItems); while (newList.size() !=
	 * totalItems) {
	 * 
	 * int randomIndex = rand.nextInt(list.size());
	 * 
	 * newList.add(list.get(randomIndex)); } return newList; }
	 */
	public static void main(String[] args) throws SQLException, IOException, URISyntaxException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner randomPlaylist = new Scanner(System.in);
		
		ISongService crudFunc = new SongService();
		
		Playlist generatedPlaylist = new Playlist();
		ArrayList<Song> songList = new ArrayList<Song>();

		songList = crudFunc.ReadSongs();

		int function = -2;

		do {
			String menu = "Tastati 1 pt. afisare lista cantece, " + "2 pt. stergere, " + "3 pt. introducere, "
					+ "4 pt. generare playlist random, " + "5 pt. redare Playlist " + " 0 pt. iesire din aplicatie.";
			System.out.print(menu);
			// System.out.println("function"+function);
			function = sc1.nextInt();

			switch (function) {

			case 1:
				songList = crudFunc.ReadSongs();
				for(Song s: songList) {
					System.out.println(s);
				}
				break;

			case 2:
				System.out.println("Alege numarul cantecului pe care vreti sa-l stergeti: ");
				int songID = sc1.nextInt();
				crudFunc.DeleteSong(songID);
				songList = crudFunc.ReadSongs();
				break;
			case 3:
				System.out.println("Introduceti artistul:");
				String artist = sc2.nextLine();

				System.out.println("Introduceti titlul:");

				String title = sc2.nextLine();

				System.out.println("Introduceti durata:");
				String durata = sc2.next();

				System.out.println("Introduceti genul:");
				String genre = sc2.next();

				System.out.println("Introduceti link-ul:");
				String link = sc2.next();

				Song s = new Song(artist, title, Integer.parseInt(durata), genre, link);
				if (s.validate()) {
					crudFunc.CreateSong(s);
				} else {
					System.out.println("Verificati valorile introduse!");
				}
				break;
			case 4:
				System.out.println("Specificati lungimea playlist-ului ");
				int numberOfTracks = randomPlaylist.nextInt();
				generatedPlaylist.getRandomPlaylist(songList, numberOfTracks);
				break;
			case 5:
				generatedPlaylist.play();
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
