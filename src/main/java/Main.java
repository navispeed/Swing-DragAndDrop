import GUI.DragAndDrop;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new DragAndDrop(jFrame).panel1);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
