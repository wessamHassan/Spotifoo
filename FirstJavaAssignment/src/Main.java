// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {

            File file = new File("assets/data.txt");
            Scanner fileScanner = new Scanner(file);
            SongManager songManager = new SongManager(fileScanner);

            Scanner userInputScanner = new Scanner(System.in);
            String userInput;
            System.out.println("Welcome to the Spotifoo music player!");
            do {
                System.out.print("Main Menu options: \n [1] Songs\n [2] Artists\n [3] Albums\n [4] Genre\n (or E to exist the program):  ");
                userInput = userInputScanner.nextLine();

                if(userInput.equals("1"))                {

                    List<Song> myList = songManager.displayAllSongs();
                    do {
                        System.out.print("Enter the SONG NUMBER to run it (or 0 to return back to Main Menu): ");
                        userInput = userInputScanner.nextLine();
                        if (userInput.equals("0")) {
                            break;
                        }
                        songManager.displaySongByUserInput(userInput,myList);
                    } while (true);

                } else if (userInput.equals("2")) {
                    songManager.displayAllArtists();
                    do {
                        System.out.print("Enter the ARTIST NUMBER to display his songs(or 0 to return back to Main Menu): ");
                        String userArtist = userInputScanner.nextLine();
                        if (userArtist.equals("0")) {
                            break;
                        }
                        List<Song> myList = songManager.displaySongsByArtistIndex(userArtist);
                        if(myList.size()>0){
                            System.out.print("Enter the ARTIST SONG NUMBER (or 0 to return back to Main Menu): ");
                            String artistSongNum = userInputScanner.nextLine();
                            if (artistSongNum.equals("0")) {
                                break;
                            }
                            songManager.displaySongByUserInput(artistSongNum,myList);
                        }

                    }while (true);
                } else if (userInput.equals("3")) {
                    songManager.displayAllAlbums();
                    do {
                        System.out.print("Enter the ALBUM NUMBER to display its songs(or 0 to return back to Main Menu): ");
                        String userAlbum = userInputScanner.nextLine();
                        if (userAlbum.equals("0")) {
                            break;
                        }
                        List<Song> myList =songManager.displaySongsByAlbumIndex(userAlbum);
                        if(myList.size()>0){
                            System.out.print("Enter the ALBUM SONG NUMBER (or 0 to return back to Main Menu): ");
                            String albumSongNum = userInputScanner.nextLine();
                            if (albumSongNum.equals("0")) {
                                break;
                            }
                            songManager.displaySongByUserInput(albumSongNum,myList);
                        }

                    }while (true);

                } else if (userInput.equals("4")) {
                   songManager.displayAllGenre();
                    do {
                        System.out.print("Enter the GENRE NUMBER to display its songs(or 0 to return back to Main Menu): ");
                        String userGenre = userInputScanner.nextLine();
                        if (userGenre.equals("0")) {
                            break;
                        }
                        List<Song> myList =songManager.displaySongsByGenreIndex(userGenre);
                        if(myList.size()>0){
                            System.out.print("Enter the GENRE SONG NUMBER (or 0 to return back to Main Menu): ");
                            String genreSongNum = userInputScanner.nextLine();
                            if (genreSongNum.equals("0")) {
                                break;
                            }
                            songManager.displaySongByUserInput(genreSongNum,myList);
                        }

                    }while (true);
                } else if (userInput.equalsIgnoreCase("E")) {
                    break;

                } else {

                    System.out.println("Not a valid input");
                }

            } while (true);

            fileScanner.close();
            userInputScanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }



}