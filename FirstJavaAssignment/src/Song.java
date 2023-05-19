public class Song {
    private String songName;
    private String mp3FileName;
    private String albumImage;

    private String artist;
    private String album;
    private String genre;

    public Song( String songName, String mp3FileName, String albumImage,String artist, String album,String genre) {
        this.songName = songName;
        this.mp3FileName = mp3FileName;
        this.albumImage = albumImage;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public String getSongName() {
        return songName;
    }

    public String getMp3FileName() {
        return mp3FileName;
    }

    public String getAlbumImage() {
        return albumImage;
    }
    public String getAlbum() {
        return album;
    }
    public String getArtist() {
        return artist;
    }
    public String getGenre() {
        return genre;
    }
}
