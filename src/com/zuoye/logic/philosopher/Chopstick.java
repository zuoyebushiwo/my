package com.zuoye.logic.philosopher;

/**
 * 筷子
 *
 * @author ZuoYe
 * @date 2015年10月26日
 */
public class Chopstick {

    /**
     * 表示筷子是否可用
     */
    private volatile boolean available = true;
    private int id;

    public Chopstick() {

    }

    public Chopstick(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "筷子" + id;
    }

}
