package com.own.config;

import com.own.utils.SecurityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类功能说明:
 * 类修改者	创建日期2020/8/16
 * 修改说明
 *
 * @author wzy
 * @version V1.0
 * @description 说明：
 **/
@Service("own")
public class OwnPermissionConfig {

   public Boolean check(String ...permission){
      // 获取当前登录权限
      List<String> roles = SecurityUtils.getCurrentUser().getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
      // 判断当前用户的所有权限是否包含接口上定义的权限 (permission中的字符串 只要能够匹配到roles中字符串)
      return roles.contains("admin") || Arrays.stream(permission).anyMatch(roles::contains);

   }

}
