package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// classe agrupa atributos e funcoes (acoes)
public class Mainform extends JFrame {
    // ATRIBUTOS
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;

    // CRIAR VARIAVEIS responsaveis por acessar a lista (acesso ao business)
    // convencao do java: letra <M> na variavel indica que fui eu a criadora da variavel,
    // facilita o acesso as variaveis criadas no business
    private ContactBusiness mContactBusiness; // é preciso instanciar esta variavel para que ela viva,
    // para que ela tenha um valor e nao aponte o erro de estar nula (NullPointerException)

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

        // instanciar a variavel para nao gerar o NullPointerException
        // a partir de agora ela tem acesso a metodos: save, delete...
        mContactBusiness = new ContactBusiness();

        // faz a atribuicao dos eventos
        setListeners();
        loadContacts(); // para chamar a funcao
    }

    // criar funcao que ouve
    private void setListeners() {
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ContactForm(); // estou invocando um formulario novo
                dispose();
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
    }

    private void loadContacts() {
        // criar a variavel a partir do <mContactBusiness.getList();>
        List<ContactEntity> contactList = mContactBusiness.getList();
    }

}
