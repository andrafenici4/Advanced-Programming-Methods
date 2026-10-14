package controller;

import exception.RepositoryException;
import model.Creature;
import repository.IRepository;

public class AquariumController {
    private IRepository repository;

    public AquariumController(IRepository repository) {
        this.repository = repository;
    }

    public void addCreature(Creature creature) throws RepositoryException {
        this.repository.add(creature);
    }

    public void removeCreature(int index) throws RepositoryException {
        this.repository.remove(index);
    }

    public Creature[] getCreaturesOlderThanOneYear(){
        Creature[] allCreatures = this.repository.getAll();
        int count = 0;

        for( Creature c : allCreatures){
            if (c.getAge() > 1 )
                count++;
        }
        Creature[] filtered = new Creature[count];
        int index = 0;
        for( Creature c : allCreatures){
            if (c.getAge() > 1 )
                filtered[index++] = c;
        }
        return filtered;
    }
}
