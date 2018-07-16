package cn.codeguy.controllib.impl;


import cn.codeguy.controllib.Source;

/**
 * Date: 2018/7/12.
 * Time: 20:16
 * classDescription: 重置的状态回调
 * @author fred
 */
class ActionCallbackImpl implements ActionCallback {
    @Override
    public void onFinish() {
        for (Source source : Nodes.get().getSources()) {
            if (source instanceof ObserverImpl) {
                ((ObserverImpl) source).setActioned(false);
            }
        }
        //Nodes.get().getSources().clear();
    }
}
