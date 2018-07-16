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

    /**
     * action=1表示节点关闭时，子节点跟父节点一样关闭
     * action=0表示节点关闭时，子节点还是原来的那样
     * @param action
     * @return
     */
    Options action(@Action int action);
}
