package com;

import com.dao.UserDAO;
import com.entity.User;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class UserApp {

    private static Logger logger = Logger.getLogger(UserApp.class.getName());

    public static void main(String[] args) {
        String userInput = ""; // Line read from standard in

        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        String username = "";
        String allInfo = "";

        try {
            while (!(userInput.equals("0"))) {
                System.out.println("1. Создать пользователя");
                System.out.println("2. Найти пользователя");
                System.out.println("3. Удалить пользователя");
                System.out.println("4. Показать всех пользователей");
                System.out.println("0. Выход");

                userInput = in.readLine();

                if ("1".equals(userInput)) {
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        username = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.createUser(username, 14, true);
                        allInfo = "Пользователь создан."+compileInfo(user);
                        System.out.println(allInfo);
                    } catch (Exception e) {
                        System.out.println("Пользователь " + username + " уже существует.");
                    }
                } else if ("2".equals(userInput)) {
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        username = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.retrieveUser( username );
                        allInfo = "Пользователь получен из базы данных. "+compileInfo(user);
                        System.out.println(allInfo);
                    } catch (Exception e) {
                        System.out.println("Пользователь " + username + " не существует.");
                    }
                } else if( "3".equals( userInput ) ){
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        username = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.retrieveUser( username );
                        userDAO.deleteUser( user );
                        System.out.println( "Пользователь " + username + " удален из базы данных.");
                    } catch (Exception e) {
                        System.out.println("Пользователь " + username + " не существует.");
                    }
                } else if( "4".equals( userInput ) ){
                    try{
                        UserDAO userDAO = new UserDAO();
                        List<User> users = userDAO.allUsers();
                        for(User user : users){
                            System.out.println(compileInfo(user));
                        }
                    }catch (Exception e){
                        System.out.println("Не получилось");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static String compileInfo(User user){
        String name = user.getName();
        String age = user.getAge()+"";
        String status = user.isStatus()+"";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String date = dateFormat.format(new Date(user.getDate()));
        return "Имя: " + name + " возраст: " + age+" статус: "+status+" время создания: "+date;
    }
}
