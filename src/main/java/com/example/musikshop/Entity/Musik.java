package com.example.musikshop.Entity;

import java.util.Objects;

public class Musik {

    private long musikId;
    private String productname;
    private double price;
    private String genre;
    private String Title;

    public Musik(long musikId, String productname, double price, String genre, String title) {
        this.musikId = musikId;
        this.productname = productname;
        this.price = price;
        this.genre = genre;
        Title = title;
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
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musik musik = (Musik) o;
        return musikId == musik.musikId && Double.compare(musik.price, price) == 0 && Objects.equals(productname, musik.productname) && Objects.equals(genre, musik.genre) && Objects.equals(Title, musik.Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(musikId, productname, price, genre, Title);
    }
}
