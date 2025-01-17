package com.player.MusicPlayerApp.service;

import com.player.MusicPlayerApp.model.Song;

import java.util.List;

public interface MusicPlayerSerivce {

    void addSong(String name, String artist);
    void playSong(String name, String artist);
    Song findSong(String name, String artist);
    List<Song> getTopSongs(int num);
    List<Song> getTopArtistSongs(String artist, int num);
    List<Song> getTopDailySongs(int num);
    List<Song> getAll();
    List<Song> getSongsByArtist(String artist);
}
