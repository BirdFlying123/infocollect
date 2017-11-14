package uestc.utils;

import uestc.common.Mapper;

public class Convert {
    public static int getInt(String message){
        for (Mapper mapper:Mapper.values()) {
            if(mapper.getMessage().equals(message))
                return mapper.getNumber();
        }
        return -1;
    }
    public static String getString(int number){
        for(Mapper mapper:Mapper.values()){
            if(mapper.getNumber()==number){
                return mapper.getMessage();
            }
        }
        return null;
    }
}
