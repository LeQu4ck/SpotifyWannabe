package proiectTehnologiiMobile;

//import java.io.File;
//import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
import java.util.Scanner;

public class app implements ICrudFunctions {
	enum genres {
		hip_hop, rock, jazz, country, metal, classic, rap;
	}

//	public static boolean validateArtistName(String s) {
//		String patternString = "[a-zA-Z0-9\\s*\\-*].{10,}";
//		Pattern pattern = Pattern.compile(patternString);
//
//		Matcher matcher = pattern.matcher(s);
//		boolean matches = matcher.matches();
//		if (matches) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean validateTitle(String s) {
//		String patternString = "^(\\w.+(\\s|\\-)).+$";
//		// String patternString = "^(\\w.+(\\s|\\-)).+$";
//		Pattern pattern = Pattern.compile(patternString);
//
//		Matcher matcher = pattern.matcher(s);
//		boolean matches = matcher.matches();
//		if (matches) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean validateDuration(String s) {
//		String patternString = "^[+]?(0|0?[.]\\d+|[1-9]+([.]\\d+)?)$";
//		Pattern pattern = Pattern.compile(patternString);
//
//		// String durata = s.toString();
//		Matcher matcher = pattern.matcher(s);
//		boolean matches = matcher.matches();
//		if (matches) {
//			return true;
//		}
//		return false;
//	}
//    
//	public static boolean validateGenre(String s) {
//
//		for (genres c : genres.values()) {
//			if (c.name().equals(s)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public static boolean validateYtLink(String s) {
//		String patternString = "^http(?:s?):\\/\\/(?:www\\.)?youtu(?:be\\.com\\/watch\\?v=|\\.be\\/)([\\w\\-\\_]*)(&(amp;)?‌​[\\w\\?‌​=]*)?$";
//		Pattern pattern = Pattern.compile(patternString);
//
//		Matcher matcher = pattern.matcher(s);
//		boolean matches = matcher.matches();
//		if (matches) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean validate(String artist, String title, String durata, String gen, String link) {
//		if (validateArtistName(artist) && validateTitle(title) && validateDuration(durata) && validateGenre(gen)
//				&& validateYtLink(link)) {
//			return true;
//		}
//		return false;
//	}

//	public static void readSong() {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Introduceti artistul:" + "\n");
//		String artist = sc.nextLine();
//
//		System.out.println("Introduceti titlul:" + "\n");
//		String title = sc.nextLine();
//
//		System.out.println("Introduceti durata:" + "\n");
//		String durata = sc.nextLine();
//
//		System.out.println("Introduceti genul:" + "\n");
//		String genre = sc.nextLine();
//
//		System.out.println("Introduceti link-ul:" + "\n");
//		String link = sc.nextLine();
//
//		if (validate(artist, title, durata, genre, link)) {
//			Song song = new Song(artist, title, Double.valueOf(durata), genre, link);
//			insertSong(song);
//		} else {
//			System.out.println("Verificati datele introduse!");
//		}
//		sc.close();
//	}
	
	public static void insertSong(Song song) {
		try {
			
			//inserare melodie intr o lista si dupa scrisa in fila?
			//functie care sa citeasca toate cantecele la inceputul rularii + call in celelalte functii?
			FileWriter myWriter = new FileWriter("songsFile");
			PrintWriter pw = new PrintWriter(myWriter);
			String sg = song.insertString();
			pw.write(sg, 0, 0);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void songList() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("songsFile"));
		List<Song> songList = new ArrayList<Song>();
		while (sc.hasNext()) {
			String songDetails = sc.nextLine();

			String[] parts = songDetails.split(",");

			String artist = parts[0];

			String title = parts[1];

			String durata = parts[2];

			String genre = parts[3];

			String link = parts[4];

			Song song = new Song(artist, title, Double.valueOf(durata), genre, link);

			songList.add(song);
		}
		sc.close();

		for (Song s : songList) {
			System.out.println(s);
		}

	}

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		ICrudFunctions crudFunc  = new CrudFunctions();
		Scanner sc = new Scanner(System.in);
		System.out.println("Tastati 1 pt. introducere, " + "2 pt. stergere, " + "3 pt. afisare lista cantece"
				+ " 0 pt. iesire din aplicatie.");
		
		int function = -1;
		while (function != 0) {
			
			function = sc.nextInt();
			
			switch (function) {
			case 1:
				System.out.println("Introducere detalii melodie:");
				crudFunc.CreateSong();
				
				sc.nextInt();
				break;
			case 2:
				System.out.println("Stergere");
				
				sc.nextInt();
				break;
			case 3:
				System.out.println("Afisare lista cantece.");
				
				ArrayList<Song> songList = crudFunc.ReadSongs();
				for(Song s: songList) {
					System.out.println(s);
				}
				
				sc.nextInt();
				break;
			case 0:
				System.out.println("Inchidere aplicatie...");
				function = 0;
				break;

			}
		}
		sc.close();
		
		
//		Song sg = new Song("ads", "asdasd", 43.2,"fadsf","asdsa");
//
//		System.out.println(sg);
		
		

	}

	@Override
	public void CreateSong() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteSong() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Song> ReadSongs() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
