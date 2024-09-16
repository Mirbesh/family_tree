package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private int personId;
    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public boolean addPerson(Human person){

        if (person == null) {return false;}
        if (!people.contains(person)){
            people.add(person);
            person.setId(personId++);
            return true;
        }
        return false;
}

private void addParents(Human person){
    for (Human parent : person.getParents()) {
        parent.addChild(person);
    }
}

private void addChildren(Human person){
        for (Human child: person.getChildren()){
            child.addParent(person);
        }
}

public List<Human> getByName(String name){
        List<Human> result = new ArrayList<>();
        for (Human person : people) {
        if(person.getName().equals(name)){
            result.add(person);
        }
    }
    return result;
}

public boolean setWedding(Human person1, Human person2){
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

public Human getId(int id){
    for (Human person : people) {
        if (person.getId()==id) return person;
    }
    return null;
}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cемейное древо:\n");
        for (Human person : people) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
