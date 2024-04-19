package main.java.Lab1.Model;

import main.java.Lab1.Model.Book.EnglishBook;
import main.java.Lab1.Model.Book.RussianBook;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String name;
    protected String surname;
    public List<EnglishBook> englishBooks;
    public List<RussianBook> russianBooks;


    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        englishBooks = new ArrayList<>();
        russianBooks = new ArrayList<>();
    }

    public boolean isEnglishBookInList(EnglishBook newBook) {
        for (EnglishBook englishBook : englishBooks) {
            if (newBook.equals(englishBook)) return true;
        }
        return false;
    }

    public boolean isRussianBookInList(RussianBook newBook) {
        for (RussianBook russianBook : russianBooks) {
            if (newBook.equals(russianBook)) return true;
        }
        return false;
    }

    public DefaultMutableTreeNode createNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getString());
        for (EnglishBook englishBook : englishBooks) {
            node.add(new DefaultMutableTreeNode(englishBook.getString()));
        }
        for (RussianBook russianBook : russianBooks) {
            node.add(new DefaultMutableTreeNode(russianBook.getString()));
        }
        return node;
    }


    public String getString() {
        return name + " " + surname;
    }

    public abstract boolean isTeacher();
}
