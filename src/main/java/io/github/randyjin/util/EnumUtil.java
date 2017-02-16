package io.github.randyjin.util;

import io.github.randyjin.enu.EnumInterface;

/**
 * EnumUtil
 *
 * @author yichao
 * @date 16/8/18
 */
public class EnumUtil {

    /**
     * 通过枚举name查找枚举对象
     *
     * @param enumClass
     * @param name
     * @param <E>
     * @return
     */
	public static <E extends EnumInterface> E findByName(Class<E> enumClass, String name) {
		for (E enumeration : enumClass.getEnumConstants()) {
			if (enumeration.name().equals(name)) {
				return enumeration;
			}
		}
		return getDefault(enumClass);
	}

	/**
	 * 通过枚举code查找枚举对象
	 *
	 * @param enumClass
	 * @param code
	 * @param <E>
	 *            所有继承枚举统一接口 EnumInterface
	 * @return 查找到得枚举对象, 如果查不到将返回null
	 */
	public static <E extends EnumInterface> E findByCode(Class<E> enumClass, Integer code) {
		for (E enumeration : enumClass.getEnumConstants()) {
			if (enumeration.getCode().equals(code)) {
				return enumeration;
			}
		}
		return getDefault(enumClass);
	}

	/**
	 * 通过枚举code查找枚举对象,,不存在不返回default
	 *
	 * @param enumClass
	 * @param code
	 * @param <E>
	 *            所有继承枚举统一接口 EnumInterface
	 * @return 查找到得枚举对象, 如果查不到将返回null
	 */
	public static <E extends EnumInterface> E findByCodeWithoutDefault(Class<E> enumClass, Integer code) {
		for (E enumeration : enumClass.getEnumConstants()) {
			if (enumeration.getCode().equals(code)) {
				return enumeration;
			}
		}
		return null;
	}

    /**
     * 通过枚举desc获取枚举对象
     *
     * @param enumClass
     * @param desc
     * @param <E>
     * @return
     */
	public static <E extends EnumInterface> E findByDesc(Class<E> enumClass, String desc) {
		for (E enumeration : enumClass.getEnumConstants()) {
			if (enumeration.getDesc().equals(desc)) {
				return enumeration;
			}
		}
		return getDefault(enumClass);
	}

	/**
	 * 通过枚举desc获取枚举对象,不存在不返回default
	 *
	 * @param enumClass
	 * @param desc
	 * @param <E>
	 * @return
	 */
	public static <E extends EnumInterface> E findByDescWithoutDefault(Class<E> enumClass, String desc) {
		for (E enumeration : enumClass.getEnumConstants()) {
			if (enumeration.getDesc().equals(desc)) {
				return enumeration;
			}
		}
		return null;
	}

	/**
	 * 获取默认枚举
	 *
	 * @param enumClass
	 * @param <E>
	 * @return
	 */
	public static <E extends EnumInterface> E getDefault(Class<E> enumClass) {
		E defaultEnu = null;
		for(E enumeration : enumClass.getEnumConstants()) {
			if(null != enumeration) {
				defaultEnu = (E)enumeration.getDefault();
				break;
			}
		}
		return defaultEnu;
	}

	/**
	 * 根据code获取desc
	 *
	 * @param enumClass
	 * @param code
	 * @param <E>
	 * @return
	 */
	public static <E extends EnumInterface> String getDescByCode(Class<E> enumClass, int code) {
		String desc = "";
		E e = findByCode(enumClass, code);
		if(null != e) {
			desc = e.getDesc();
		}
		return desc;
	}

	/**
	 * 根据code获取desc,不采用default值
	 *
	 * @param enumClass
	 * @param desc
	 * @param <E>
	 * @return
	 */
	public static <E extends EnumInterface> Integer getCodeByDescWithoutDefault(Class<E> enumClass, String desc) {
		Integer code = null;
		E e = findByDescWithoutDefault(enumClass, desc);
		if(null != e) {
			code = e.getCode();
		}
		return code;
	}

	/**
	 * 根据desc获取code
	 *
	 * @param enumClass
	 * @param desc
	 * @param <E>
	 * @return
	 */
	public static <E extends EnumInterface> Integer getCodeByDesc(Class<E> enumClass, String desc) {
		Integer code = null;
		E e = findByDesc(enumClass, desc);
		if(null != e) {
			code = e.getCode();
		}
		return code;
	}

	/**
	 * 根据desc获取code,不采用default值
	 *
	 * @param e
	 * @return
	 */
	public static String getDescByEnum(EnumInterface e) {
		if(null == e) {
			return null;
		}
		return e.getDesc();
	}

}
