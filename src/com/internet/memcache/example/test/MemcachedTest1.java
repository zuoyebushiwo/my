package com.internet.memcache.example.test;

import com.internet.memcache.example.model.Employee;
import com.internet.memcache.example.util.MemcachedUtil;

/** 
 *  
 * <pre><b>����������</b>����ȡ����MemcachedTest����������Ƿ�һ�� 
 * 
 * @author ��****(Kevin.xie)<br> 
 * 
 * <b>�޸���ʷ��</b>(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����) 
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