/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Components.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Alim
 */
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IColumn {

    public String name() default "";

    public boolean unique() default false;

    public boolean nullable() default false;

    public boolean insertable() default true;

    public boolean updatable() default true;

    public String columnDefinition() default "";

    public int min() default 0;
    
    public int max() default 255;

    public int precision() default 0;

    public int scale() default 0;
    
    public boolean isKey() default false;
}
