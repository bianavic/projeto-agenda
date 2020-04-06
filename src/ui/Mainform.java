package ui;

import javax.swing.*;
import java.awt.*;

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

        // posicao/local de abertura da janela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
