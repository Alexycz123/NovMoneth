package com.ycz.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ycz
 * @since 2021-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String password;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    private Date lastLogin;


}
