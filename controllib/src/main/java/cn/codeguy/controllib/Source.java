package cn.codeguy.controllib;


import cn.codeguy.controllib.config.OptionsConfig;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:41
 * classDescription:
 */
public interface Source {
    Source open(Source sourceParent);
    Source close(Source sourceParent);
    Source withSource(Source source);
    Source apply(OptionsConfig options);
    Source action(@Action int action);
    boolean isAllActioned();
    boolean isActioned();
}
