package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View{
    private Controller controller;


    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }


    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    @Override
    public void refresh(ModelData modelData) {
        //Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
        //в зависимости от того, какие пользователи находятся в списке.
        //Добавь в необходимые методы модели изменение displayDeletedUserList.
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }

        for (User user : modelData.getUsers())
            System.out.println("\t" + user);
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
