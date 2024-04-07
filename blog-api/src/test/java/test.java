
import com.alibaba.fastjson.JSON;
import com.cherriesovo.blog.dao.pojo.SysUser;
import com.cherriesovo.blog.service.LoginService;
import com.cherriesovo.blog.service.SysUserService;
import com.cherriesovo.blog.utils.JWTUtils;
import com.cherriesovo.blog.vo.ErrorCode;
import com.cherriesovo.blog.vo.Result;
import com.cherriesovo.blog.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class test {

    private static final String slat = "cherriesovo!@#";
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;




    public static void main(String[] args) {
        String password = "123456";

        //2、根据用户名和密码去user表查询是否存在
        String pwd = DigestUtils.md5Hex(password + slat);   //加密
        System.out.println(pwd);
    }

}
