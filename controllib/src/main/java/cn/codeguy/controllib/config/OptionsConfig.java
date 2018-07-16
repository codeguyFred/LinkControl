package cn.codeguy.controllib.config;


import cn.codeguy.controllib.Action;
import cn.codeguy.controllib.i.Options;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 16:57
 * classDescription:
 */
public class OptionsConfig implements Options {
    private static final OptionsConfig INSTANCE = new OptionsConfig();
    private int direction=-1;
    // TODO: 2018/7/12 是否清空数据，用于优化
    private boolean clear;

    public int getDirection() {
        return direction;
    }
    public static OptionsConfig get() {
        return OptionsConfig.INSTANCE;
    }

    @Override
    public OptionsConfig direction(@Action int direction) {
        this.direction=direction;
        return this;
    }

}
