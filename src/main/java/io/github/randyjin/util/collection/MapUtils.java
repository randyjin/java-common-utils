package io.github.randyjin.util.collection;

import com.google.common.base.Function;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MapUtil
 *
 * @author yichao
 * @date 2016/11/3
 */
public class MapUtils {

    public static <K, V> Map<K, V> listAsHashMap(Collection<V> list, Function<V, K> function) {
        HashMap<K, V> resultMap = new HashMap<K, V>();
        if(CollectionUtils.isEmpty(list)) {
            return resultMap;
        }
        for(V v : list) {
            K key = function.apply(v);
            if(key != null) {
                resultMap.put(key, v);
            }
        }
        return resultMap;
    }
}
