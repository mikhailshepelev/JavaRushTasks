package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    private List<User> getAllUsers(){
        List<User> list = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(list);
    }

    @Override
    public void loadUsers() {
        List<User> list = getAllUsers();
        modelData.setUsers(list);
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        List<User> list = userService.getAllDeletedUsers();
        modelData.setUsers(list);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        List<User> activeUsers = getAllUsers();
        for(User u : activeUsers) {
            if (u.getId() == user.getId()) {
                modelData.setActiveUser(user);
                break;
            }
        }
    }

    public void deleteUserById(long id) {
        User user = userService.deleteUser(id);
        modelData.setActiveUser(user);
        List<User> list = getAllUsers();
        modelData.setUsers(list);
    }

    public void changeUserData(String name, long id, int level){
        User user = userService.createOrUpdateUser(name, id, level);
        modelData.setActiveUser(user);
        List<User> list = getAllUsers();
        modelData.setUsers(list);
    }
}
