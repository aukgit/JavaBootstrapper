/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Component.DesignPatterm;

/**
 *
 * @author Alim
 */
public interface IQueryType {
    int WHERE_AND       =   0;
    int WHERE_OR        =   1;
    int STARTS_WITH     =   2;
    int CONTAINS        =   3;
    int ENDS_WITH       =   4;
    int GROUP_BY        =   5;
    int ORDER_BY        =   6;
    int MIN             =   7;
    int MAX             =   8;
    int AVG             =   9;
    int COUNT           =   10;
    int COMMAND         =   11;
    
}

