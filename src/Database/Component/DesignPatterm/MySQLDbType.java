/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Component.DesignPatterm;

import Database.Components.SQLCommand;
import Global.AppConfig;
import java.util.ArrayList;

/**
 *
 * @author Alim
 */
public class MySQLDbType extends DatabaseType implements IDatabaseType{
    public static final int TYPE = IDatabaseType.MY_SQL;
    
    
    public MySQLDbType(){
        
    }
}
