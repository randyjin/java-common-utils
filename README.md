# java-common-utils
## ExcelParser(兼容office excel两个版本)
* 解析excel文件,提供Api:
  * 读取全部内容
  * 读取指定行

## MapUtils(Map相关的操作)
* 将Collection转成Map

## EnumUtils(枚举操作类)
* 定义的枚举实现EnumInterface接口,EnumUtils就可以进行操作了
* 提供各种枚举操作
* 局限性:这里枚举只有最常用的`int code`和`String desc`两个属性;如果有其他的需求可以丰富EnumInterface和EnumUtils

## MyStringUtil(个性化String操作)
* 替换操作,指定前面留几个字符,后面留几个字符,指定替换操作