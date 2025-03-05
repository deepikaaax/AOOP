class LyricsDecorator extends MusicFeatureDecorator {
    public LyricsDecorator(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Displaying lyrics on screen...");
    }
}
