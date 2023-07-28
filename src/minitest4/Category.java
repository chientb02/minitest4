package minitest4;

import java.io.Serializable;

public class Category  implements Serializable{
         private static final long serialVersionUID = -3389363800876569458L;
        private int idCategory ;
        private String nameCategory ;


    public Category() {
    }


    public Category(int idCategory, String nameCategory ) {
        this.nameCategory = nameCategory;

        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }


    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
