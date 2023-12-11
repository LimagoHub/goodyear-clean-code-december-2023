package de.limago;

import java.awt.*;
import java.awt.event.*;


public class Main extends Frame {


    public Main()  {


        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->print());
        add(button);


    }





    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    private void print() {
        System.out.println("It works");
    }


//   class MyActionListener implements ActionListener{
//
//       @Override
//       public void actionPerformed(final ActionEvent e) {
//           print();
//       }
//   }

    class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(final WindowEvent e) {
            super.windowClosing(e);
        }
    }
}
