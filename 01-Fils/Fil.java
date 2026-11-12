public class Fil extends Thread {
    private final long retard;

    public Fil(String nom, int prioritat, long retard) {
        super(nom);
        setPriority(prioritat);
        this.retard = retard;
    }
}