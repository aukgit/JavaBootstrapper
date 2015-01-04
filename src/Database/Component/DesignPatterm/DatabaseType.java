/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Component.DesignPatterm;

import Database.Components.SQLCommand;
import Global.AppConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Alim
 */
public abstract class DatabaseType extends SQLCommand {

    public ArrayList<Field> fieldsList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);
    public ArrayList<ArrayList<String>> valuesList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);

    /**
     *
     */
    public ArrayList<Character> operatorsList;
    public ArrayList<String> joinsList;
    public ArrayList<Byte> queryTypesList;
    
    public String LastSQL;
    

    @SuppressWarnings("LeakingThisInConstructor")
    public DatabaseType() {
        super.setDatabaseType(this);
    }

    public void addCommand(SQLCommand command) {
        sqlCommandsList.add(command);
    }

}
