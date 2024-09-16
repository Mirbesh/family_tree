package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.family_tree.Comparator.FamilyTreeComparatorByBirthDate;
import ru.gb.family_tree.family_tree.Comparator.FamilyTreeComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private int personId;
    private List<E> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public boolean addPerson(E person){

        if (person == null) {return false;}
        if (!people.contains(person)){
            people.add(person);
            person.setID(personId++);
            return true;
        }
        return false;
}

private void addParents(E person){
    for (E parent : person.getParents()) {
        parent.addChild(person);
    }
}

private void addChildren(E person){
        for (E child: person.getChildren()){
            child.addParent(person);
        }
}

public List<E> getByName(String name){
        List<E> result = new ArrayList<>();
        for (E person : people) {
        if(person.getName().equals(name)){
            result.add(person);
        }
    }
    return result;
}

public boolean setWedding(E person1, E person2){
        if (person1.getSpouse()==null && person2.getSpouse()==null){
            person1.setSpouse(person2);
            person2.setSpouse(person1);
            return true;
        }else return false;
}

private boolean checkId(int id){
        if (id< this.personId && id>=0) return true;
        else return false;
}

public E getId(int id){
    for (E person : people) {
        if (person.getId()==id) return person;
    }
    return null;
}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cемейное древо:\n");
        for (E person : people) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator(){
        return new FamilyTreeIterator(people);
    }

    public void sortByName(){
        people.sort(new FamilyTreeComparatorByName());
    }

    public void sortByBirthDate(){
        people.sort(new FamilyTreeComparatorByBirthDate());
    }

}
