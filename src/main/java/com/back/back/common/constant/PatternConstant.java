package com.back.back.common.constant;

public interface PatternConstant {

    String PASSWORDPATTERN = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,15}$"; 
    String EMAILPATTERN = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$";
    
}
