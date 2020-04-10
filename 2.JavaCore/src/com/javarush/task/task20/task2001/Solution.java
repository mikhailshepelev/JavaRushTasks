package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file = File.createTempFile("TempFile", ".txt", new File("C:\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001"));
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(name + "\n");

            String isAssetPresent = !assets.isEmpty() ? "yes" : "no";
            writer.write(isAssetPresent + "\n");

            if (!assets.isEmpty()) {
                for (int i = 0; i < assets.size(); i++) {
                    writer.write(assets.get(i).getName() + " " + assets.get(i).getPrice() + "\n");
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String name = reader.readLine();
            this.name = name;

            String isAssetPresent = reader.readLine();
            if (isAssetPresent.equals("yes")) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] asset = line.split("\\s");
                    this.assets.add(new Asset(asset[0], Double.parseDouble(asset[1])));
                }
            }
            //implement this method - реализуйте этот метод
        }
    }
}
