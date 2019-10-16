package jp.co.u_idea2.batch.common.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Size;
import javax.validation.OverridesAttribute;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 指定サイズチェックアノテーション
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
// 0はダミー。内部で置き換える
@Size(min = 0, max = 0)
@ReportAsSingleViolation
@SuppressWarnings("javadoc")
public @interface FixedLength {

    String message() default "{FixedLength.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @OverridesAttribute.List({
        @OverridesAttribute(constraint = Size.class, name = "min"),
        @OverridesAttribute(constraint = Size.class, name = "max")
    })
    int value();

    /**
     * 複数設定用リスト
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FixedLength[] value();
    }

}