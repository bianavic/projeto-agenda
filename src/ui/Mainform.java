package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
    private JLabel labelContactCount;

    // CRIAR VARIAVEIS responsaveis por acessar a lista (acesso ao business)
    // convencao do java: letra <M> na variavel indica que fui eu a criadora da variavel,
    // facilita o acesso as variaveis criadas no business
    private ContactBusiness mContactBusiness; // é preciso instanciar esta variavel para que ela viva,
    // para que ela tenha um valor e nao aponte o erro de estar nula (NullPointerException)

    private String mName = " ";
    private String mPhone = "";

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

    private void loadContacts() {
        // criar a variavel a partir do <mContactBusiness.getList();>
        List<ContactEntity> contactList = mContactBusiness.getList();

        String[] columnNames = {"Nome", "Telefone"}; // estas serao as colunas da tabela
        // como associar a lista de contatos ao elemento? ao Mainform.form?
        // instancio o model vazio
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames); // instanciando um objeto vazio

        // vamos preencher a tabela
        for (ContactEntity i : contactList) {
            Object[] o = new Object[2];

            // preencher o objeto
            o[0] = i.getName();
            o[1] = i.getPhone();

            model.addRow(o);

        }

        // validar para evitar problemas
        tableContacts.clearSelection();
        // este model criado e preenchido agora pertence a table
        tableContacts.setModel(model);

        // criando metodo getContactCountDescription()
        labelContactCount.setText(mContactBusiness.getContactCountDescription());

    }

    // criar funcao que ouve
    private void setListeners() {
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm(); // estou invocando um formulario novo
                dispose();
            }
        });

        // adicionar evento para qdo clicar na caixa de selecao
        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {

                    if(tableContacts.getSelectedRow() != -1) {
                        mName = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        mPhone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }
                }

            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mContactBusiness.delete(mName, mPhone);
                    loadContacts();

                    // validacao | limpar os campos
                    mName = "";
                    mPhone = "";
                } catch(Exception excp) {
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage());
                }
            }
        });
    }
}
