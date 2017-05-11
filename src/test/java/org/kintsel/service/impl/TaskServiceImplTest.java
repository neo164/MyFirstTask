package org.kintsel.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kintsel.service.TaskService;

public class TaskServiceImplTest {

    private TaskService service;

    @Before
    public void setUp() throws Exception {
        service = new TaskServiceImpl();
    }

    @Test
    public void testSortStrings() throws Exception {

        String[] input = {"aaa", "bb", "aaa", "cc", "aaa", "cc"};
        String[] actual = service.sortStrings(input);
        String[] expected = {"aaa", "cc", "bb"}; //nice data
        //String[] expected = {"aaa", "hui", "bb"}; //bad data
        Assert.assertArrayEquals(expected, actual);

    }
}