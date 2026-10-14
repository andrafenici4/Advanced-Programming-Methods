package repository;

import exception.RepositoryException;
import model.Creature;

public interface IRepository {
    void add(Creature creature) throws RepositoryException;
    void remove(int index) throws RepositoryException;
    Creature[] getAll();
    int getSize();
}
