/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.CommonCodes;

import Common.Codes;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Alim
 */
public class DatabaseTextBinder {

    public static void DbBindTextBoxes(JFrame frame, boolean fieldNamesAppend, boolean read, boolean insert, boolean update) {
        String[] fields = null;
        ArrayList<JTextComponent> list = Codes.getAllTextBox(frame);
        for (JTextComponent textBox : list) {
            //binding property name
            textBox.getAccessibleContext().setAccessibleName("helllo 2");
            String accessName = textBox.getAccessibleContext().getAccessibleName();
            System.out.println(accessName);
        }
//
//        if (read) {
//
//            db.setSpecialQueryFields_(fieldNamesAppend, fields);
//        }

    }
}
