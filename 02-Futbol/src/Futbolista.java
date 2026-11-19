public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String[] noms = { "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
                "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé" };

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }

        System.out.println("Inici dels xuts --------------------");
        for (Futbolista jugador : jugadors) {
            jugador.start();
        }

        for (Futbolista jugador : jugadors) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fi dels xuts -----------------------");

        System.out.println("--- Estadistiques ------");
        for (Futbolista jugador : jugadors) {
            System.out.printf("%-9s-> %2d gols%n", jugador.getName(), jugador.getNgols());
        }
    }
}