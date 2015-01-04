/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Components;

/**
 *
 * @author Alim
 */
public class DbColumn {

    public String Name;
    public byte Type;
    public long Length = -1;

    public DbColumn(String name) {
        this.Name = name;
    }

    public DbColumn(String name, byte type) {
        this.Name = name;
        this.Type = type;
    }

    public DbColumn(String name, byte type, long length) {
        this.Name = name;
        this.Type = type;
        this.Length = length;
    }
}
