package minitest4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoryManager {

    ArrayList<Category> categoryList;
    Scanner sc = new Scanner(System.in);

    public CategoryManager() {
        categoryList = readCategory();
    }

    public void addCategory() {
        categoryList = readCategory();
        int index;
        try{
            index = categoryList.get(categoryList.size()-1).getIdCategory();
        } catch (ArrayIndexOutOfBoundsException e) {
            index = 0;
        }
        System.out.println("---input name category---");
        categoryList.add(new Category(index+1,sc.nextLine()));
        System.out.println("--add is success");
        writeCategory(categoryList);
        displayCategory();
    }

    public void displayCategory() {
            categoryList = readCategory();
        if (categoryList.size() > 0) {
            for (Category category :
                    categoryList) {
                System.out.println(category);
            }
        }else {
            System.out.println("--categoryList is null---");
            System.out.println("--Add category for display,please --");
        }
    }
    public void editCategory () {
        displayCategory();
        System.out.println("--Input index Category want to edit--");
        int index = Integer.parseInt(sc.nextLine());
            if (index > 0 && index <= categoryList.size()) {
                System.out.println("input new name Category");
                String newName = sc.nextLine();
                categoryList.get(index - 1).setNameCategory(newName);
                System.out.println("edit is success");
                writeCategory(categoryList);
                displayCategory();
            } else {
                System.out.println("choosing  the  wrong");
            }
    }

    public static void writeCategory(ArrayList<Category> categories) {

        try {
            File file = new File("C:\\Users\\min\\IdeaProjects\\miniTest4-c2\\categoryList.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(categories);
            objectOutputStream.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public static   ArrayList<Category> readCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\min\\IdeaProjects\\miniTest4-c2\\categoryList.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            categories = (ArrayList<Category>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
