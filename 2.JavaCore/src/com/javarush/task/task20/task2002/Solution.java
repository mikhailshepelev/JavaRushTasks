package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("File", ".txt",
                    new File("C:\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(new User("Alex", "Black",
                    new Date(), true, User.Country.OTHER));
            javaRush.users.add(new User("Maria", "White",
                    new Date(), false, User.Country.RUSSIA));
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isUsersListPresent = !users.isEmpty() ? "yes" : "no";
            writer.write(isUsersListPresent + "\n");

            if (!users.isEmpty()) {
                for (int i = 0; i < users.size(); i++) {
                    writer.write(users.get(i).getFirstName() + "\n");
                    writer.write(users.get(i).getLastName() + "\n");
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:S");
                    String date = dateFormat.format(users.get(i).getBirthDate());
                    writer.write(date + "\n");
                    String sex = (users.get(i).isMale()) ? "true" : "false";
                    writer.write(sex + "\n");
                    writer.write(users.get(i).getCountry().name() + "\n");
                }
            }
            writer.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersListPresent = reader.readLine();
            if (isUsersListPresent.equals("yes")) {
                String line;
                while ((line = reader.readLine()) != null) {
                    User user = new User();
                    user.setFirstName(line);
                    user.setLastName(reader.readLine());
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:S");
                    Date date = dateFormat.parse(reader.readLine());
                    user.setBirthDate(date);
                    boolean sex = reader.readLine().equals("true");
                    user.setMale(sex);
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
