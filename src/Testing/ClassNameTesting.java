/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

class A {

    public void getClsName() {
        System.out.println(getClass().getSimpleName());
        System.out.println(getClass().getClasses().length);
        System.out.println(getClass().getCanonicalName());
    }
}

class B extends A {

}

/**
 *
 * @author Alim
 */
public class ClassNameTesting {

    public static void main(String[] args) {
        B m = new B();
        m.getClsName();
    }
}
