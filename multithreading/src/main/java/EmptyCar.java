public class EmptyCar implements Runnable {

    private Storage storage;

    public EmptyCar(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.load();
    }
}
