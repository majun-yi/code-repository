package com.dalaoyang.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    long totalElement;

    List<T> data;
}
