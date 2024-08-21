public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        boolean keepAsking;
        do {
            keepAsking = ui.app();
        } while (keepAsking);


    }
}
