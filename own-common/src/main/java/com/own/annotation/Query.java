package com.own.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类功能说明:
 *
 * 类修改者	创建日期2020/7/25
 * 修改说明
 * @author wzy
 * @version V1.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {
    /**
     *  基本对象的属性名
     * @return
     */
    String propName() default "";

    /**
     * 查询方式
     * @return
     */
    Type type() default Type.EQUAL;

    /**
     * 连接查询的属性名，如User类中的dept
     */
    String joinName() default "";

    /**
     * 默认左连接
     */
    Join join() default Join.LEFT;

    /**
     * 多字段模糊搜索，仅支持String类型字段，多个用逗号隔开, 如@Query(blurry = "email,username")
     */
    String blurry() default "";

    enum Type {
        // jie 2019/6/4 相等
        EQUAL
        //  大于等于
        , GREATER_THAN
        // 小于等于
        , LESS_THAN
        //  中模糊查询
        , INNER_LIKE
        //  左模糊查询
        , LEFT_LIKE
        // 右模糊查询
        , RIGHT_LIKE
        //  小于
        , LESS_THAN_NQ
        // jie 2019/6/4 包含
        , IN
        // 不等于
        ,NOT_EQUAL
        // between
        ,BETWEEN
        // 不为空
        ,NOT_NULL
        // 为空
        ,IS_NULL
    }
    /**
     * 适用于简单连接查询，复杂的请自定义该注解，或者使用sql查询
     */
    enum Join {
        /** jie 2019-6-4 13:18:30 */
        LEFT, RIGHT, INNER
    }
}