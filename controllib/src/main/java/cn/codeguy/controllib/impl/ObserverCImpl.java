package cn.codeguy.controllib.impl;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:28
 * classDescription:
 */
public class ObserverCImpl extends ObserverImplLink {

    public ObserverCImpl(int tag) {
        super(tag);
    }

    @Override
    protected void thisOpen() {
        super.thisOpen();
        System.out.println("C开");
    }

    @Override
    protected void thisClose() {
        super.thisClose();
        System.out.println("C关");
    }


}