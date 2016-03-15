package com.company.target.product;

/**
 * @date 2016年03月09日
 */
public class Consumer extends Thread {

    // 每次消费的产品数量
    private int num;

    // 所在放置的仓库
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        consume(num);
    }

    private void consume(int num) {
        storage.consume(num);
    }

    // Getter and Setter忽略

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
