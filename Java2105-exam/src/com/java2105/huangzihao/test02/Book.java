package com.java2105.huangzihao.test02;

import java.util.Objects;

/**
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */

public class Book {

    private Integer bookNum;
    private String bookName;
    private Double bookPrice;

    public Book() {
    }

    public Book(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Book(String bookName, Double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public Book(Integer bookNum, String bookName, Double bookPrice) {
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookNum, book.bookNum) && Objects.equals(bookName, book.bookName) && Objects.equals(bookPrice, book.bookPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookNum, bookName, bookPrice);
    }

    @Override
    public String toString() {
        return this.bookNum + "\t" + this.bookName + "\t" + this.bookPrice;
    }
}
