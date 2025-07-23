package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContadorView extends JFrame {
    private JLabel labelContador;
    private JButton buttonIncrement;
    private JButton buttonDecrement;

    public ContadorView() {
        setTitle("Contador MVC");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza no meio da tela
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        labelContador = new JLabel("0");
        labelContador.setFont(new Font("Arial", Font.BOLD, 48));

        buttonIncrement = new JButton("Increment");
        buttonIncrement.setFont(new Font("Arial", Font.PLAIN, 18));

        buttonDecrement = new JButton("Decrement");
        buttonDecrement.setFont(new Font("Arial", Font.PLAIN, 18));

        add(labelContador);
        add(buttonIncrement);
        add(buttonDecrement);
    }

    public void addIncrementListener(ActionListener listener) {
        buttonIncrement.addActionListener(listener);
    }

    public void addDecrementListener(ActionListener listener) {
        buttonDecrement.addActionListener(listener);
    }

    public void setValor(int valor) {
        labelContador.setText(String.valueOf(valor));
    }

}
