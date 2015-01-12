package com.internet.memcache.example.test;

import com.internet.memcache.example.model.Employee;
import com.internet.memcache.example.util.MemcachedUtil;

/** 
 *  
 * <pre><b>功能描述：</b>测试取出从MemcachedTest存入的数据是否一致 
 * 
 * @author ：****(Kevin.xie)<br> 
 * 
 * <b>修改历史：</b>(修改人，修改时间，修改原因/内容) 
 * 
 * </pre> 
 */  
public class MemcachedTest1 {  
      
    public static void main(String[] args) {  
  
        MemcachedUtil cache = MemcachedUtil.getInstance();  
        cache.add("msg", "Say hello to you !");  
        System.out.println("get value : " + cache.get("msg"));  
          
        Employee tempEmp = (Employee) cache.get("emp");  
        System.out.println("Company: " + tempEmp.getCompanyName());  
        System.out.println("   Dept: " + tempEmp.getDeptName());  
        System.out.println("   Name: " + tempEmp.getEmpName());  
          
    }  
}