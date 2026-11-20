import java.util.Random;

public class Motor extends Thread {

    private int id;
    private volatile int potenciaObjectiu;
    private int potenciaActual;
    private Random random;

    public Motor(int id) {
        this.id = id;
        potenciaObjectiu = 0;
        potenciaActual = 0;
        random = new Random();
    }

    public void setPotencia(int p) {
        potenciaObjectiu = p;
    }

    @Override
    public void run() {
        boolean quiet = false;
        while (true) {
            int objectiu = potenciaObjectiu;
            if (potenciaActual < objectiu) {
                potenciaActual++;
                quiet = false;
                System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n", id, objectiu, potenciaActual);
            } else if (potenciaActual > objectiu) {
                potenciaActual--;
                quiet = false;
                System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n", id, objectiu, potenciaActual);
            } else {
                if (!quiet) {
                    System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n", id, objectiu, potenciaActual);
                    quiet = true;
                }
                if (objectiu == 0) {
                    break;
                }
            }
            try {
                Thread.sleep(1000 + random.nextInt(1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}