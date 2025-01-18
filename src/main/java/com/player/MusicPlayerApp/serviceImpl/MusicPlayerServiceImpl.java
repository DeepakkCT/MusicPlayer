package com.player.MusicPlayerApp.serviceImpl;

import com.player.MusicPlayerApp.model.Song;
import com.player.MusicPlayerApp.playlistExport.ExportFormat;
import com.player.MusicPlayerApp.playlistExport.PlaylistExporter;
import com.player.MusicPlayerApp.repository.SongRepository;
import com.player.MusicPlayerApp.repositoryImpl.SongRepositoryImpl;
import com.player.MusicPlayerApp.service.MusicPlayerSerivce;

import java.io.IOException;
import java.util.List;

public class MusicPlayerServiceImpl implements MusicPlayerSerivce {

    private SongRepository songRepository;
    private SongRepositoryImpl songRepositoryImpl;
    private PlaylistExporter playlistExporter;

    public MusicPlayerServiceImpl(SongRepository songRepository, PlaylistExporter playlistExporter) {
        this.songRepository = songRepository;
        this.playlistExporter = playlistExporter;
    }


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
    public void exportPlaylist(List<Song> songs, String filePath, ExportFormat format) throws IOException {

        if (songs == null || songs.isEmpty()) {
            throw new IllegalArgumentException("Song list cannot be empty");
        }
        playlistExporter.exportPlaylist(songs, filePath, format);
    }


    @Override
    public List<Song> getAll() {
        return songRepository.getAllSongs();
    }
}
