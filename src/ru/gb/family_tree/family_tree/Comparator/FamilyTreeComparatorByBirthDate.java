package ru.gb.family_tree.family_tree.Comparator;

import ru.gb.family_tree.family_tree.TreeNode;

import java.util.Comparator;

public class FamilyTreeComparatorByBirthDate<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
