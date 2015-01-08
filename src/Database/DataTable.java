/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Alim
 */

public class DataTable {
    protected String tableName;

    /**
     * @return the tableName
     */
    public String getTableName() {
        if(tableName == null){
            setTableName(getClass().getSimpleName());
        }
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
}
