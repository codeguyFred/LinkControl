package cn.codeguy.controllib.impl;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:27
 * classDescription:
 */
public class ObserverBImpl extends ObserverImplLink {


    public ObserverBImpl(int tag) {
        super(tag);
    }

    @Override
    protected void thisOpen() {
        super.thisOpen();
        System.out.println("B开");
    }

    @Override
    protected void thisClose() {
        super.thisClose();
        System.out.println("B关");

    }


}
