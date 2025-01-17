package com.player.MusicPlayerApp;

import com.player.MusicPlayerApp.model.Song;
import com.player.MusicPlayerApp.repository.SongRepository;
import com.player.MusicPlayerApp.repositoryImpl.SongRepositoryImpl;
import com.player.MusicPlayerApp.service.MusicPlayerSerivce;
import com.player.MusicPlayerApp.serviceImpl.MusicPlayerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class MusicPlayerAppApplication {

	public static void main(String[] args) {

		//SpringApplication.run(MusicPlayerAppApplication.class, args);
		SongRepository songRepository = new SongRepositoryImpl();
		MusicPlayerSerivce musicPlayerSerivce = new MusicPlayerServiceImpl(songRepository);

		musicPlayerSerivce.addSong("Beete Lamhe", "KK");
		musicPlayerSerivce.addSong("Tu hi meri shab hai", "KK");
		musicPlayerSerivce.playSong("Beete Lamhe", "KK");
		musicPlayerSerivce.addSong("Khuda Jane", "KK");
		musicPlayerSerivce.addSong("Be intehaan", "Atif Aslam");
		musicPlayerSerivce.addSong("Uska hi banana", "Arijit Singh");
		musicPlayerSerivce.addSong("Labon ko", "KK");
		musicPlayerSerivce.addSong("Haan tu hai", "KK");
		musicPlayerSerivce.addSong("kabhi na kabhi", "aditya narayan");
		musicPlayerSerivce.addSong("kuch iss tarah", "atif aslam");
		musicPlayerSerivce.addSong("tere ishq mein", "aditya yadav");
		musicPlayerSerivce.addSong("zara sa", "KK");


		musicPlayerSerivce.playSong("khuda jane", "KK");
		musicPlayerSerivce.playSong("Khuda Jane", "kk");
		musicPlayerSerivce.playSong("zara sa", "kk");
		musicPlayerSerivce.playSong("kuch iss tarah", "atif aslam");
		musicPlayerSerivce.playSong("tere ishq mein", "aditya yadav");
		musicPlayerSerivce.playSong("zara sa", "kk");
		musicPlayerSerivce.playSong("zara sa", "kk");
		musicPlayerSerivce.playSong("kuch iss tarah", "atif aslam");
		musicPlayerSerivce.playSong("kuch iss tarah", "atif aslam");
		musicPlayerSerivce.playSong("kuch iss tarah", "atif aslam");
		musicPlayerSerivce.addSong("maula mere maula", "roop kumar rathod");
		musicPlayerSerivce.playSong("maula mere maula", "roop kumar rathod");
		musicPlayerSerivce.playSong("maula mere maula", "roop kumar rathod");
		musicPlayerSerivce.playSong("maula mere maula", "roop kumar rathod");
		musicPlayerSerivce.playSong("maula mere maula", "roop kumar rathod");

		musicPlayerSerivce.addSong("", "");
		musicPlayerSerivce.addSong("", "deepak");
		musicPlayerSerivce.addSong("lol", "");
		System.out.println("Artist total song : " + musicPlayerSerivce.getSongsByArtist("kk"));
		System.out.println("Artist total song : " + musicPlayerSerivce.getSongsByArtist("atif aslam"));
		System.out.println("total song : " + musicPlayerSerivce.getAll());

		musicPlayerSerivce.addSong("Be intehaan", "Atif Aslam");
		musicPlayerSerivce.playSong("Khuda Jane", "lol");

		Song song = musicPlayerSerivce.findSong("Beete Lamhe", "KK");
		System.out.println(song.getName());

		Song song2 = musicPlayerSerivce.findSong("Beete Lamhe", "JK");
		//System.out.println(song);








		System.out.println("Daily Top Songs : " + musicPlayerSerivce.getTopDailySongs(2));
		System.out.println("Top Songs : " +musicPlayerSerivce.getTopSongs(2));
		System.out.println("Top Songs of Artist : " +musicPlayerSerivce.getTopArtistSongs("kk", 2));


	}

}
