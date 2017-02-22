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