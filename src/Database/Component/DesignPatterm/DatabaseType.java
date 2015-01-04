/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Component.DesignPatterm;

import Database.Components.DbColumn;
import Database.Components.IDatabaseType;
import Global.AppConfig;
import java.util.ArrayList;

/**
 *
 * @author Alim
 */
public abstract class DatabaseType extends SQLCommand implements IDatabaseType {

    public ArrayList<DbColumn> fieldsList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);
    public ArrayList<ArrayList<String>> valuesList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);

    /**
     *
     */
    public ArrayList<Character> operatorsList;
    public ArrayList<String> joinsList;
    public ArrayList<String> openingFieldsList;
    public ArrayList<Byte> queryTypesList;

    public String LastSQL;

    protected final String SELECT = "SELECT ";
    protected final String FROM = " FROM ";
    protected final String WHERE = " WHERE ";
    protected final String GROUP_BY = " GROUP BY ";
    protected final String ORDER_BY = " ORDER BY ";
    protected final String ASENDING = " ASC ";
    protected final String DESENDING = " DSC ";
    protected final String INSERT = " INSERT ";
    protected final String UPDATE = " UPDATE ";
    protected final String VALUES = " VALUES ";

    @SuppressWarnings("LeakingThisInConstructor")
    public DatabaseType() {
        initialize();
    }

    public void initialize() {
        super.setDatabaseType(this);
    }

}
