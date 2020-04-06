package ui;

import javax.swing.*;

// classe agrupa atributos e funcoes (acoes)
public class Mainform extends JFrame {
    // ATRIBUTOS
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;

    //CONSTRUTOR = é algo que é executado qdo a classe é criada
    public Mainform() {

        // chamar funcoes para mostrar na tela (comportamentos do Java Swing)
        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);
    }
}
