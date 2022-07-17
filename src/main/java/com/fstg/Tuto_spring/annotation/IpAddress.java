package com.fstg.Tuto_spring.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.xml.bind.annotation.XmlType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IpAddressValidation.class})
public @interface IpAddress {

    String message() default "IP Address invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
