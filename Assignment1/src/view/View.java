package view;

import controller.AquariumController;
import exception.RepositoryException;
import model.Creature;
import model.Fish;
import model.Turtle;

public class View {
    private final AquariumController controller;

    public View(AquariumController controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.println("Adding creatures...");
        tryAdd(new Fish(2, "Goldfish"));
        tryAdd(new Fish(1, "Guppy"));
        tryAdd(new Turtle(5, "Ninja"));
        tryAdd(new Turtle(0, "Baby Turtle"));
        tryAdd(new Fish(3, "Clownfish"));

        System.out.println("\nCreatures older than 1 year:");
        printCreatures(controller.getCreaturesOlderThanOneYear());

        System.out.println("\nRemoving the creature at position 1 (Guppy)...");
        tryRemove(1);

        System.out.println("\nCreatures older than 1 year after removal:");
        printCreatures(controller.getCreaturesOlderThanOneYear());
    }

    private void tryAdd(Creature creature) {
        try {
            controller.addCreature(creature);
        } catch (RepositoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void tryRemove(int position) {
        try {
            controller.removeCreature(position);
        } catch (RepositoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printCreatures(Creature[] creatures) {
        if (creatures.length == 0) {
            System.out.println("  (none)");
            return;
        }
        for (Creature c : creatures) {
            System.out.println(" " + c.toString());
        }
    }
}
