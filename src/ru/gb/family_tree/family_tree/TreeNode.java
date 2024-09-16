package ru.gb.family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setID(int id);
    int getId();
    T getFather();
    T getMother();
    boolean addPerson(T person);
    boolean addChildren(T person);
    boolean addParents(T person);
    String getName();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T person);
}
