package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sách: ");
        this.bookName = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        this.author = scanner.nextLine();

        System.out.print("Nhập mô tả sách (ít nhất 10 ký tự): ");
        this.descriptions = scanner.nextLine();

        while (this.descriptions.length() < 10) {
            System.out.print("Mô tả sách phải có ít nhất 10 ký tự. Vui lòng nhập lại: ");
            this.descriptions = scanner.nextLine();
        }

        System.out.print("Nhập giá nhập: ");
        this.importPrice = Double.parseDouble(scanner.nextLine());

        while (this.importPrice <= 0) {
            System.out.print("Giá nhập phải lớn hơn 0. Vui lòng nhập lại: ");
            this.importPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Nhập giá xuất (phải lớn hơn 1.2 lần giá nhập): ");
        this.exportPrice = Double.parseDouble(scanner.nextLine());

        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.print("Giá xuất phải lớn hơn 1.2 lần giá nhập. Vui lòng nhập lại: ");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("Nhập trạng thái sản phẩm (true/false): ");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());

        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("Trạng thái: " + (this.bookStatus ? "Còn hàng" : "Hết hàng"));
    }

}
