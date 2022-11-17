package br.edu.univille.ui;

import javax.swing.*;

public class UtilsMethods extends JFrame{

    public static void newWindowPanel(int x, int y, int altura, int largura, String nomeBtn, JFrame frameAtual, JFrame frameIr){
        JButton btn = new JButton(nomeBtn);
        btn.setBounds(x, y, largura, altura);
        frameIr.dispose();
        btn.addActionListener(e -> {
            frameIr.setVisible(true);
            frameAtual.dispose();
        });
        frameAtual.add(btn);
    }

    public static JButton newBtn(int x, int y, int altura, int largura, String nomeBtn, JFrame frameAtual){
        JButton btn = new JButton(nomeBtn);
        btn.setBounds(x, y, largura, altura);
        frameAtual.add(btn);
        return btn;
    }

    public static boolean newCheckBox(int x, int y, int altura, int largura, String nomeCheckBox, JFrame frameAtual) {
        JLabel label = new JLabel(nomeCheckBox);
        label.setBounds(x + 20, y, nomeCheckBox.length() * 10, 15);
        frameAtual.add(label);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(x, y, largura, altura);
        frameAtual.add(checkBox);

        return checkBox.isSelected();
    }

    public static String newJtextArea(int x, int y, int altura, int largura, String nomeText, JFrame frameAtual) {
        JLabel label = new JLabel(nomeText);
        label.setBounds(x, y - 20, nomeText.length() * 10, 15);
        frameAtual.add(label);

        JTextArea txtArea = new JTextArea();
        txtArea.setBounds(x, y, largura, altura);
        frameAtual.add(txtArea);

        return txtArea.getText();
    }
}
