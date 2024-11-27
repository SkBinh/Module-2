import java.util.TreeMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String text = "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.";
        text = text.toLowerCase().replaceAll("[^a-z\\s ]", "");

        String[] words = text.split("\\s+");

        TreeMap<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
