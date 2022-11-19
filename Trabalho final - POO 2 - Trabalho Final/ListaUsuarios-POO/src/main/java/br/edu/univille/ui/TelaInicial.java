package br.edu.univille.ui;

import br.edu.univille.model.Lista;
import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TelaInicial extends JFrame {

    private final ListaService listaService;
    private final TarefaService tarefaService;


    public TelaInicial(ListaService listaService, TarefaService tarefaService) {

        this.listaService = listaService;
        this.tarefaService = tarefaService;

        setTitle("Página de listas de tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        ArrayList<Lista> listas = listaService.listarTodasAsListas();
        List<Object> listObjects = UtilsMethods.newJTableByLista(listas, listaService, tarefaService,this);

        JTable table = (JTable) listObjects.get(0);
        JScrollPane scrollPane = (JScrollPane) listObjects.get(1);
        table.setBounds(50, 50, 600, 450);
        scrollPane.setBounds(650, 50, 15, 450);

        JButton btnNewLista = UtilsMethods.newWindowPanel(550, 550, 50, 70, "+", this, new NovaLista(listaService, tarefaService));
        btnNewLista.setFont(new java.awt.Font("Tahoma", 1, 30));

        this.labelJtable();
    }

    public void labelJtable() {
        JLabel label1 = new JLabel("ID");
        JLabel label2 = new JLabel("Titulo");
        JLabel label3 = new JLabel("Data de criação");
        JLabel label4 = new JLabel("Deletado");
        JLabel label5 = new JLabel("Quantidade de tarefas");

        label1.setBounds(50, 25, 50, 25);
        label2.setBounds(150, 25, 50, 25);
        label3.setBounds(250, 25, 150, 25);
        label4.setBounds(350, 25, 150, 25);
        label5.setBounds(450, 25, 150, 25);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);

    }

}
