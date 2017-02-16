/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: MapUtilsTest.java
 * Author:   奕超
 * Date:    2017/2/16 下午2:50
 * Description:
 */
package io.github.randyjin.util.collection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * MapUtilsTest
 *
 * @author 奕超
 * @date 2017/2/16
 */
public class MapUtilsTest {
	private static Function<Person, String> function = new Function<Person, String>() {
		public String apply(Person person) {
			return person.getIdCard();
		}
	};

	@Test
	public void testListAsHashMapWithNull() {
		Map<String, Person> result = MapUtils.listAsHashMap(null, function);
        Assert.assertTrue(org.apache.commons.collections4.MapUtils.isEmpty(result));
	}

	@Test
	public void testListAsHashMapWithEmptyList() {
        Map<String, Person> result = MapUtils.listAsHashMap(new ArrayList<Person>(), function);
        Assert.assertTrue(org.apache.commons.collections4.MapUtils.isEmpty(result));
	}

	@Test
	public void testListAsHashMap() {
		Map<String, Person> result = MapUtils.listAsHashMap(
		        Lists.newArrayList(new Person("randy", 10, "233203002"), new Person("rand rover", 50, "2332023002")),
		        function);
		Assert.assertTrue(result.get("233203002").getName().equals("randy"));
		Assert.assertTrue(result.get("2332023002").getName().equals("rand rover"));
	}

}
