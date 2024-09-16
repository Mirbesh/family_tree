package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human father, mother, spouse;
    List<Human>  children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null,null);
    }

    public Human(String name, Gender gender, LocalDate birthDate,Human father, Human mother) {
        this(name, gender, birthDate, null, father,mother);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father!= null) list.add(father);
        if (mother!= null) list.add(mother);
        return list;
    }
    public List<Human> getChildren(){
        List<Human> list = new ArrayList<>(2);
        if (!children.isEmpty()) {
            for (Human child : children) {
                list.add(child);
            }
        };

        return list;
    }

    public int getAge(){
        if (deathDate==null){
            Period age = Period.between(birthDate, LocalDate.now());
            return age.getYears();
        } else {
            Period age = Period.between(birthDate, deathDate);
            return age.getYears();
        }
    }

    public String addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            if (child.getGender().equals(Gender.Male)) {
                return "Успешно добавлен сын.";
            } else if (child.getGender().equals(Gender.Female)){
                return "Успешно добавлена дочь.";
            }
        }
        return "Такая запись уже существует!";
    }

    public String addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return "Родитель добавлен.";
    }
    public String getSpouseInfo(){
    String result = "супруг(а): ";
    if (spouse!=null){
        result += spouse.getName();
    }else {
        result += "нет";
    }
    return result;
    }

    public String getFatherInfo(){
        String result = "отец: ";
        if (father!=null){
            result += father.getName();
        }else {
            result += "неизвестен";
        }
        return result;
    }

    public String getMotherInfo(){
        String result = "мать: ";
        if (mother!=null){
            result += mother.getName();
        }else {
            result += "неизвестна";
        }
        return result;
    }

    public String getChildInfo(){
        String result = "дети:";
       if (!children.isEmpty()){
           result += children.getFirst().getName();
           for (int i = 1; i<children.size();i++){
               result += ", ";
               result+= children.get(i).getName();
           }
       } else {
            result += "отсутствуют";
        }
        return result;
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ИД:");
        stringBuilder.append(id);
        stringBuilder.append(", имя:");
        stringBuilder.append(name);
        stringBuilder.append(", пол:");
        stringBuilder.append(getGender());
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(",");
        stringBuilder.append(getSpouseInfo());
        stringBuilder.append(",");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(",");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(",");
        stringBuilder.append(getChildInfo());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId()==getId();
    }
}

