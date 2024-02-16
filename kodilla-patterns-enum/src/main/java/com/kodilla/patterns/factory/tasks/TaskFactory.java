package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public Task makeNewTask(TaskType taskType) {
        return switch (taskType) {
            case DRIVING -> new DrivingTask("Driving task", "Work", "Car");
            case SHOPPING -> new ShoppingTask("Shopping task", "Chicken", 15);
            case PAINTING -> new PaintingTask("Painting task", "Blue", "excel");
        };
    }
}