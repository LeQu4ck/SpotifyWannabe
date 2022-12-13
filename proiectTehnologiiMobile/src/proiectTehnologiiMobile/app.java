package proiectTehnologiiMobile;

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
import java.util.Scanner;

public class app implements ICrudFunctions {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ICrudFunctions crudFunc = new CrudFunctions();
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
//		System.out.println("Tastati 1 pt. introducere, " + "2 pt. stergere, " + "3 pt. afisare lista cantece"
//				+ " 0 pt. iesire din aplicatie.");

		int function=-2;
//		while (function != 0) {
//			function = sc.nextInt();
//			switch (function) {
//			case 1:
//				System.out.println("Introducere detalii melodie:");
//				crudFunc.CreateSong();
//
//				break;
//			case 2:
//				System.out.println("Stergere");
//				System.out.println("Alege numarul melodiei pe care vrei sa o stergi");
//				int songID = sc.nextInt();
//				crudFunc.DeleteSong(songID);
//
//				break;
//			case 3:
//				System.out.println("Afisare lista cantece.");
//				
//				ArrayList<Song> songList = crudFunc.ReadSongs();
//				for(Song s: songList) {
//					System.out.println(s);
//				}
//
//				break;
//			case 0:
//				System.out.println("Inchidere aplicatie...");
//				function = 0;
//				break;
//			}
//		}
//		
		do {
			
			String menu = "Tastati 1 pt. afisare lista cantece, " + "2 pt. stergere, " + "3 pt. introducere"
					+ " 0 pt. iesire din aplicatie.";
			System.out.print(menu);
			//System.out.println("function"+function);
			function = sc1.nextInt();
			
			switch (function) {

			case 1:
				ArrayList<Song> songList = crudFunc.ReadSongs();
				for (Song s : songList) {
					System.out.println(s);
				}

				break;
				
			case 2:
				int songID = sc1.nextInt();
				crudFunc.DeleteSong(songID);
				break;
			case 3:
				System.out.println("Introduceti artistul:");
				String artist = sc2.nextLine();

				System.out.println("Introduceti titlul:" );
		
				String title = sc2.nextLine();

				System.out.println("Introduceti durata:");
				String durata = sc2.next();

				System.out.println("Introduceti genul:" );
				String genre = sc2.next();

				System.out.println("Introduceti link-ul:" );
				String link = sc2.next();
				
				Song s = new Song(artist, title, Double.valueOf(durata), genre, link);
				if(s.validate()) {
					crudFunc.CreateSong(s);
				}else {
					System.out.println("Verificati valorile introduse!");
				}
				break;
			case 4:
				System.out.println("Option 4");
				break;
			case 5:
				System.out.println("Option 5");
				break;
			case 0:
				function = 0;
				// System.out.println("Wrong option");
				break; // I always use this break, even when not needed.
			}
		} while (function != 0);
		sc1.close();
		sc2.close();

//		Song sg = new Song("ads", "asdasd", 43.2,"fadsf","asdsa");
//
//		System.out.println(sg);

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
