package com.player.MusicPlayerApp.serviceImpl;

import com.player.MusicPlayerApp.model.Song;
import com.player.MusicPlayerApp.repository.SongRepository;
import com.player.MusicPlayerApp.repositoryImpl.SongRepositoryImpl;
import com.player.MusicPlayerApp.service.MusicPlayerSerivce;

import java.util.List;

public class MusicPlayerServiceImpl implements MusicPlayerSerivce {

    private SongRepository songRepository;
    private SongRepositoryImpl songRepositoryImpl;

    public MusicPlayerServiceImpl(SongRepository songRepository) {this.songRepository = songRepository;}

    @Override
    public void addSong(String name, String artist) {
        if(name.trim().isEmpty() || artist.trim().isEmpty()) {
            System.out.println("Invalid input");
            return;
        }
        //String key = (name.trim() + "::" + artist.trim()).toLowerCase();

        else {
            songRepository.addSong(name, artist);
        }
    }

    @Override
    public void playSong(String name, String artist) {

        if(name.trim().isEmpty() || artist.trim().isEmpty()) {
            System.out.println("Invalid input");
            return;
        }

//        Song song = new Song(name, artist);
//        song.incrementPlayCount();



        songRepository.playSong(name, artist);
    }

    @Override
    public Song findSong(String name, String artist) {
        Song song = songRepository.findSong(name, artist);
        //if(song == null) {System.out.println("Song not found");}
        return song;
    }

    @Override
    public List<Song> getTopSongs(int num) {
        return songRepository.getTopSongs(num);
    }

    @Override
    public List<Song> getTopArtistSongs(String artist, int num) {
        return songRepository.getTopSongsByArtist(artist, num);
    }

    @Override
    public List<Song> getTopDailySongs(int num) {
        return songRepository.topDailySongs(num);
    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        return songRepository.getSongsByArtist(artist);
    }


    @Override
    public List<Song> getAll() {
        return songRepository.getAllSongs();
    }
}
