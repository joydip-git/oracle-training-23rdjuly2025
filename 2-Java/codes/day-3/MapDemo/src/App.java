import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class App {

	static Map<String, Integer> findWordFrequency(String sentence) throws Exception {
		if (sentence != null && !sentence.isEmpty()) {
			String[] words = sentence.split("\\W+");
			Map<String, Integer> wordCount = new TreeMap<String, Integer>();

			if (words != null && words.length > 0) {
				for (String word : words) {
					if (wordCount.containsKey(word.toLowerCase())) {
						int count = wordCount.get(word.toLowerCase());
						wordCount.replace(word.toLowerCase(), count + 1);
					} else {
						wordCount.put(word.toLowerCase(), 1);
					}
				}
			}
			return wordCount;
		} else
			throw new Exception("the sentence is invalid");
	}

	public static void main(String[] args) {

		try {
			String str = "I work for Oracle. Oracle has the division OFSAA.";
			Map<String, Integer> result = findWordFrequency(str);
			for (Map.Entry<String, Integer> entry : result.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void useMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Oracle");
		map.put(0, "Belandur");
		map.put(2, "Bangalore");

		// map.get(1);
		map.replace(2, "Bengaluru");

		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
