package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;


public class BookManagement {
    private static final int MAX_BOOKS = 100;
    private static Book[] books = new Book[MAX_BOOKS];
    private static int nextBookIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputBooks(scanner);
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortBooksByProfit();
                    break;
                case 4:
                    deleteBookById(scanner);
                    break;
                case 5:
                    searchBooksByNameOrDescription(scanner);
                    break;
                case 6:
                    updateBookById(scanner);
                    break;
                case 7:
                    System.out.println("Chương trình kết thúc.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void inputBooks(Scanner scanner) {
        System.out.print("Nhập số lượng sách cần thêm mới: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData(scanner);
            books[nextBookIndex] = book;
            nextBookIndex++;
            System.out.println("Sách đã được thêm vào thư viện.");
        }
    }

    private static void displayAllBooks() {
        for (int i = 0; i < nextBookIndex; i++) {
            books[i].displayData();
            System.out.println();
        }
    }

    private static void sortBooksByProfit() {
        for (int i = 0; i < nextBookIndex - 1; i++) {
            for (int j = 0; j < nextBookIndex - i - 1; j++) {
                if (books[j].getInterest() > books[j + 1].getInterest()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

        System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần:");
        displayAllBooks();
    }

    private static void deleteBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nextBookIndex; i++) {
            if (books[i].getBookId() == bookId) {
                for (int j = i; j < nextBookIndex - 1; j++) {
                    books[j] = books[j + 1];
                }
                nextBookIndex--;
                System.out.println("Sách đã được xóa khỏi thư viện.");
                return;
            }
        }

        System.out.println("Không tìm thấy sách có mã " + bookId);
    }

    private static void searchBooksByNameOrDescription(Scanner scanner) {
        System.out.print("Nhập chuỗi tìm kiếm: ");
        String searchQuery = scanner.nextLine().toLowerCase();

        System.out.println("Kết quả tìm kiếm:");

        for (int i = 0; i < nextBookIndex; i++) {
            if (books[i].getBookName().toLowerCase().contains(searchQuery) ||
                    books[i].getDescriptions().toLowerCase().contains(searchQuery)) {
                books[i].displayData();
                System.out.println();
            }
        }
    }

    private static void updateBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần thay đổi thông tin: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nextBookIndex; i++) {
            if (books[i].getBookId() == bookId) {
                books[i].inputData(scanner);
                System.out.println("Thông tin sách đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy sách có mã " + bookId);
    }
}