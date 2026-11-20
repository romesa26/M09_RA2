import java.util.Scanner;

public class Coet {

    private Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            throw new IllegalArgumentException("Error: la potència ha de ser entre 0 i 10");
        }
        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        Scanner scanner = new Scanner(System.in);
        boolean arrancat = false;
        int p;
        do {
            p = scanner.nextInt();
            try {
                coet.passaAPotencia(p);
                if (!arrancat) {
                    coet.arranca();
                    arrancat = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                p = -1;
            }
        } while (p != 0);
        scanner.close();
    }
}