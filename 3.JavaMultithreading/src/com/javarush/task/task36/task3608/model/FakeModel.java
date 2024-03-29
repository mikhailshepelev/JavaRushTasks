package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.getUsers().add(new User("A", 24L, 2));
        modelData.getUsers().add(new User("B", 28L, 5));
        modelData.getUsers().add(new User("C", 16L, 3));
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
