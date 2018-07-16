package cn.codeguy.controllib;

import android.support.annotation.IntDef;

/**
 * Created by fred
 * Date: 2018/7/5.
 * Time: 15:46
 * classDescription:
 *       A
 *    B     C
 * D    E
 *
 * 0 DEEP 正常执行回调 即是从父节点向下执行回调 即 深度遍历 A->B->D->E->C
 * 1 DEEP_REVERSE 从最深的节点从左到右 往上执行回调 D->E->B->C->A
 * 2 RIGHT2LEFT 从最深的节点从右到左 往上执行回调 E->D->C->B->A
 * 3 LEFT2RIGHT 从上到下，从左到右 执行回调 即 广度遍历 A->B->C->D->E
 * 4 OTHER 未定义 C->E->D->B->A
 */
@IntDef({DIRECTION.DEEP,DIRECTION.DEEP_REVERSE,
        DIRECTION.RIGHT2LEFT,DIRECTION.LEFT2RIGHT,
        DIRECTION.OTHER
})
public @interface Action {}