package com.dmspallas;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name,String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();

    }
    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title,duration));
            return true;
        }else{
            return false;
        }

    }
    private Song findSong(String title){
        for(Song checkSong: this.songs){
            if(checkSong.getTitle()==title){
                return checkSong;
            }
        }
        return null;
    }
    public boolean addToPlaylist(int trackNumber,LinkedList<Song> playlist){
        int index = trackNumber = 1;
        if(index>=0 && index<= this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album has not have track " + trackNumber);
        return false;
    }
    public boolean addToPlaylist(String title,LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong!=null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("the song " + title + " is not in the album");
        return false;
    }

}

