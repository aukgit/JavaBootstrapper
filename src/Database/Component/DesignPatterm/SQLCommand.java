/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Component.DesignPatterm;

import Database.Components.Annotation.IColumn;
import Database.Components.DbColumn;
import Database.Components.IDbColumnType;
import Database.Components.IQueryType;
import Global.AppConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Alim
 */
public class SQLCommand<TColumn, TValue> {

    DatabaseType db;
    ArrayList<TValue> singleValuesList;
    public 
    
    public ArrayList<TColumn> fieldsList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);

    /**
     *
     */
    public ArrayList<ArrayList<TValue>> valuesList;

    protected SQLCommand() {
        this.valuesList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);

    }

    public SQLCommand(DatabaseType db) {
        this.singleValuesList = new ArrayList<>(AppConfig.NUMBER_COMMAND_INITALIZE);
        this.db = db;
    }

    protected void setDatabaseType(DatabaseType db) {
        this.db = db;
    }

    public SQLCommand where(TColumn column, String operator, TValue... values) {
        return addCommand(column, operator, IQueryType.WHERE_AND, values);
    }

    /**
     * doesn't return new SQLCommand
     *
     * @param columns
     * @return
     */
    public SQLCommand where(TColumn... columns) {
        initalizeColumn(columns.length);
        addItemsToFieldList(columns);
        return db;
    }

    /**
     * doesn't return new SQLCommand
     *
     * @param values
     * @return
     */
    public SQLCommand values(TValue... values) {
        addItemsTotheValueList(values);
        return db;
    }

    public SQLCommand operators(String... values) {
        initalizeValues(values.length);
        
        return db;
    }

    public SQLCommand startsWith(TColumn column, TValue... values) {
        return addCommand(column, null, IQueryType.STARTS_WITH, values);
    }

    public SQLCommand contains(TColumn column, TValue... values) {
        return addCommand(column, null, IQueryType.CONTAINS, values);
    }

    public SQLCommand endsWith(TColumn column, TValue... values) {
        return addCommand(column, null, IQueryType.ENDS_WITH, values);
    }

    public SQLCommand count(TColumn column, TValue... values) {
        return addCommand(column, "=", IQueryType.COUNT, values);
    }

    /**
     * add query and give a new sql command. AND join
     *
     * @param column
     * @param values
     * @return
     */
    public SQLCommand where(TColumn column, TValue... values) {
        return addCommand(column, "=", IQueryType.WHERE_AND, values);
    }

    /**
     * Or join
     *
     * @param column
     * @param values
     * @return
     */
    public SQLCommand whereOR(TColumn column, TValue... values) {

        return addCommand(column, "=", IQueryType.WHERE_OR, values);
    }

    private SQLCommand addCommand(TColumn column, String operator, int typeOfQuery, TValue... values) {
        initalizeColumn(1);
        fieldsList.add(column);
        addItemsTotheValueList(values);
        return db;
    }

    public DbColumn getColumn(Field f) {
        DbColumn col = new DbColumn(f.getName());
        if (f.getType().equals(Double.TYPE) || f.getType().equals(Double.class)) {
            col.Type = IDbColumnType.DOUBLE;
        } else if (f.getType() == Integer.TYPE || f.getType() == Integer.class) {
            col.Type = IDbColumnType.INT;
        } else if (f.getType().equals(Long.TYPE) || f.getType().equals(Long.class)) {
            col.Type = IDbColumnType.LONG;
        } else if (f.getType().equals(Date.class)) {
            col.Type = IDbColumnType.DATE;
        } else if (f.getType().equals(Float.TYPE) || f.getType().equals(Float.class)) {
            col.Type = IDbColumnType.FLOAT;
        } else if (f.getType().equals(Boolean.TYPE) || f.getType().equals(Boolean.class)) {
            col.Type = IDbColumnType.BOOLEAN;
        } else if (f.getType().equals(Short.TYPE) || f.getType().equals(Short.class)) {
            col.Type = IDbColumnType.SHORT;
        } else {
            col.Type = IDbColumnType.STRING;
        }

        if (f.isAnnotationPresent(IColumn.class)) {
            col.Name = f.getAnnotation(IColumn.class).name();
        }
        return col;
    }

    /**
     *
     * @param column
     * @param operator
     * @param typeOfQuery
     * @param values
     * @return
     */
    private SQLCommand addCommand(ArrayList<TColumn> columns, String operator, int typeOfQuery, TValue... values) {

        addItemsToFieldList(columns);
        addItemsTotheValueList(values);

        return db;
    }

    void addItemsToFieldList(TColumn... columns) {
        if (columns != null) {
            for (TColumn column : columns) {
                fieldsList.add(column);
            }
        }
    }

    void addItemsToFieldList(ArrayList<TColumn> columns) {
        if (columns != null) {
            for (TColumn column : columns) {
                fieldsList.add(column);
            }
        }
    }

    void addItemsTotheValueList(TValue... values) {
        if (values != null) {
            initalizeValues(values.length);
            singleValuesList.addAll(Arrays.asList(values));
            valuesList.add(singleValuesList);
        }
    }

    void initalizeColumn(int rows) {
        if (fieldsList == null) {
            fieldsList = new ArrayList<>(rows);
        }
    }

    void initalizeValues(int rows) {
        if (singleValuesList == null) {
            singleValuesList = new ArrayList<>(rows);
        }

        singleValuesList.clear();
    }
}
