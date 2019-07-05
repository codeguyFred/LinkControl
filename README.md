# LinkControlBridge
>the framework to easily,more convenient control View's Animation,such as one view clicked with some views'animation shown or some views of the whole views to shown or hided,some linked actions，will also use rxjava to write control code later.
this may not right sample,this is the idea I want to show https://github.com/codeguyFred/MyPerformance/blob/master/app/src/main/java/com/optimize/performance/launchstarter/sort/TaskSortUtil.java

```
 *       A
 *    B     C
 * D    E
 *
 * 0 DEEP 正常执行回调 即是从父节点向下执行回调 即 深度遍历 A->B->D->E->C
 * 1 DEEP_REVERSE 从最深的节点从左到右 往上执行回调 D->E->B->C->A
 * 2 RIGHT2LEFT 从最深的节点从右到左 往上执行回调 E->D->C->B->A
 * 3 LEFT2RIGHT 从上到下，从左到右 执行回调 即 广度遍历 A->B->C->D->E
 * 4 OTHER 未定义 C->E->D->B->A

```
因为RIGHT2LEFT使用场景不是很多，所以待完善

# 适用场景
具备相反条件的或者需要联动的所有操作，比如动画的播放和停止，View的显示和隐藏，动作的触发和联动，app启动优化（控制子线程执行先后顺序和关系
https://github.com/codeguyFred/MyPerformance/blob/master/app/src/main/java/com/optimize/performance/launchstarter/sort/TaskSortUtil.java）

# 灵感来源
广度遍历和深度遍历，物理的并联开关

# 链路控制
## 1 关的时候指定某个节点开
```java
        ObserverAImpl observerA = new ObserverAImpl(1);
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
                .close(null);
```

## 2 开的时候指定某个节点关,当有子节点的时候，子节点不执行
```java
        ObserverAImpl observerA = new ObserverAImpl(1);
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
                .open(null);
```
## 3 开的时候指定某个节点关,当有子节点的时候，子节点不执行，同2
```java
        ObserverAImpl observerA = new ObserverAImpl(1);
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
              //.open(null);
                .close(null);
 ```

## 4 开的时候指定某个节点关,当有子节点的时候，子节点也执行原来的逻辑
```java
        ObserverAImpl observerA = new ObserverAImpl(1);
        Source observerB = new ObserverBImpl(2).action(0);
        ObserverCImpl observerC = new ObserverCImpl(3);
        Source observerD = new ObserverDImpl(4);
        Source observerE = new ObserverEImpl(5);

        observerA
                .apply(OptionsConfig.get().direction(DIRECTION.LEFT2RIGHT).action(1))
                .withSource(observerB
                        .withSource(observerD)
                        .withSource(observerE))
                .withSource(observerC)
                .open(null);
```        

## 5 开的时候指定某个节点关,当有子节点的时候，子节点跟父节点执行相同的逻辑
```java
        ObserverAImpl observerA = new ObserverAImpl(1);
        Source observerB = new ObserverBImpl(2).action(0);
        ObserverCImpl observerC = new ObserverCImpl(3);
        Source observerD = new ObserverDImpl(4);
        Source observerE = new ObserverEImpl(5);

        observerA
                .apply(OptionsConfig.get().direction(DIRECTION.LEFT2RIGHT).action(0))
                .withSource(observerB
                        .withSource(observerD)
                        .withSource(observerE))
                .withSource(observerC)
                .open(null);
```
