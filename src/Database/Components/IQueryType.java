/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Components;

/**
 *
 * @author Alim
 */
public interface IQueryType {
    byte WHERE_AND       =   0;
    byte WHERE_OR        =   1;
    byte STARTS_WITH     =   2;
    byte CONTAINS        =   3;
    byte ENDS_WITH       =   4;
    byte GROUP_BY        =   5;
    byte ORDER_BY        =   6;
    byte MIN             =   7;
    byte MAX             =   8;
    byte AVG             =   9;
    byte COUNT           =   10;
    byte COMMAND         =   11;
    
}

