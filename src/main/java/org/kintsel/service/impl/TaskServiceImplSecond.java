package org.kintsel.service.impl;
import org.kintsel.service.TaskService;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by Neo_notebook on 27.03.2017.
 */
public class TaskServiceImplSecond implements TaskService {


    @Override
    public String[] sortStrings(String[] data) {
,
        String[] arr = Arrays.stream(data)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue()))
                .System.out.println("Stream: " + streamFromCollection.collect(Collector.toList))
                .arr(System.out::print)
                .toArray(String[]::new);
        return arr;
    }

    @Override
    public String addStrings(String[] data) {

        //String[] arr = Arrays.stream(data) //массив в стрим
        //.reduce((s, s2) -> s + ).orElse();

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
