package de.limago;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame{


    public Main()  {


        setSize(300, 300);
        Button button = new Button("Drück mich");

        add(button);


    }

    private void beenden() {
        dispose();
    }



    public static void main(String[] args) {

        new Main().setVisible(true);
    }



}
