/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author thanhld
 */
public class InConstraintValidator implements ConstraintValidator<In, Object> {
    private Object[] values;
    private boolean required;

    @Override
    public final void initialize(final In annotation) {
        values = annotation.values();
        required = annotation.required();
    }

    @Override
    public final boolean isValid(final Object value, final ConstraintValidatorContext context) {
        if (!this.required && null == value) {
            return true;
        }
        String val = String.valueOf(value);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Value not in: " + Arrays.toString(values)).addConstraintViolation();
        return Arrays.asList(values).contains(val);
    }
}
