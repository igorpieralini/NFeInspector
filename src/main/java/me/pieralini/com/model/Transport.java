package me.pieralini.com.model;

public class Transport {
    private String modFrete;
    private Emitter transporter;
    private Vehicle vehicle;
    private Volume volume;

    public String getModFrete() { return modFrete; }
    public void setModFrete(String modFrete) { this.modFrete = modFrete; }
    public Emitter getTransporter() { return transporter; }
    public void setTransporter(Emitter transporter) { this.transporter = transporter; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public Volume getVolume() { return volume; }
    public void setVolume(Volume volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "modFrete=" + modFrete + " transporter=" + (transporter != null ? transporter.getName() : "n/a") + " vehicle=" + (vehicle != null ? vehicle : "") + " volume=" + (volume != null ? volume : "");
    }
}
