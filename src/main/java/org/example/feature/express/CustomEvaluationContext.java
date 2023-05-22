package org.example.feature.express;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.TypeConverter;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class CustomEvaluationContext extends StandardEvaluationContext {

    private IntPredicate intPredicate;

    public CustomEvaluationContext(IntPredicate intPredicate) {
        this.intPredicate = intPredicate;
    }

    @Override
    public TypeConverter getTypeConverter() {
        return new TypeConverter() {

            @Override
            public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
                if(sourceType.getType() == targetType.getType()){
                    return true;
                }

                return false;
//                return sourceType.getType() == Integer.class && targetType.getType() == Boolean.class;
            }

            @Override
            public Object convertValue(Object value, TypeDescriptor sourceType, TypeDescriptor targetType) {
                if(sourceType.getType() == targetType.getType()){
                    return value;
                }
                if (sourceType.getType() != Integer.class || targetType.getType() != Boolean.class) {
                    return null;
                }

                return intPredicate.test((Integer) value);
            }
        };
    }
}
