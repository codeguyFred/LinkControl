package cn.codeguy.controllib.impl;

import java.util.ArrayList;
import java.util.List;

import cn.codeguy.controllib.Source;


/**
 * Date: 2018/7/12.
 * Time: 20:11
 * classDescription: 所有节点的管理器
 * @author fred
 */
public class Nodes {
    private List<Source> sources=new ArrayList<>();
    private static final Nodes INSTANCE = new Nodes();
    public static Nodes get() {
        return Nodes.INSTANCE;
    }


    public Nodes addSource(Source source) {
        if (source!=null) {
            this.sources.add(source);
        }
        return this;
    }

    public List<Source> getSources() {
        return sources;
    }
}
