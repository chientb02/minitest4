package minitest4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    Scanner sc = new Scanner(System.in) ;
    ArrayList <Product> productArrayList = new ArrayList<>();
    CategoryManager categoryManager = new CategoryManager() ;
    public void addProduct () {
        productArrayList = readProduct();
        categoryManager.displayCategory();
        System.out.println("Choice Category");
        int index = Integer.parseInt(sc.nextLine());
        if (index > 0 && index <= categoryManager.categoryList.size()) {
            System.out.println("input new name");
            String nameProduct = sc.nextLine();
            System.out.println("input new Price");
            Double priceProduct = Double.parseDouble(sc.nextLine());
            System.out.println("input new Quantity");
            int newQuantity = Integer.parseInt(sc.nextLine());
            int indexid;
            try{
                indexid = productArrayList.get(productArrayList.size()-1).getId();
            } catch (ArrayIndexOutOfBoundsException e) {
                indexid = 0;
            }
            Product newProduct = new Product(indexid+1,nameProduct, priceProduct, newQuantity, categoryManager.categoryList.get(index - 1));
            productArrayList.add(newProduct);
            writeProduct(productArrayList);
        } else {
            System.out.println("choosing  the  wrong");
        }
    }
    public void displayProduct() {
        categoryManager.displayCategory();
        productArrayList = readProduct();
        System.out.println("input index Category want to display");
        int index = Integer.parseInt(sc.nextLine());
        if (index > 0 && index <= categoryManager.categoryList.size()) {
            for (int i = 0; i < productArrayList.size(); i++) {
                if (productArrayList.get(i).getCategory().getNameCategory().equals(categoryManager.categoryList.get(index - 1).getNameCategory())) {
                    System.out.println(productArrayList.get(i));
                }
            }
        } else {
            System.out.println("choosing  the  wrong");
        }
    }
    public void editProduct() {
        productArrayList = readProduct();
        categoryManager.displayCategory();
        System.out.println("Choice Category want to edit");
        int index = Integer.parseInt(sc.nextLine());
        if (index > 0 && index <= categoryManager.categoryList.size()) {
            for (int i = 0; i < productArrayList.size(); i++) {
                if (productArrayList.get(i).getCategory().getNameCategory().equals(categoryManager.categoryList.get(index - 1).getNameCategory())) {
                    System.out.println(productArrayList.get(i));
                }
            }
            System.out.println("input name product want to edit");
            String nameEdit = sc.nextLine();
            for (int i = 0; i < productArrayList.size(); i++) {
                if (productArrayList.get(i).getCategory().getNameCategory().equals(categoryManager.categoryList.get(index - 1).getNameCategory()) && productArrayList.get(i).getName().equals(nameEdit)) {
                    System.out.println("input new name");
                    productArrayList.get(i).setName(sc.nextLine());
                    System.out.println("input new price");
                    productArrayList.get(i).setPrice(Double.parseDouble(sc.nextLine()));
                    System.out.println("input new quantity");
                    productArrayList.get(i).setQuantity(Integer.parseInt(sc.nextLine()));
                    writeProduct(productArrayList);
                    System.out.println("edit is success");
                }
            }
        } else {
            System.out.println("choosing  the  wrong");
        }
    }
    public void displayMaxMinPriceProduct() {
        productArrayList = readProduct();
        double maxPrice = productArrayList.get(0).getPrice();
        double minPrice = maxPrice;
        int maxIndex = 0 ;
        int minIndex = maxIndex ;

        for (int i = 1; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getPrice() > maxPrice) {
                maxPrice = productArrayList.get(i).getPrice();
                maxIndex = i ;
            }
            if (productArrayList.get(i).getPrice() < minPrice) {
                minPrice = productArrayList.get(i).getPrice();
                minIndex = i ;
            }
        }
        System.out.println("Product max price is : " + productArrayList.get(maxIndex));
        System.out.println("Product min price is : " + productArrayList.get(minIndex));
    }

    public void findWithName() {
        productArrayList = readProduct();
        System.out.println("Input name ");
        String nameFind = sc.nextLine();
        boolean flag = true ;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getName().equals(nameFind)) {
                System.out.println(productArrayList.get(i));
                flag = false ;
            }
        }
        if (flag){
            System.out.println("this name input is not available");
        }
    }

    public void findWithPrice() {
        productArrayList = readProduct();
        System.out.println("Input Price");
        double priceFind = Double.parseDouble(sc.nextLine());
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getPrice() < priceFind) {
                System.out.println(productArrayList.get(i));
            }
        }
    }
    public void displayAllProduct() {
        productArrayList = readProduct();
        for (Product product :
                productArrayList) {
            System.out.println(product);
        }
    }
    public static void writeProduct(ArrayList<Product> categories) {
        try {
            File file = new File("Product.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(categories);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static   ArrayList<Product> readProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            File file = new File("Product.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (ArrayList<Product>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }
        return products;
    }
}
