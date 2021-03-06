/*------------------------------------------------
 *------------------------------------------------
 * ||id     		:   112 0821 042
 * |name   		:   Alim Ul Karim
 * |email  		:   alim.karim.nsu@gmail.com
 * |course 		:   CSE 115.2 
 * |blog   		:   http://bit.ly/auk-blog
 * |linkedin            :   http://linkd.in/alim-ul-karim
 *------------------------------------------------
 *------------------------------------------------
 */
package Database.CommonCodes;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public final class MsgBox implements Icon {

    public JOptionPane Msg = new JOptionPane();
    public ButtonsClass buttons = new ButtonsClass();
    public IconsClass icons = new IconsClass();
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public MsgBox(Component oBaseObject, String Msg) {
        JOptionPane.showMessageDialog(oBaseObject, Msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public MsgBox() {
    }
    
    /**
     *
     * @param oBaseObject
     * @param Msg
     * @param title
     */
    public MsgBox(Component oBaseObject, String Msg, String title) {
        show(oBaseObject, Msg, title);
    }
    
    /**
     *
     * @param oBaseObject
     * @param Msg
     * @param title
     * @param buttonsInt : (use JOptionPane) JOptionPane.YES_NO_CANCEL_OPTION better use my ButtonsClass
     */
    public MsgBox(Component oBaseObject, String Msg, String title, int buttonsInt) {
        JOptionPane.showMessageDialog(oBaseObject, Msg, title, buttonsInt);
    }
    //</editor-fold>

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //<editor-fold defaultstate="collapsed" desc="Icons">
    public int getIconWidth() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int getIconHeight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//</editor-fold>
    
    

    public class IconsClass {

        public final int Error = JOptionPane.ERROR_MESSAGE;
        public final int Information = JOptionPane.INFORMATION_MESSAGE;
        public final int Warning = JOptionPane.WARNING_MESSAGE;
        public final int Question = JOptionPane.QUESTION_MESSAGE;
        public final int Plan = JOptionPane.PLAIN_MESSAGE;
    }

    public class ButtonsClass {

        public final int Yes = JOptionPane.YES_OPTION;
        public final int Default = JOptionPane.DEFAULT_OPTION;
        public final int YesNO = JOptionPane.YES_NO_OPTION;
        public final int YesNoCancel = JOptionPane.YES_NO_CANCEL_OPTION;
        public final int Ok = JOptionPane.OK_OPTION;
        public final int OkCancle = JOptionPane.OK_CANCEL_OPTION;
    }

//    void showError(Exception e, String errorDes, String toString) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
    
    public int show(Component oBaseObject, String Msg) {
        JOptionPane.showMessageDialog(oBaseObject, Msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        return 1;
    }

    public int show(Component oBaseObject, String Msg, String title) {
        System.out.println("ase msg");
        JOptionPane.showMessageDialog(oBaseObject, Msg, title, JOptionPane.INFORMATION_MESSAGE);

        return 1;
    }

    /**
     * 
     * @param oBaseObject
     * @param Msg
     * @param title
     * @param buttonsInt
     * @param iconsInt 
     * @return  
     */
    public int show(Component oBaseObject, String Msg, String title, int buttonsInt, int iconsInt) {
        if (buttonsInt == buttons.OkCancle || buttonsInt == buttons.YesNO || buttonsInt == buttons.YesNoCancel) {
            return JOptionPane.showConfirmDialog(oBaseObject, Msg, title, buttonsInt, iconsInt);
        } else {
            JOptionPane.showMessageDialog(oBaseObject, Msg, title, buttonsInt);
            return 1;
        }
    }

    /**
     *
     * @param oBaseObject
     * @param Msg
     * @param title
     * @return
     */
    public boolean showYesNo(Component oBaseObject, String Msg, String title) {
        int i = JOptionPane.showConfirmDialog(oBaseObject, Msg, title, buttons.YesNO, icons.Question);
        //System.out.println("number" + i);
        return i == 0;
    }

    /**
     *
     * @param oBaseObject
     * @return
     */
    public boolean showYesNoDataBaseFormClose(Component oBaseObject) {
        int i = JOptionPane.showConfirmDialog(oBaseObject, "Do you want to save the changes?", "SaveChanges", buttons.YesNO, icons.Question);
        //System.out.println("number" + i);
        return i == 0;
    }

    public int showYesNoCancel(Component oBaseObject, String Msg, String title) {
        return JOptionPane.showConfirmDialog(oBaseObject, Msg, title, buttons.YesNoCancel, icons.Question);
    }

    public int error(Component oBaseObject, String Msg, String title) {
        return this.showError(oBaseObject, Msg, title);
    }
    
    /**
     * 
     * @param oBaseObject
     * @param Msg     
     * @return 
     */
    public int showError(Component oBaseObject, String Msg) {
        return JOptionPane.showConfirmDialog(oBaseObject, Msg, "Error", buttons.Default, icons.Error);
    }
    /**
     * 
     * @param oBaseObject
     * @param Msg
     * @param title
     * @return 
     */
    public int showError(Component oBaseObject, String Msg, String title) {
        return JOptionPane.showConfirmDialog(oBaseObject, Msg, title, buttons.Default, icons.Error);
    }

    public int showErrorSorryNoDetailsExist(Component oBaseObject) {
        return JOptionPane.showConfirmDialog(oBaseObject, "Sorry! No Details Exist.", "No Details Exist", buttons.Default, icons.Information);
    }

    public boolean isOk() {
        return JOptionPane.OK_OPTION == 1;
    }

    public boolean isCancel() {
        return JOptionPane.CANCEL_OPTION == 1;
    }

    public boolean isClosed() {
        return JOptionPane.CLOSED_OPTION == 1;
    }
}
