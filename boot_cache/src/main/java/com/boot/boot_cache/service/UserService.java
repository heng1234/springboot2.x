package com.boot.boot_cache.service;

import com.boot.boot_cache.entity.User;
import com.boot.boot_cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : kaifa
 * create at:  2019-10-22  10:10
 * @description: user 业务层
 */
@Service
@CacheConfig(cacheNames = "myuser")
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询所有用户
     * @return
     */
    @Cacheable
   public List<User> selectListAll(){
        return userMapper.selectListAll();
    }

    /**
     * 修改用户
     * @param user
     * @return
     */

    @CachePut(key = "#user.id")
    @Transactional
   public User updateUser(User user){
         userMapper.updateUser(user) ;
         return userMapper.findUserById(user.getId());//这里修改后需要查询一遍进行缓存
    }
    /**
     * 查询所有用户
     * @return
     */
    @Cacheable(key = "#id")
    public User findUserById(Integer id){
        return userMapper.findUserById(id);
    }
   /* @CacheEvict(key = "#user.id")
    @Transactional
    public void updateUser(User user){
         userMapper.updateUser(user) ;
    }*/

}
