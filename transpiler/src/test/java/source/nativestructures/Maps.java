package source.nativestructures;

import static jsweet.util.Lang.$export;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import def.js.Array;

/**
 * This test is executed without any Java runtime.
 */
public class Maps {

	static Array<String> trace = new Array<>();

	static String key1() {
		return "1";
	}

	static String key2() {
		return "a";
	}

	public static void main(String[] args) {
		HashMap<String, String> m = new HashMap<>();

		m.put(key1(), "a");
		m.put("2", "b");

		for(Entry<String, String> e : m.entrySet()) {
			trace.push("" + e.getKey());
			trace.push("" + e.getValue());
		}
		
		trace.push("" + m.size());
		trace.push(m.get("1"));

		trace.push("" + m.containsKey("2"));

		trace.push(m.keySet().toString());

		trace.push("" + m.values());

		Map<String, String> m2 = (Map) m.clone();
		
		m.remove("1");

		trace.push("" + m.size());
		trace.push("" + (m.get("1") == null));
		
		trace.push("size2=" + m2.size());

		trace.push(Collections.singletonMap(key2(), "1").get("a"));
		trace.push(Collections.singletonMap("b", "2").get("b"));

		m.clear();
		trace.push(m.values().toString());
		trace.push("empty=" + m.isEmpty());

		trace.push("-" + m.get("undefinedKey") + "-");
		
		Map<String, String> tm = new TreeMap<>();

		tm.put(key1(), "a");
		tm.put("2", "b");
		
		for(Entry<String, String> e : tm.entrySet()) {
			trace.push("" + e.getKey());
			trace.push("" + e.getValue());
		}
		
		$export("trace", trace.join(","));

	}

}
