
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SongManager {
    private List<Song> songList;
    private List<String> artists;
    private List<String> genres;
    private List<String> albums;
    private List<Song> artistSongs;
    private List<Song> albumSongs;
    private List<Song> genreSongs;

    public SongManager(Scanner scanner) {
        songList = createSongList(scanner);
    }
    private List<Song> createSongList(Scanner scanner) {
        artists = new ArrayList<>();
        songList = new ArrayList<>();
        genres = new ArrayList<>();
        albums = new ArrayList<>();
        do{
            String line = scanner.nextLine();
            String[] values = line.split(",");

            if (values.length >= 6) {

                String songName = values[0];
                String artist = values[1];
                String album = values[2];
                String genre = values[3];
                String mp3FileName = values[4];
                String albumImage = values[5];

                Song song = new Song(songName,mp3FileName,albumImage,artist,album, genre);
                songList.add(song);
                if (!artists.contains(artist)) {
                    artists.add(artist);
                }
                if (!genres.contains(genre)) {
                    genres.add(genre);
                }
                if (!albums.contains(album)) {
                    albums.add(album);
                }
            }
        } while (scanner.hasNextLine());

        return songList;
    }

    public List<Song> displayAllSongs() {
        System.out.println("All Songs:");
        int i=0;
        for (Song song : songList) {
            i++;
            System.out.println(i  + ". " + song.getSongName());
        }
        System.out.println();
        return songList;
    }

    public void displaySongByUserInput(String userInput,List<Song> myList){
        try {
            int songNum = Integer.parseInt(userInput);
            if(myList.size() < songNum)
            {
                throw new Exception();
            }
            Song song = myList.get(songNum - 1);

            if (song.getMp3FileName() != null  && song.getMp3FileName().contains("mp3")) {
                runSongByFileName(song.getMp3FileName());
                openSongAlbumImage(song.getAlbumImage());

            } else {
                System.out.println("Song not found. Please try again.");
            }
        }catch (Exception e){
            System.out.println("Value must be number from 1 to " + myList.size() );
        }

    }
    public void displayAllArtists() {
        System.out.println("All Artists:");
        for (int i = 0; i < artists.size(); i++) {
            System.out.println((i + 1) + ". " + artists.get(i));
        }
    }
    public  void displayAllAlbums() {
        System.out.println("All Albums:");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println((i + 1) + ". " + albums.get(i));
        }
    }
    public  void displayAllGenre() {
        System.out.println("All Genres:");
        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }
    }

    private static void runSongByFileName(String fileName) {
        String folderPath = "assets/songs/";
        Path songPath = Paths.get(folderPath, fileName);

        try {
            Runtime.getRuntime().exec("cmd /c start " + songPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to run the song: " + e.getMessage());
        }
    }
    private static void openSongAlbumImage(String albumImage) {
        String folderPath = "assets/albums/";
        String defaultImagePath = "assets/no-picture.png";
        Path imgPath;

        if (albumImage != null && albumImage.contains("png")) {
            imgPath = Paths.get(folderPath, albumImage);
        } else {
            imgPath = Paths.get(defaultImagePath);
        }

        try {
            if (Files.exists(imgPath)) {
                Runtime.getRuntime().exec("cmd /c start " + imgPath.toAbsolutePath());
            } else {
                Runtime.getRuntime().exec("cmd /c start " + Paths.get(defaultImagePath).toAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Failed to run the image: " + e.getMessage());
        }

    }

    public List<Song> displaySongsByArtistIndex(String userArtist) {
        try{
            artistSongs = new ArrayList<>();
            int index = Integer.parseInt(userArtist);
            if(artists.size() < index)
            {
                throw new Exception();
            }
            String artist = artists.get(index - 1);
            int i = 0;
            for (Song song : songList) {
                if (song.getArtist().equals(artist)) {
                    artistSongs.add(song);
                    i++;
                    System.out.println( i + ". " + song.getSongName());
                }
            }

        }catch (Exception e){
            System.out.println("Value must be number from 1 to " + artists.size() );
        }
        return artistSongs;

    }

    public List<Song> displaySongsByAlbumIndex(String userAlbum) {
        try{
            albumSongs = new ArrayList<>();
            int index = Integer.parseInt(userAlbum);
            if(albums.size() < index)
            {
                throw new Exception();
            }
            String album = albums.get(index - 1);
            int i = 0;
            for (Song song : songList) {
                if (song.getAlbum().equals(album)) {
                    albumSongs.add(song);
                    i++;
                    System.out.println( i + ". " + song.getSongName());
                }
            }

        }catch (Exception e){
            System.out.println("Value must be number from 1 to " + albums.size() );
        }
        return albumSongs;

    }

    public List<Song> displaySongsByGenreIndex(String userGenre) {
        try{
            genreSongs = new ArrayList<>();
            int index = Integer.parseInt(userGenre);
            if(genres.size() < index)
            {
                throw new Exception();
            }
            String genre = genres.get(index - 1);
            int i = 0;
            for (Song song : songList) {
                if (song.getGenre().equals(genre)) {
                    genreSongs.add(song);
                    i++;
                    System.out.println( i + ". " + song.getSongName());
                }
            }

        }catch (Exception e){
            System.out.println("Value must be number from 1 to " + genres.size() );
        }
        return genreSongs;

    }
}
