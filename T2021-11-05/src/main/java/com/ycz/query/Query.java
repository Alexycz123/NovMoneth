package com.ycz.query;/*
 @author ycz
 @date 2021-11-09-14:53
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {
    private Integer page=0;
    private Integer limit=3;
}
