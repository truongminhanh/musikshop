package com.example.musikshop.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Musik {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "musik_id",updatable = false,nullable = false)
    private long musikId;
    private String productname;
    private double price;
    private String genre;
    private String title;
    private String imgpath;

    public Musik(){

    }

    public String getImgPath() {
        System.out.println("Test" + this.imgpath);
        return imgpath;
    }

    public String getImgName(){
        return "images/klangkuenstler.png";
    }

    public void setImgPath(String imgpath) {
        this.imgpath = imgpath;
    }

    public Musik(long musikId, String productname, double price, String genre, String title) {
        this.musikId = musikId;
        this.productname = productname;
        this.price = price;
        this.genre = genre;
        this.title = title;
        this.imgpath = imgpath;
    }

    public long getMusikId() {
        return musikId;
    }

    public void setMusikId(long musikId) {
        this.musikId = musikId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getMusikIdString(){
        return String.valueOf(musikId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musik musik = (Musik) o;
        return musikId == musik.musikId && Double.compare(musik.price, price) == 0 && Objects.equals(productname, musik.productname) && Objects.equals(genre, musik.genre) && Objects.equals(title, musik.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(musikId, productname, price, genre, title);
    }
}
