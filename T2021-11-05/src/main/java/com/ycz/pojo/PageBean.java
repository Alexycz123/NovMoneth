package com.ycz.pojo;/*
 @author ycz
 @date 2021-11-10-10:54
*/

import com.ycz.query.UserQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Integer page;
    private Integer limit;
    private Integer userPageTotal;
    private Integer count;
    private UserQuery userQuery;
    private List<User> userList;



}
