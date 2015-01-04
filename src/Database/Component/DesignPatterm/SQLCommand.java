/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Component.DesignPatterm;

import Database.Component.DesignPatterm.DatabaseType;
import Database.Components.Annotation.IColumn;
import Database.Components.DbColumn;
import Database.Components.IDbColumnType;
import Database.Components.IQueryType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Alim
 */
public class SQLCommand implements IQueryType {

    DatabaseType db;
    int queryType;
    ArrayList<String> valuesList;

    protected SQLCommand() {

    }

    public SQLCommand(DatabaseType db) {
        this.db = db;
    }

    protected void setDatabaseType(DatabaseType db) {
        this.db = db;
    }

    public SQLCommand where(Field column, String operator, String... values) {
        return addCommand(column, operator, IQueryType.WHERE_AND, values);
    }

    /**
     * doesn't return new SQLCommand
     *
     * @param columns
     * @return
     */
    public SQLCommand where(Field... columns) {
        initalizeColumn(columns.length);
        db.fieldsList.addAll(Arrays.asList(columns));
        return this;
    }

    /**
     * doesn't return new SQLCommand
     *
     * @param values
     * @return
     */
    public SQLCommand values(String... values) {
        initalizeValues(values.length);
        db.valuesList.addAll(Arrays.asList(values));
        return this;
    }

    public SQLCommand operators(String... values) {
        initalizeValues(values.length);
        this.valuesList.addAll(Arrays.asList(values));
        return this;
    }

    public SQLCommand startsWith(Field column, String... values) {
        return addCommand(column, "=", IQueryType.STARTS_WITH, values);
    }

    public SQLCommand contains(Field column, String... values) {
        return addCommand(column, "=", IQueryType.CONTAINS, values);
    }

    public SQLCommand endsWith(Field column, String... values) {
        return addCommand(column, "=", IQueryType.ENDS_WITH, values);
    }

    public SQLCommand count(Field column, String... values) {
        return addCommand(column, "=", IQueryType.COUNT, values);
    }

    /**
     * add query and give a new sql command. AND join
     *
     * @param column
     * @param values
     * @return
     */
    public SQLCommand where(Field column, String... values) {
        return addCommand(column, "=", IQueryType.WHERE_AND, values);
    }

    /**
     * Or join
     *
     * @param column
     * @param values
     * @return
     */
    public SQLCommand whereOR(Field column, String... values) {

        return addCommand(column, "=", IQueryType.WHERE_OR, values);
    }

    private SQLCommand addCommand(Field column, String operator, int typeOfQuery, String... values) {
        initalizeColumn(1);
        db.fieldsList.add(column);
        return addCommand(db.fieldsList, operator, typeOfQuery, values);
    }

    public DbColumn getColumn(Field f) {
        DbColumn col = new DbColumn();
        col.Name = f.getName();
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
    private SQLCommand addCommand(ArrayList<Field> columns, String operator, int typeOfQuery, String... values) {

        this.queryType = typeOfQuery;
        if (columns != null) {
            for (Field column : columns) {
                DbColumn col = getColumn(column);
                db.fieldsList.add(column)
            }
        }
        addItemsTotheValueList(values);
        db.addCommand(this);
        return this;
    }

    void addItemsTotheValueList(String... values) {
        if (values != null) {
            initalizeValues(values.length);
            valuesList.addAll(Arrays.asList(values));
            db.valuesList.add(valuesList);
        }
    }

    void initalizeColumn(int rows) {
        if (db.fieldsList == null) {
            db.fieldsList = new ArrayList<>(rows);
        }
    }

    void initalizeValues(int rows) {
        if (valuesList == null) {
            valuesList = new ArrayList<>(rows);
        }

        valuesList.clear();
    }
}
