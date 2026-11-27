public class Administracio {

    private final int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Administracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();

        for (Treballador treballador : administracio.poblacio_activa) {
            treballador.start();
        }

        for (Treballador treballador : administracio.poblacio_activa) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Treballador treballador : administracio.poblacio_activa) {
            System.out.printf("%-10s -> edat: %d / total: %.2f%n",
                    treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }
}