package io.github.randyjin.enu;

/**
 * Created by aguda on 16/8/29.
 * 枚举接口
 */
public interface EnumInterface<T extends EnumInterface> {

    String getDesc();

    Integer getCode();

    String name();

    T getDefault();
}
