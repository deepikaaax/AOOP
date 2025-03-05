class StreamingServiceAdapter implements MusicSource {
    private String serviceName;
    private String trackId;

    public StreamingServiceAdapter(String serviceName, String trackId) {
        this.serviceName = serviceName;
        this.trackId = trackId;
    }

    @Override
    public void play() {
        System.out.println("Streaming from " + serviceName + ": Track ID " + trackId);
    }
}
