/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import com.dht.utils.MyConnectSingleton;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionQueyBuilder {
    private StringBuilder query;
    private StringBuilder where;
    private String orderBy = "id DESC";
    private List<Object> params;

    public QuestionQueyBuilder() {
        this.query =  new StringBuilder("Select * From question Where 1=1 %s Order By %s");
        
        this.where = new StringBuilder();
        this.params = new ArrayList<>();
    }
    
    
    public QuestionQueyBuilder widthkeyword(String kw){
        if(kw!=null && !kw.isEmpty() )
         {
             this.where.append(" AND content like concat('%',?,'%')");
             params.add(kw);
         }  
        return this;
    }
    public QuestionQueyBuilder widthCategory(Category ct){
        if(ct != null )
         {
             this.where.append(" AND category_id = ? ");
             params.add(ct.getId());
         }  
        return this;
    }
     public QuestionQueyBuilder setLimit(int limit){
      if(!this.query.toString().toLowerCase().contains("limit")){
          this.query.append(" Limit ? ");
          this.params.add(limit);
      }
        return this;
    }
     public QuestionQueyBuilder setLimit(String limit){
     this.setLimit(Integer.parseInt(limit));
        return this;
    }
     public QuestionQueyBuilder widthLevel(Level lv){
        if(lv != null )
         {
             this.where.append(" AND level_id = ? ");
             params.add(lv.getId());
         }  
        return this;
    }
    public PreparedStatement build() throws SQLException{
        String sql =String.format(this.query.toString(), this.where.toString(),this.orderBy.toString());
        PreparedStatement stm = MyConnectSingleton.getInstance().connect().prepareCall(sql);
        for(int i=0;i<this.params.size();i++)
            stm.setObject(i+1, this.params.get(i));
        return stm;
        
    }
    
    
}
