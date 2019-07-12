package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-user" , fallback = SysUserServiceError.class)
public interface SysUserServiceFeign extends SysUserService {
}
