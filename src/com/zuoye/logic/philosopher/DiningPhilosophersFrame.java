package com.zuoye.logic.philosopher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiningPhilosophersFrame extends JFrame {
    public DiningPhilosophersFrame(){
        panel2.setLayout(new GridLayout(2, 2, 3, 3));
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(label4);
        JScrollPane js1 = new JScrollPane(thinkingTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane js2 = new JScrollPane(eatingTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane js3 = new JScrollPane(waitingTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel2.add(js1);
        panel2.add(js2);
        panel2.add(js3);
        panel1.setLayout(new FlowLayout());
        panel1.add(label1);
        panel1.add(panel2);
        panel1.add(button);
        setContentPane(panel1);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ChopstickArray chopstickArray = new ChopstickArray(5);
                for(int i = 0; i < 5; i++){
                    new Thread(new Philosopher(i, chopstickArray,
                            thinkingTextArea, eatingTextArea, waitingTextArea))
                            .start();
                }
            }
        });

        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new DiningPhilosophersFrame();
    }

    private final JPanel panel1 = new JPanel();
    private final JPanel panel2 = new JPanel();

    private final JTextArea thinkingTextArea = new JTextArea(5, 10);
    private final JTextArea eatingTextArea = new JTextArea(5, 10);
    private final JTextArea waitingTextArea = new JTextArea(5, 10);

    JLabel label1 = new JLabel("哲学家问题");
    JLabel label2 = new JLabel("思考");
    JLabel label3 = new JLabel("吃饭");
    JLabel label4 = new JLabel("等待");

    JButton button = new JButton("开始运行");
}
