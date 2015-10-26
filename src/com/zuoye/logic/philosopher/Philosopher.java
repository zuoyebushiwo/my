package com.zuoye.logic.philosopher;

import javax.swing.*;
import java.util.Random;

/**
 * @author ZuoYe
 * @date 2015年10月26日
 */
public class Philosopher implements Runnable {

    private int id;
    private boolean state;
    ChopstickArray chopstickArray;
    JTextArea thinkingTextArea;
    JTextArea eatingTextArea;
    JTextArea waitingTextArea;

    public Philosopher() {

    }

    public Philosopher(int id, ChopstickArray chopstickArray,
                       JTextArea thinkingTextArea, JTextArea eatingtextArea,
                       JTextArea waitingTextArea) {
        this.id = id;
        this.chopstickArray = chopstickArray;
        this.thinkingTextArea = thinkingTextArea;
        this.eatingTextArea = eatingtextArea;
        this.waitingTextArea = waitingTextArea;
    }

    public synchronized void thinking() {
        if (state) { // 如果在思考，说明说明这个哲学家两面的筷子没用
            chopstickArray.getId(id).setAvailable(true);
            chopstickArray.getLast(id).setAvailable(true);
            String text = thinkingTextArea.getText();
            thinkingTextArea.setText(text + this + "在思考\n");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        state = false;
    }

    public synchronized void eating() {
        if (!state) { // 在思考
            if (chopstickArray.getId(id).isAvailable()) { // 如果哲学家右手边的筷子可用
                if (chopstickArray.getLast(id).isAvailable()) { // 如果左手边的筷子也可用
                    // 然后将这个能吃饭的哲学家两侧的筷子都设置为不可用
                    chopstickArray.getId(id).setAvailable(false);
                    chopstickArray.getLast(id).setAvailable(false);

                    String text = eatingTextArea.getText();
                    eatingTextArea.setText(text + this + "在吃饭\n");
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                } else { // 右手边的筷子可用，但是左手边的不可用
                    String str = waitingTextArea.getText();
                    waitingTextArea.setText(str + this + "在等待"
                            + chopstickArray.getLast(id) + "\n");
                    try{
                        wait(new Random().nextInt(100));
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            } else {
                // 如果哲学家右手边的筷子不可用则等待
                String str = waitingTextArea.getText();
                waitingTextArea.setText(str + this + "在等待"
                        + chopstickArray.getId(id) + "\n");
                try{
                    wait(new Random().nextInt(100));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        state = true;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; ++i){
            thinking();
            eating();
        }
    }
}
