// TaskListDaoTestSuite.java
package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList1 = new TaskList("List 1", "Description 1");
        TaskList taskList2 = new TaskList("List 2", "Description 2");
        TaskList taskList3 = new TaskList("List 1", "Description 3");

        taskListDao.save(taskList1);
        taskListDao.save(taskList2);
        taskListDao.save(taskList3);

        // When
        List<TaskList> resultList = taskListDao.findByListName("List 1");

        // Then
        assertEquals(2, resultList.size());

        // Clean-up
        taskListDao.deleteAll();
    }
}
