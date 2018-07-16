package cn.codeguy.controllib.impl;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:44
 * classDescription:
 */
public class ObserverDImpl extends ObserverImplLink {


    public ObserverDImpl(int tag) {
        super(tag);
    }

    @Override
    protected void thisOpen() {
        super.thisOpen();
        System.out.println("D开");

    }

    @Override
    protected void thisClose() {
        super.thisClose();
        System.out.println("D关");

    }

}
