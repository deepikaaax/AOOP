public class MusicStreamingApp {
    public static void main(String[] args) {
        MusicPlayerFacade player = new MusicPlayerFacade();

        MusicSource localMusic = new LocalMusicSource("song.mp3");
        MusicSource streamingMusic = new StreamingServiceAdapter("Spotify", "12345");
        MusicSource radioStation = new RadioStationAdapter("http://radio.example.com");

        player.setSource(localMusic);
        System.out.println("\nPlaying Local Music:");
        player.playMusic();

        player.setSource(streamingMusic);
        System.out.println("\nSwitching to Streaming Service:");
        player.playMusic();

        player.setSource(radioStation);
        System.out.println("\nSwitching to Radio Station:");
        player.playMusic();

        MusicSource equalizedMusic = new EqualizerDecorator(localMusic);
        player.setSource(equalizedMusic);
        System.out.println("\nPlaying Local Music with Equalizer:");
        player.playMusic();

        MusicSource lyricsMusic = new LyricsDecorator(equalizedMusic);
        player.setSource(lyricsMusic);
        System.out.println("\nPlaying Local Music with Equalizer and Lyrics:");
        player.playMusic();
    }
}
