package org.kintsel.service.impl;
import org.kintsel.service.TaskService;
import java.util.*;


public class TaskServiceImpl implements TaskService {


    @Override
    public String[] sortStrings(String[] data) {
        if (data == null || data.length == 0) {
            return new String[0];
        }

        Map<String, Entry> map = new HashMap<>();

         for (String s : data) {
            if (map.containsKey(s)) {
                map.get(s).incrementCount();
            } else {
                map.put(s, new Entry(s));
            }
        }

        List<Entry> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        String[] resultArray = new String[list.size()];
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            Entry entry = list.get(i);
            resultArray[i] = entry.value;
        }
        return resultArray;
    }

    private static class Entry implements Comparable<Entry> {

        private final String value;
        private int count;

        Entry(String value) {
            this.value = value;
            this.count = 1;
        }

        void incrementCount() {
            count += 1;
        }

        public int compareTo(Entry o) {
            return Integer.compare(count, o.count);
        }
    }


    @Override
    public String addStrings(String[] data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            builder.append("[")
                    .append(i + 1)
                    .append("]")
                    .append(".")
                    .append("[")
                    .append(data[i])
                    .append("]");
            if (i + 1 != data.length) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
