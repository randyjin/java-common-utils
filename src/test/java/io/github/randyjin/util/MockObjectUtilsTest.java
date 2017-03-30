/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: MockObjectUtilsTest.java
 * Author:   奕超
 * Date:    2017/3/14 下午9:39
 * Description:
 */
package io.github.randyjin.util;

import io.github.randyjin.util.collection.Person;
import io.github.randyjin.util.collection.Student;
import io.github.randyjin.util.mock.MockObjectUtils;
import org.junit.Test;

/**
 * MockObjectUtilsTest
 *
 * @author 奕超
 * @date 2017/3/14
 */
public class MockObjectUtilsTest {

    @Test
    public void testMockObjectToJson() throws InstantiationException, IllegalAccessException {
        String json = MockObjectUtils.mockObjectToJson(Student.class);
        System.out.println(json);
    }
}
