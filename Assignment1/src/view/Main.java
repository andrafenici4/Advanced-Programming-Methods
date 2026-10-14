package view;

import controller.AquariumController;
import repository.InMemoryRepository;
import repository.IRepository;

public class Main {
    public static void main(String[] args) {
        IRepository repo = new InMemoryRepository(10);
        AquariumController controller = new AquariumController(repo);
        View view = new View(controller);
        view.run();
    }
}
