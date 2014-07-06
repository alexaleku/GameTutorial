package ru.javabegin.training.goldman.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageManager {

    public static void showInformMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Message Dialog", JOptionPane.PLAIN_MESSAGE);
    }
}
