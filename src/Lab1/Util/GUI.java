package Lab1.Util;

import Lab1.Model.User;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class GUI extends JFrame {
    public GUI() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode professorNode = new DefaultMutableTreeNode("Учителя");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты");

        User[] users = Generator.generateUsers(45);
        DefaultMutableTreeNode[] userNodes = new DefaultMutableTreeNode[users.length];
        for (int i = 0; i < users.length; i++) {
            userNodes[i] = users[i].createNode();
            if (users[i].isTeacher()) {
                professorNode.add(userNodes[i]);
            } else studentNode.add(userNodes[i]);
        }
        root.add(professorNode);
        root.add(studentNode);

        JTree tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        add(new JScrollPane(tree));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library");
        this.setSize(200, 200);
        this.setVisible(true);
    }
}
