package com.myself.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类，可添加，删除和获取购物车项
 * @author Jungor
 *
 */
public class Car {
    // 用于存放CarItem（购物车项）的list
    private List<CarItem> list = new ArrayList<CarItem>();

    /**
     * 获取购物车中的所有购物车项
     * @return 包含所有购物车项的List
     */
    public List<CarItem> list() {

        return list;
    }

    /**
     * 添加购物车项到购物车
     * @param carItem 需要添加的购物车项
     */
    public void add(CarItem carItem) {
        this.list.add(carItem);
    }

    /**
     * 从购物车中删除购物车项
     * @param id 需要删除的购物车项ID
     */
    public void remove(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                break;
            }
        }
    }
}