package com.ycz.query;/*
 @author ycz
 @date 2021-11-09-11:02
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery extends Query{
    private String name;
    private String address;
    private String email;
    private String loginName;
}
