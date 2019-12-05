public class FullCar implements Runnable {

    private Storage storage;

    public FullCar(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.unload();
    }
}
