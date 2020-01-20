package com.tuhin.springboot.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    String vlan;

    public List<Integer> getVlan() {
        if (vlan.length() <= 2) return new ArrayList<>();
        return Arrays.stream(vlan.split("#"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void setVlan(List<Integer> list) {
        this.vlan = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining("#"));
    }

    public void setVlan(String list) {
        this.vlan = list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 100001 - 100; i < 100001; i++) {
            list.add(i);
        }
        Test test = new Test();
        test.setVlan(list);
        System.out.println(test.getVlan());
    }
}
