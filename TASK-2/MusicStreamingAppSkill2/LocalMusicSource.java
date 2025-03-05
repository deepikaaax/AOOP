class LocalMusicSource implements MusicSource {
    private String filePath;

    public LocalMusicSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        System.out.println("Playing local file: " + filePath);
    }
}
