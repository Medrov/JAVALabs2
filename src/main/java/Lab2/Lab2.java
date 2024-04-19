package main.java.Lab2;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import main.java.Lab2.UI.GUI;

import java.io.IOException;
import com.formdev.flatlaf.FlatDarkLaf; // или другую тему из FlatLaf

import javax.swing.*;

public class Lab2 {

    public static void main(String[] args) throws IOException {
        try {
            //UIManager.setLookAndFeel(new FlatMacDarkLaf());
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        (new GUI()).setVisible(true);
    }
}
