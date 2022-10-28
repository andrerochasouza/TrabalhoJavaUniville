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

        UtilsMethods.newJtextArea(50, 50, 200, 375, "Tarefa", this);
        this.campoSelectionPrioridade();
        UtilsMethods.newCheckBox(50, 350, 10, 10, "Finalizado", this);
        UtilsMethods.newBtn(200, 425, 20, 100, "Cancelar", this);
        UtilsMethods.newBtn(325, 425, 20, 100, "Salvar", this);

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
}
