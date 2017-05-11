/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamgir
 */
import com.auction.db.HibernateUtil;
import com.auction.dto.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SchemaGenerator {
    public static void main(String[] args) {
        try {
            HibernateUtil.getSession();
            Class<?> c = Class.forName(AccountSettingFA.class.getName());
            Object t = c.newInstance();
            
            Field[] fields = c.getDeclaredFields();
            StringBuilder builder = new StringBuilder();
            builder.append(getClassStartSchema(c));
            builder.append(getIdTag());
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[ i ];
                f.setAccessible(true);
                if(f.getName().equals("id")){
                    continue;
                }
                
                builder.append("<property name=\"");
                builder.append(f.getName()+"\" ");
                builder.append("column=\"");
                builder.append(convertName(f.getName()));
                builder.append("\" ");
                builder.append("type=\"");
                builder.append(getType(f.getGenericType())+"\"/>");
                builder.append("\n");
            }
            builder.append(getClassEndSchema());
            System.out.println(builder.toString());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SchemaGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SchemaGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SchemaGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
	
    }
    
    public static String convertName(String name){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < name.length(); i ++){
            if(i > 0 && Character.isUpperCase(name.charAt(i))){
                builder.append("_");
            }
            builder.append(Character.toLowerCase(name.charAt(i)));
        }
        return builder.toString();
    }
    public static String getType(Type type){
        if(type.toString().contains("java.lang.String")){
            return "string";
        }
        return type.toString();
    }
    public static String getIdTag(){
        String tag = "<id name=\"id\" type=\"int\">\n" +
                        "<generator class=\"native\"/>\n" +
                         "</id>\n";
        return tag;
    }
    
    public static String getClassStartSchema(Class cls){
        String tag = "<class name=\""+cls.getName()+"\" table=\""+convertName(cls.getSimpleName())+"\" \n" + 
                "dynamic-update=\"true\" dynamic-insert=\"true\" select-before-update=\"true\">\n";
        
        return tag;
    }
    public static String getClassEndSchema(){
        String tag = "\n</class>";
        
        return tag;
    }
    
}
