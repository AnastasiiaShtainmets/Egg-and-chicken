package test;

public class Main {
    public static void main(String[] args) {
        AnimalThread egg = (new AnimalThread("Яйцо"));
        AnimalThread chicken = (new AnimalThread("Курица"));
        egg.start();
        chicken.start();

        try {
            egg.join();
            if(chicken.isAlive()){
                System.out.println("Выиграла курица");
            }else {
                chicken.join();
                System.out.println("Выиграло яйцо");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
class AnimalThread extends Thread {
    String Name;
    final int distance = 6;
    public AnimalThread(String Name) {

        this.Name = Name;
    }
    @Override
    public void run() {
        Thread.currentThread().setName(Name);
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(5000);
                System.out.println(getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
