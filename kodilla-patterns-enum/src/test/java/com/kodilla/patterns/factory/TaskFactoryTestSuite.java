package com.kodilla.patterns.factory;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import com.kodilla.patterns.factory.tasks.TaskType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    TaskFactory taskFactory = new TaskFactory();

    @Test
    void drivingTaskTest() {
        // when
        Task drivingTask = taskFactory.makeNewTask(TaskType.DRIVING);

        // when
        assertEquals("Driving task", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    void paintingTaskTest() {
        // when
        Task paintingTask = taskFactory.makeNewTask(TaskType.PAINTING);

        // when
        assertEquals("Painting task", paintingTask.getTaskName());
        assertFalse(paintingTask.isTaskExecuted());
    }

    @Test
    void shoppingTaskTest() {
        // when
        Task shoppingTask = taskFactory.makeNewTask(TaskType.SHOPPING);

        // when
        assertEquals("Shopping task", shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());
    }
}