public class Fil extends Thread {
    private final long retard;

    public Fil(String nom, int prioritat, long retard) {
        super(nom);
        setPriority(prioritat);
        this.retard = retard;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            if (retard > 0) {
                try {
                    Thread.sleep(retard);
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                int comptador = 0;
                while (comptador < 1000) {
                    comptador++;
                }
            }
            System.out.println(getName() + " " + i);
        }
        System.out.println("Acaba el fil " + getName());
    }
}