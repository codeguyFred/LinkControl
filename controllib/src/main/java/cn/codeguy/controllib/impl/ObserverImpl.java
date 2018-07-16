package cn.codeguy.controllib.impl;

import java.util.LinkedList;
import java.util.List;

import cn.codeguy.controllib.DIRECTION;
import cn.codeguy.controllib.Source;
import cn.codeguy.controllib.config.OptionsConfig;
import cn.codeguy.controllib.i.Observer;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:51
 * classDescription:
 */
public class ObserverImpl implements Observer {

    /**
     * 指定是开还是关
     * 或者其他动作
     */
    protected int action = -1;
    /**
     * 是否执行过
     */
    boolean isActioned;

    public ObserverImpl setActioned(boolean actioned) {
        isActioned = actioned;
        return this;
    }

    // TODO: 2018/7/15 待优化成直观视图
    /**
     * 方便查看层级
     * @param tag
     */
    public ObserverImpl(int tag) {}


    private List<Source> list = new LinkedList<>();

    public List<Source> getList() {
        return list;
    }

    @Override
    public Source open(Source sourceParent) {
        isActioned=true;
        //ActionCallbackImpl 重置所有状态为false
        if (action == 0&&OptionsConfig.get().getAction()==-1) {
            list.clear();
        }
        if (!list.isEmpty()) {
            switch (OptionsConfig.get().getDirection()) {
                case DIRECTION.DEEP:
                    for (Source source : list) {
                        if (action==0&&OptionsConfig.get().getAction()==0){
                            source.close(sourceParent);
                        }else {
                            source.open(sourceParent);
                        }
                    }
                    break;

                case DIRECTION.DEEP_REVERSE:
                    for (Source source : list) {
                        if (action==0&&OptionsConfig.get().getAction()==0){
                            source.close(sourceParent);
                        }else {
                            source.open(sourceParent);
                        }
                    }
                    break;

                case DIRECTION.LEFT2RIGHT:
                    for (Source source : list) {
                        if (action==0&&OptionsConfig.get().getAction()==0){
                            source.close(sourceParent);
                        }else {
                            source.open(sourceParent);
                        }
                    }
                    break;
                case DIRECTION.RIGHT2LEFT:
                    for (int i = list.size() - 1; i >= 0; i--) {
                        Source source = list.get(i);
                        if (action==0&&OptionsConfig.get().getAction()==0){
                            source.close(sourceParent);
                        }else {
                            source.open(sourceParent);
                        }
                    }
                    break;

                case DIRECTION.OTHER:
                    for (int i = list.size() - 1; i >= 0; i--) {
                        Source source = list.get(i);
                        if (action==0&&OptionsConfig.get().getAction()==0){
                            source.close(sourceParent);
                        }else {
                            source.open(sourceParent);
                        }
                    }
                    break;

                default:
            }
            list.clear();
        }
        return this;
    }

    @Override
    public Source close(Source sourceParent) {
        isActioned=true;
        //ActionCallbackImpl 重置所有状态
        if (action == 0&&OptionsConfig.get().getAction()==-1) {
            list.clear();
        }
        if (!list.isEmpty()) {
            for (Source source : list) {
                source.close(sourceParent);
            }
            list.clear();
        }
        return this;
    }

    @Override
    public Source action(int action) {
        this.action = action;
        return this;
    }

    @Override
    public boolean isAllActioned() {
        boolean allActioned=true;
        for (Source source : list) {
            if (!((ObserverImpl) source).isActioned){
                allActioned=false;
            }
        }
        return allActioned;
    }

    @Override
    public boolean isActioned() {
        return isActioned;
    }

    @Override
    public Source withSource(Source source) {
        if (source == null) {
            return this;
        }
        list.add(source);
        Nodes.get().addSource(source);
        return this;
    }


    @Override
    public Source apply(OptionsConfig options) {
        return this;
    }

}
