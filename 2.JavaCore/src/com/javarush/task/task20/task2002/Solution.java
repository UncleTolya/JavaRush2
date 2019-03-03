package com.javarush.task.task20.task2002;

import java.io.*;
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
//            File yourFile = File.createTempFile("your_file_name", null);
            String your_file_name = "/Users/mhlv/Documents/test3";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Name");
            user.setLastName("LastName");
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
//            for (User user1 : loadedObject.users) {
//                System.out.println(user1.getFirstName());
//                System.out.println(user1.getLastName());
//                System.out.println(user1.getBirthDate());
//                System.out.println(user1.isMale());
//                System.out.println(user1.getCountry());
//            }
//            System.out.println();
//            for (User user1 : javaRush.users) {
//                System.out.println(user1.getFirstName());
//                System.out.println(user1.getLastName());
//                System.out.println(user1.getBirthDate());
//                System.out.println(user1.isMale());
//                System.out.println(user1.getCountry());
//            }
//            System.out.println();
            System.out.println(loadedObject.equals(javaRush));

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
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (users != null && !users.isEmpty()) {
                for (User user : users) {
                    if (user.getFirstName() != null) pw.write(user.getFirstName() + "\n");
                    else pw.write(null + "\n");
                    if (user.getLastName() != null) pw.write(user.getLastName() + "\n");
                    else pw.write(null + "\n");
                    if (user.getBirthDate() != null) pw.write(user.getBirthDate().getTime() + "\n");
                    else pw.write(null + "\n");
                    pw.write(user.isMale() + "\n");
                    //// видисо тут
                    if (user.getCountry() != null) pw.write(user.getCountry() + "\n");
                    else pw.write(null + "\n");
                }
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            User user = null;
            while (br.ready()) {
                user = new User();
                try {
                    if (br.ready())  {
                        String firstName = br.readLine();
                        if (firstName.equals("null")) user.setFirstName(null);
                        else user.setFirstName(firstName);
                    } else break;
                    if (br.ready()) {
                        String lastName = br.readLine();
                        if (lastName.equals("null")) user.setLastName(null);
                        else user.setLastName(lastName);
                    } else break;
                    if (br.ready())  {
                        String date = br.readLine();
                        if (date.equals("null")) user.setBirthDate(null);
                        else user.setBirthDate(new Date(Long.parseLong(date)));
                    } else break;
                    if (br.ready())  {
                        user.setMale(Boolean.parseBoolean(br.readLine()));
                    } else break;
                    if (br.ready()) {
                        String county = br.readLine();
                        if (county.equals("null")) user.setCountry(null);
                        else user.setCountry(User.Country.valueOf(county));
                    } else break;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
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
