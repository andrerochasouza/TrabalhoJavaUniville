package br.edu.univille.ui;

import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    private final ListaService listaService;
    private final TarefaService tarefaService;
    ;


    public TelaInicial(ListaService listaService, TarefaService tarefaService) {

        this.listaService = listaService;
        this.tarefaService = tarefaService;

        setTitle("Tela inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton btnIrParaCadastroTarefas = new JButton("Ir para Cadastro de Tarefas");
        btnIrParaCadastroTarefas.setBounds(150, 200, 200, 50);
        btnIrParaCadastroTarefas.addActionListener(e -> {
            new CadastroTarefas(listaService, tarefaService).setVisible(true);
            dispose();
        });
        add(btnIrParaCadastroTarefas);

    }
}
