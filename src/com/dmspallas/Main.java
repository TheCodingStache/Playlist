package com.dmspallas;
import java.net.BindException;
import java.util.*;

public class Main {
    private static List<Album> albums = new ArrayList<>();
    public static void main(String args[]) {

        Album album = new Album("Kamikaze", "Eminem");
        album.addSong("Kill shot", 3.45);
        album.addSong("The Ringer", 5.37);
        album.addSong("Greatest", 3.46);
        album.addSong("Lucky You", 4.04);
        albums.add(album);

        album = new Album("Rap God", "Eminem");
        album.addSong("track 1", 3.42);
        album.addSong("track 2", 4.47);
        album.addSong("track 3", 6.42);
        album.addSong("track 4", 7.42);
        album.addSong("track 5", 1.42);
        album.addSong("track 6", 8.42);
        album.addSong("track 7", 3.42);
        album.addSong("track 8", 9.42);
        albums.add(album);
        List<Song> playlist = new Vector<>( );
        albums.get(0).addToPlaylist("RUN", playlist);
        albums.get(0).addToPlaylist("Hannibal", playlist);
        albums.get(0).addToPlaylist("Greatest", playlist); //does not exist
        albums.get(0).addToPlaylist(0, playlist);
        albums.get(1).addToPlaylist(3,playlist);
        albums.get(1).addToPlaylist(8,playlist);
        albums.get(1).addToPlaylist(24,playlist);




        play(playlist);

    }
    private static void play(List<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("no songs in playlist");
            return;
        }else{
            System.out.println("now playing " +listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("we have reached the end of the playlist" );
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = true;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now playing"+ listIterator.previous().toString());
                    }else{
                        System.out.println("we are at the start of the playlist");
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now replaying" + listIterator.previous().toString());
                        }else{
                            System.out.println("we are at the start of the list");
                        }
                    } else{
                        if(listIterator.hasNext()){
                            System.out.println("now replaying" + listIterator.next().toString());
                            forward = true;
                        } else{
                            System.out.println("we have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("available actions\npress");
        System.out.println("0 -- to quin\n" +
                "1-- to play next song\n" +
                "2-- to play previous song\n" +
                "3-- to replay current song\n" +
                "4-- list songs in playlist\n"+
                "5-- print available actions\n"+
                "6-- delete current song on playlist");
    }
    private static void printList(List<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("===================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==================");
    }
}

