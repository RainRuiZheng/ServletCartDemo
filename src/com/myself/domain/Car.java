package com.myself.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ﳵ�࣬����ӣ�ɾ���ͻ�ȡ���ﳵ��
 * @author Jungor
 *
 */
public class Car {
    // ���ڴ��CarItem�����ﳵ���list
    private List<CarItem> list = new ArrayList<CarItem>();

    /**
     * ��ȡ���ﳵ�е����й��ﳵ��
     * @return �������й��ﳵ���List
     */
    public List<CarItem> list() {

        return list;
    }

    /**
     * ��ӹ��ﳵ����ﳵ
     * @param carItem ��Ҫ��ӵĹ��ﳵ��
     */
    public void add(CarItem carItem) {
        this.list.add(carItem);
    }

    /**
     * �ӹ��ﳵ��ɾ�����ﳵ��
     * @param id ��Ҫɾ���Ĺ��ﳵ��ID
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