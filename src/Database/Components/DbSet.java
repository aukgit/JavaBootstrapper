/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Components;

import Database.Component.DesignPatterm.DatabaseType;

/**
 *
 * @author Alim
 */
public abstract class DbSet<T> extends DatabaseType {

    DatabaseType db;
    

    public DbSet(DatabaseType db) {
        this.db = db;
    }
}
