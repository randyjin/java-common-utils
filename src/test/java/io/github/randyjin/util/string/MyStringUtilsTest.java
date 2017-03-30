/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: MyStringUtilsTest.java
 * Author:   奕超
 * Date:    2017/3/30 下午3:04
 * Description:
 */
package io.github.randyjin.util.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * MyStringUtilsTest
 *
 * @author 奕超
 * @date 2017/3/30
 */
public class MyStringUtilsTest {

    @Test
    public void testStrRepeat() {
        String result = MyStringUtils.repeat("j", 5);
        Assert.assertTrue(result.length() == 5);
    }

    @Test
    public void replaceMiddle() {
        String source = "123456789";
        String result = MyStringUtils.replaceMiddle(source, 2,2,"*");
        Assert.assertTrue(result.equals("12*****89"));
    }
    @Test
    public void replaceMiddle1() {
        String source = "123456789";
        String result = MyStringUtils.replaceMiddle(source, 10,2,"*");
        Assert.assertTrue(result.equals("123456789"));
    }
    @Test
    public void replaceMiddle2() {
        String source = "123456789";
        String result = MyStringUtils.replaceMiddle(source, 2,9,"*");
        Assert.assertTrue(result.equals("123456789"));
    }
    @Test
    public void replaceMiddle3() {
        String source = "123456789";
        String result = MyStringUtils.replaceMiddle(source, 0,1,"*");
        Assert.assertTrue(result.equals("********9"));
    }
    @Test
    public void replaceMiddle4() {
        String source = "123456789";
        String result = MyStringUtils.replaceMiddle(source, 1,0,"*");
        Assert.assertTrue(result.equals("1********"));
    }
    @Test
    public void replaceMiddle5() {
        String source = "123456789";
        String result = MyStringUtils.replaceMiddle(source, 0,0,"*");
        Assert.assertTrue(result.equals("*********"));
    }
}
