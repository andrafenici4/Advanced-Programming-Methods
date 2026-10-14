package repository;

import exception.RepositoryException;
import model.Creature;

public class InMemoryRepository implements IRepository {
    private Creature[] elements;
    private int size;
    private int capacity;

    public InMemoryRepository(int capacity) {
        this.capacity = capacity;
        this.elements = new Creature[capacity];
        this.size = 0;
    }

    @Override
    public void add(Creature creature) throws RepositoryException {
        if (this.size >= this.capacity) {
            throw new RepositoryException("Repository is full");
        }
        this.elements[this.size++] = creature;
    }
    @Override
    public void remove(int index) throws RepositoryException {
        if (index < 0 || index >= this.size) {
            throw new RepositoryException("Index out of bounds");
        }
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size - 1] = null;
        this.size--;
    }
    @Override
    public Creature[] getAll() {
        Creature[] copy = new Creature[this.size];
        System.arraycopy(this.elements, 0, copy, 0, this.size);
        return copy;
    }
    @Override
    public int getSize() {
        return this.size;
    }
}
