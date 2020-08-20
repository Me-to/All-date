package com.example.demo.dao;

import com.example.demo.entity.Perms;
import com.example.demo.entity.User;
import com.example.demo.utils.SaltUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    void save(User user);

    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String username);
    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);

//    @Insert("insert into t_user values(#{id},#{username},#{password},#{salt})")
//    void save(User user);

//    @Select("select * from t_user where username=#{username}")
//    User findByUserName(String username);

//    @Select("  SELECT u.id uid,u.username,r.id,r.NAME rname" +
//            "  FROM t_user u" +
//            "  LEFT JOIN t_user_role ur" +
//            "  ON u.id=ur.userid" +
//            "  LEFT JOIN t_role r" +
//            "  ON ur.roleid=r.id" +
//            "  WHERE u.username=#{username}")
        //根据用户名查询所有角色
//    User findRolesByUserName(String username);

//    @Select("SELECT p.id,p.NAME,p.url,r.NAME" +
//            "  FROM t_role r" +
//            "  LEFT JOIN t_role_perms rp" +
//            "  ON r.id=rp.roleid" +
//            "  LEFT JOIN t_perms p ON rp.permsid=p.id" +
//            "  WHERE r.id=#{id}")
        //根据角色id查询权限集合
//    List<Perms> findPermsByRoleId(String id);


}
