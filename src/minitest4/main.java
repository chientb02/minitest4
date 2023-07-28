package minitest4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoryManager categoryManager = new CategoryManager();
        categoryManager.displayCategory();
        ProductManager productManager = new ProductManager();
        while (true) {
            System.out.println("input choice ");
            System.out.println("1.  display Category ");
            System.out.println("2.  add Category");
            System.out.println("3.  edit Category");
            System.out.println("4.  add Product");
            System.out.println("5.  edit Product");
            System.out.println("6.  display Product with Category");
            System.out.println("7.  display Max and Min Price Product");
            System.out.println("8.  find with name product");
            System.out.println("9.  find with Price product");
            System.out.println("10. display all Products");
            System.out.println("0.  exit ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categoryManager.displayCategory();
                    break;
                case 2:
                    categoryManager.addCategory();
                    break;
                case 3:
                    categoryManager.editCategory();break;
                case 4:
                    productManager.addProduct();break;
                case 5:
                    productManager.editProduct();break;
                case 6:
                    productManager.displayProduct();break;
                case 7:
                    productManager.displayMaxMinPriceProduct();break;
                case 8:
                    productManager.findWithName();break;
                case 9:
                    productManager.findWithPrice();break;
                case 10:
                    productManager.displayAllProduct();break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid selection");
                    break;
            }
        }
    }
}
