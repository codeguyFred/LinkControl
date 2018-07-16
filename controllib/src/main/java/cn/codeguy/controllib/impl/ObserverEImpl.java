package cn.codeguy.controllib.impl;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:44
 * classDescription:
 */
public class ObserverEImpl extends ObserverImplLink {
    public ObserverEImpl(int tag) {
        super(tag);
    }

    @Override
    protected void thisOpen() {
        super.thisOpen();
        System.out.println("E开");
    }

    @Override
    protected void thisClose() {
        super.thisClose();
        System.out.println("E关");
    }

}
