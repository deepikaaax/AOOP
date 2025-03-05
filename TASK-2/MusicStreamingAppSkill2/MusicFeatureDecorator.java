abstract class MusicFeatureDecorator implements MusicSource {
    protected MusicSource musicSource;

    public MusicFeatureDecorator(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    @Override
    public void play() {
        musicSource.play();
    }
}
