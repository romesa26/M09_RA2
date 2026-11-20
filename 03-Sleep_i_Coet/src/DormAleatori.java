import java.util.Random;

public class DormAleatori extends Thread {

    private long tempsCreacio;
    private Random random;

    public DormAleatori(String nom) {
        super(nom);
        tempsCreacio = System.currentTimeMillis();
        random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000);
            long total = System.currentTimeMillis() - tempsCreacio;
            System.out.printf("%-4s(%d) a dormir %4dms total %5dms%n", getName(), i, interval, total);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");
        joan.start();
        pep.start();
        System.out.println("-- Fi de main -----------");
    }
}