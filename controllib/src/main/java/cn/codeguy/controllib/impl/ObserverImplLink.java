package cn.codeguy.controllib.impl;

import cn.codeguy.controllib.DIRECTION;
import cn.codeguy.controllib.Source;
import cn.codeguy.controllib.config.OptionsConfig;

/**
 * Date: 2018/7/9.
 * Time: 22:27
 * classDescription:
 *
 * @author fred
 */
public abstract class ObserverImplLink extends ObserverImpl {

    public ObserverImplLink(int tag) {
        super(tag);
    }

    @Override
    public Source open(Source sourceParent) {
        if (OptionsConfig.get().getDirection() == DIRECTION.DEEP) {
            thisOpen();
            super.open(this);
        } else if (OptionsConfig.get().getDirection() == DIRECTION.LEFT2RIGHT) {
            if (!isActioned) {
                if (action == 0) {
                    thisClose();
                } else {
                    thisOpen();
                }
            }
            /**
             * 自己打开之后如果父节点还有未打开的子节点，则继续执行父节点的方法
             */
            if (sourceParent != null && !sourceParent.isAllActioned()) {

                for (Source source : ((ObserverImpl) sourceParent).getList()) {
                    if (!source.isActioned()) {
                        source.open(source);
                    }
                }
            }

            super.open(this);
        } else if (OptionsConfig.get().getDirection() == DIRECTION.RIGHT2LEFT) {
            super.open(this);
            thisOpen();
        } else if (OptionsConfig.get().getDirection() == DIRECTION.OTHER) {
            super.open(this);
            thisOpen();
        } else if (OptionsConfig.get().getDirection() == DIRECTION.DEEP_REVERSE) {
            super.open(this);
            thisOpen();
        } else {
            super.open(this);
            thisOpen();
        }
        return this;
    }

    @Override
    public Source close(Source sourceParent) {
        if (OptionsConfig.get().getDirection() == DIRECTION.DEEP) {
            thisClose();
            super.close(this);
        } else if (OptionsConfig.get().getDirection() == DIRECTION.LEFT2RIGHT) {
            if (!isActioned) {
                if (action == 1) {
                    thisOpen();
                } else {
                    thisClose();
                }
            }

            /**
             * 自己打开之后如果父节点还有未打开的子节点，则继续执行父节点的方法
             */
            if (sourceParent != null && !sourceParent.isAllActioned()) {
                for (Source source : ((ObserverImpl) sourceParent).getList()) {
                    if (!source.isActioned()) {
                        source.close(source);
                    }
                }
            }

            super.close(this);
        } else if (OptionsConfig.get().getDirection() == DIRECTION.OTHER) {
            super.close(this);
            thisClose();
        } else if (OptionsConfig.get().getDirection() == DIRECTION.DEEP_REVERSE) {
            super.close(this);
            thisClose();
        } else {
            super.close(this);
            thisClose();
        }
        return this;
    }

    protected void thisOpen() {
        isActioned = true;
    }

    protected void thisClose() {
        isActioned = true;
    }


}
