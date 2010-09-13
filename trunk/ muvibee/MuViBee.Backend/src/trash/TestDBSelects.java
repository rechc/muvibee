package trash;

import java.util.LinkedList;

import de.muvibee.media.Book;
import de.muvibee.media.Music;
import de.muvibee.media.Video;
import de.muvibee.util.DBSelector;

public class TestDBSelects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBSelector dbs = new DBSelector(false);
		LinkedList<Book> bookList;
		LinkedList<Music> musicList;
		LinkedList<Video> videoList;

		bookList 	= dbs.getBookList();
		musicList 	= dbs.getMusicList();
		videoList 	= dbs.getVideoList();
		
		for (Book book : bookList) {
			System.out.println("Books: " + book.toString());
		}
		for (Music music : musicList) {
			System.out.println("Music: " + music.toString());
		}
		for (Video video : videoList) {
			System.out.println("Video: " + video.toString());
		}
	}

}
