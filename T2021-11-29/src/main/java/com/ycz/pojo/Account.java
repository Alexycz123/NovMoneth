package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-29-9:01
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private double money;
}
