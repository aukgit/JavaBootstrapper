/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Components;

import Database.Component.DesignPatterm.DatabaseType;
import Database.Component.DesignPatterm.IQueryType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alim
 */
public class SQLCommand implements IQueryType {

    DatabaseType db;
    int queryType;

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
        this.columnsList.add(column);
        return addCommand(this.columnsList, operator, typeOfQuery, values);
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

        this.operator = operator;
        this.queryType = typeOfQuery;
        if (columns != null) {
            this.columnsList = columns;
        }

        if (values != null) {
            initalizeValues(values.length);
            valuesList.addAll(Arrays.asList(values));
        }
        db.addCommand(this);
        return new SQLCommand(db);
    }

    void initalizeColumn(int rows
    ) {
        if (this.columnsList == null) {
            this.columnsList = new ArrayList<>(rows);
        }
    }

    void initalizeValues(int rows
    ) {
        if (this.valuesList == null) {
            this.valuesList = new ArrayList<>(rows);
        }
    }
}
