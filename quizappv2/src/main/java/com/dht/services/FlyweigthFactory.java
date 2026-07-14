/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class FlyweigthFactory {
    private static  final Map<String ,List> cachedData = new HashMap<>();
    
    public static <E> List<E> getData(QueryServiceBase q, String kw) throws SQLException{
    if(cachedData.containsKey(kw)== false )
   
        cachedData.put(kw, q.list());
       return cachedData.get(kw);
    
//      if(cachedData.containsKey(kw)== true)
//            return cachedData.get(kw);
//      else cachedData.put(kw, q.list());
//       return cachedData.get(kw);
    }
}
