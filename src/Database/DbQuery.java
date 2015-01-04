/*------------------------------------------------
 *------------------------------------------------
 * ||id     		:   112 0821 042
 * |name   		:   Alim Ul Karim
 * |email  		:   alim.karim.nsu@gmail.com
 * |blog   		:   http://bit.ly/auk-blog
 * |linkedin            :   http://linkd.in/alim-ul-karim
 * |First Written       :   2011
 * |Start Writing       :   04 January, 2015
 *------------------------------------------------
 *------------------------------------------------
 */
/**
 * Currently not SQL injection protected , future version it will be.
 */
package Database;

//<editor-fold defaultstate="collapsed" desc="imports">
import Database.Attributes.DbAttribute;
import Database.CommonCodes.DbInitalizer;
import Database.CommonCodes.StringMore;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//</editor-fold>

public final class DbQuery extends DbInitalizer {

    StringMore strMore = new StringMore();

    // <editor-fold defaultstate="collapsed" desc="Intializers & Configarations">
    //<editor-fold defaultstate="collapsed" desc="Constants">
    //</editor-fold>
    private SimpleDateFormat simpleDateFormatter;

    //Configaration
    private String url;

    private String user = DATABASE_USER,
            password = DATABASE_USER_PASSWORD;

    private Connection cnn;
    private Statement stmt, tempStatement;
    private ResultSet rs;

    private int queryStartLimit;
    private int queryEndLimit;
    private int rowCountValueCached = -1;
    private boolean isCleanUpNecessaryWhenQueryDone = true;

    //<editor-fold defaultstate="collapsed" desc="Entity Required fields">
    private String tableAlias = "f";

    //New fields for Enity
    private String FieldDataTypes[] = null; //keeps all data column datatypes
    private int SelectedColumnsIndexes[] = null; //index that the columns are exist in database
    private String tempAllColumnNames[] = null; //get all column names uing columnNames() method
    private String FieldsWithLinks[] = null;
    private String Operators[] = null; // =,>=,<= etc...
    private String previoursTableName = "";
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SQL strings">
    private String selectSQL, updateSQL, deleteSQL, createSQL;
    public String LastSQL; //last executed SQL Query
    private static final String SQL_COUNT = "SELECT Count(*) AS COUNT FROM ";
    private String _showDbColumnsSQL = "SHOW COLUMNS FROM ";

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Table">
    /**
     * table
     */
    private String _tableName = "";
    private String openFieldsName = "*";
    private String[] _tableColumnsGlobal = null;
    //</editor-fold>

    public DbAttribute dbAttr;

    //Boleans
    /**
     * make sure if we need to look for complex queries than equals
     */
    private Boolean queryTypeInitalized = false;
    // default value to initalize lists
    private int defaultListCreatingNumber = 30;
    //<editor-fold defaultstate="collapsed" desc="Arrays">
    //Arrays
    private ArrayList<String> queryFieldNames;
    private ArrayList<String> queryValues;
    private ArrayList<String> joiningArray = null;
    private ArrayList<Integer> queryTypes;
    private ArrayList<String> updateFields;
    private ArrayList<String> updateFieldsValues;
    private ArrayList<String> createFields;
    private ArrayList<String> createFieldsValues;
    //</editor-fold>
    private String createFieldsString = "";
    private String createFieldsValuesString = "";

}