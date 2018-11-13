package com.dmspallas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();


    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title,duration));
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playlist) {
        Song checkSong = this.songs.findSong(trackNumber);
        if (checkSong != null) {
            playlist.add(checkSong);
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlaylist(String title, List<Song> playlist) {
        Song checkedSongs = this.songs.findSong(title);
        if (checkedSongs != null) {
            playlist.add(checkedSongs);
            return true;
        } else {
            return false;
        }

    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }
        public boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }else {
                this.songs.add(song);
                return true;
            }
        }

        public Song findSong(String title) {
            for (Song checkSong : this.songs) {
                if (checkSong.getTitle() == title) {
                    return checkSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index > 0) && index < songs.size()) {
                return songs.get(index);
            } else {
                return null;
            }
        }
    }
}

