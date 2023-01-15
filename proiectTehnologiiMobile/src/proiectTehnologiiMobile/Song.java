package proiectTehnologiiMobile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import proiectTehnologiiMobile.app.genres;

public class Song {
	private int songID;
	private String artist;
	private String title;
	private int duration;
	private String songType;
	private String link;

	public Song(int songID, String artist, String title, int duration, String songType, String link) {
		
		this.songID = songID;
		this.artist = artist;
		this.title = title;
		this.duration = duration;
		this.songType = songType;
		this.link = link;
	}
	
	public Song(String artist, String title, int duration, String songType, String link) {
		
		this.artist = artist;
		this.title = title;
		this.duration = duration;
		this.songType = songType;
		this.link = link;
	}

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public Song() {

	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	enum genres {
		hip_hop, rock, jazz, country, metal, classic, rap;
	}

	public static boolean validateArtistName(String s) {
		String patternString = "[a-zA-Z0-9\\s*\\-*].{10,}";
		Pattern pattern = Pattern.compile(patternString);

		Matcher matcher = pattern.matcher(s);
		boolean matches = matcher.matches();
		if (matches) {
			return true;
		}
		return false;
	}

	public boolean validateTitle(String s) {
		String patternString = "^(\\w.+(\\s|\\-)).+$";
		// String patternString = "^(\\w.+(\\s|\\-)).+$";
		Pattern pattern = Pattern.compile(patternString);

		Matcher matcher = pattern.matcher(s);
		boolean matches = matcher.matches();
		if (matches) {
			return true;
		}
		return false;
	}

	public boolean validateDuration(Double s) {
		String patternString = "^[+]?(0|[1-9]\\d*)?$";
		Pattern pattern = Pattern.compile(patternString);

		String durata = s.toString();
		Matcher matcher = pattern.matcher(durata);
		boolean matches = matcher.matches();
		if (matches) {
			return true;
		}
		return false;
	}

	public boolean validateGenre(String s) {

		for (genres c : genres.values()) {
			if (c.name().equals(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateYtLink(String s) {
		String patternString = "^http(?:s?):\\/\\/(?:www\\.)?youtu(?:be\\.com\\/watch\\?v=|\\.be\\/)([\\w\\-\\_]*)(&(amp;)?‌​[\\w\\?‌​=]*)?$";

		Pattern pattern = Pattern.compile(patternString);

		Matcher matcher = pattern.matcher(s);
		boolean matches = matcher.matches();
		if (matches) {
			return true;
		}
		return false;
	}

	public boolean validate() {
		if (validateArtistName(this.getArtist()) && validateTitle(this.getTitle()) && validateDuration(this.getDuration())
				&& validateGenre(this.getSongType()) && validateYtLink(this.getLink())) {
			return true;
		}
		return false;
	}

	public String insertString() {
		String s = this.artist + "," + this.title + "," + this.duration + "," + this.songType + "," + this.link;
		return s;
	}

	@Override
	public String toString() {
		return "Song  " + songID + ":" + "\n" + "Artist: " + artist + "\n" + "Title: " + title + "\n" + "Duration: " + duration + "\n"
				+ "Song type: " + songType + "\n" + "Link: " + link;
	}

}
