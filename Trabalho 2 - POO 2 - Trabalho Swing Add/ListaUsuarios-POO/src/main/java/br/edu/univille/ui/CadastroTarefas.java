package br.edu.univille.ui;


import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;

import javax.swing.*;
import java.awt.*;

public class CadastroTarefas extends JFrame {

    private final ListaService listaService;
    private final TarefaService tarefaService;

    public CadastroTarefas(ListaService listaService, TarefaService tarefaService) {
        this.listaService = listaService;
        this.tarefaService = tarefaService;

        setTitle("Cadastro de Tarefas");
        setSize(500, 500);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.campoTextoTarefa();
        this.campoSelectionPrioridade();
        this.campoCheckBoxFinalizado();
        this.campoBotaoCancelarSalvar();

    }

    public void campoTextoTarefa() {
        Label labelTarefa = new Label("Tarefa");
        labelTarefa.setBounds(50, 30, 50, 10);
        add(labelTarefa);

        JTextArea txtTarefa = new JTextArea();
        txtTarefa.setBounds(50, 50, 375, 200);
        add(txtTarefa);

    }

    public void campoSelectionPrioridade() {
        Label labelPrioridade = new Label("Prioridade");
        labelPrioridade.setBounds(50, 280, 70, 10);
        add(labelPrioridade);

        JComboBox comboBoxPrioridade = new JComboBox();
        comboBoxPrioridade.setBounds(50, 300, 375, 30);
        comboBoxPrioridade.addItem("Baixa");
        comboBoxPrioridade.addItem("Média");
        comboBoxPrioridade.addItem("Alta");
        add(comboBoxPrioridade);

    }

    public void campoCheckBoxFinalizado() {
        Label labelFinalizado = new Label("Finalizado");
        labelFinalizado.setBounds(70, 395, 70, 10);
        add(labelFinalizado);

        JCheckBox checkBoxFinalizado = new JCheckBox();
        checkBoxFinalizado.setBounds(50, 350, 100, 100);
        add(checkBoxFinalizado);

    }

    public void campoBotaoCancelarSalvar() {
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 425, 100, 20);
        add(btnCancelar);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(325, 425, 100, 20);
        add(btnSalvar);

    }

}
