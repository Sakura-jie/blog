package com.cherriesovo.blog.vo.params;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class LoginParam {
    private String account;

    private String password;

    private String nickname;
}
