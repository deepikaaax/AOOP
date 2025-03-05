class RadioStationAdapter implements MusicSource {
    private String stationUrl;

    public RadioStationAdapter(String stationUrl) {
        this.stationUrl = stationUrl;
    }

    @Override
    public void play() {
        System.out.println("Tuning into radio station: " + stationUrl);
    }
}
