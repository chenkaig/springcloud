package com.jk.text;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroMd5 {

    public static void  main(String[] args){

        //原始密码
        String password = "12345";

        // 盐
        String salt = "eteokues";

        // 散列次数
        Integer hashIterations = 2;

        //构造方法中：
        //第一个参数：明文，原始密码
        //第二个参数：盐，通过使用随机数
        //第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
        Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations);

        String password_md5 = md5Hash.toString();
        System.out.println(password_md5);

        //第一个值为散列算法
        SimpleHash simpleHash = new SimpleHash("md5", password, salt, hashIterations);
        System.out.println(simpleHash.toString());


        String s = Md5Util.MD5Encode("admin", "utf-8");
        String s1 = Md5Util.MD5Encode(s, "utf-8");
        System.out.println(s1);


    }

}
