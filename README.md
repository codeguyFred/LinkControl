# LinkControlBridge
the framework to easily,more convenient control View's Animation,such as one view clicked with some views'animation shown or some views of the whole views to shown or hided,some linked actions，will also use rxjava to write control code later.

# 链路控制

        //1 关的时候指定某个节点开
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
                
        //2 开的时候指定某个节点关,当有子节点的时候，子节点不执行
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

        //3 指定某个节点关,当有子节点的时候，子节点不执行
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
        

        //4 开的时候指定某个节点关,当有子节点的时候，子节点也执行原来的逻辑
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
        

        //5 开的时候指定某个节点关,当有子节点的时候，子节点跟父节点执行相同的逻辑
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