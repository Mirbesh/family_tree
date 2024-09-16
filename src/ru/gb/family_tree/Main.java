package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

import static java.lang.System.load;

public class Main {
    final static String filepath="family_tree/family_tree.txt";

    public static void main(String[] args) {

        FamilyTree familyTree = load();
//        FamilyTree familyTree = getFamilyTree();

//        saveFamilyTree(familyTree);

        System.out.println(familyTree);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler(filepath);
        return (FamilyTree) fileHandler.read();
    }

    private static void saveFamilyTree(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(filepath);
        fileHandler.save(familyTree);
    }

    private static FamilyTree getFamilyTree() {
        FamilyTree familyTree = new FamilyTree();
        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1979,10,15));
        Human ira = new Human("Ира", Gender.Female, LocalDate.of(1981, 12, 22));

        familyTree.addPerson(ivan);
        familyTree.addPerson(ira);
        familyTree.setWedding(ivan,ira);
        Human bakyt = new Human("Бакыт", Gender.Male, LocalDate.of(2003, 3, 20),ivan,ira);
        Human mira = new Human("Мира", Gender.Female, LocalDate.of(2007, 5, 6),ivan,ira);
        familyTree.addPerson(bakyt);
        familyTree.addPerson(mira);
        return familyTree;
    }

}
