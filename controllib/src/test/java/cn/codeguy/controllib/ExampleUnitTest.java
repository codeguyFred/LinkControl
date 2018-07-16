package cn.codeguy.controllib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test() {
        //1 关的时候指定某个节点开
        /*ObserverAImpl observerA = new ObserverAImpl(1);
        Source observerB = new ObserverBImpl(2).action(1);
        ObserverCImpl observerC = new ObserverCImpl(3);
        Source observerD = new ObserverDImpl(4);
        Source observerE = new ObserverEImpl(5);

        observerA
                .apply(OptionsConfig.get().direction(DIRECTION.LEFT2RIGHT))
                .withSource(observerB
                        .withSource(observerD)
                        .withSource(observerE))
                .withSource(observerC)
                .close(null);*/
        //2 开的时候指定某个节点关,当有子节点的时候，子节点不执行
        /*ObserverAImpl observerA = new ObserverAImpl(1);
        Source observerB = new ObserverBImpl(2).action(0);
        ObserverCImpl observerC = new ObserverCImpl(3);
        Source observerD = new ObserverDImpl(4);
        Source observerE = new ObserverEImpl(5);

        observerA
                .apply(OptionsConfig.get().direction(DIRECTION.LEFT2RIGHT))
                .withSource(observerB
                        .withSource(observerD)
                        .withSource(observerE))
                .withSource(observerC)
                .open(null);*/
        //3 指定某个节点不执行
/*        ObserverAImpl observerA = new ObserverAImpl(1);
        Source observerB = new ObserverBImpl(2).setActioned(true);
        ObserverCImpl observerC = new ObserverCImpl(3);
        Source observerD = new ObserverDImpl(4);
        Source observerE = new ObserverEImpl(5);

        observerA
                .apply(OptionsConfig.get().direction(DIRECTION.LEFT2RIGHT))
                .withSource(observerB
                        .withSource(observerD)
                        .withSource(observerE))
                .withSource(observerC)
//                .open(null);
                .close(null);*/
        // TODO: 2018/7/16

        //4 开的时候指定某个节点关,当有子节点的时候，子节点也执行原来的逻辑

        // TODO: 2018/7/16
        //5 开的时候指定某个节点关,当有子节点的时候，子节点跟父节点执行相同的逻辑



    }
}