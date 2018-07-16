package cn.codeguy.controllib.i;


import cn.codeguy.controllib.Action;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 16:57
 * classDescription:
 */
public interface Options {
    /**
     * 0表示顺序
     * 1表示反序
     * 回调都是后加的先回调，所以默认0需要处理回调成倒序
     * @param direction
     * @return
     */
    Options direction(@Action int direction);
}
