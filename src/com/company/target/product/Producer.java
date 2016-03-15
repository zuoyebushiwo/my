package com.company.target.product;

/**
 * @date 2016年03月09日
 */
public class Producer extends Thread {

    // 每次生产的产品数量
    private int num;

    // 所在放置的仓库
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        produce(num);
    }

    // 调用仓库Storage的生产函数
    private void produce(int num) {
        storage.produce(num);
    }

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
