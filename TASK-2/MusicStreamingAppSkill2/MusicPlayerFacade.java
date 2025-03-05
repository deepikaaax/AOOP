class MusicPlayerFacade {
    private MusicSource currentSource;

    public void setSource(MusicSource source) {
        this.currentSource = source;
    }

    public void playMusic() {
        if (currentSource != null) {
            currentSource.play();
        } else {
            System.out.println("No music source selected.");
        }
    }
}
