import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner UserChoose = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.print("\n\n Что вы хотите сделать?" +
                    "\n1: Добавить новый контакт в телефонную книгу" +
                    "\n2: Вывести все контакты" +
                    "\n3: Найти телефон(ы) по имени" +
                    "\n4: Удалить контакт из телефонной книги" +
                    "\n0: Выйти" +
                    "\n\nВаш выбор: ");

            String choose = UserChoose.nextLine();

            if(choose.equals("1")) {
                System.out.print("\nВведите имя: ");
                String name = UserChoose.nextLine();
                System.out.print("Введите номер: ");
                int phoneNum = Integer.parseInt(UserChoose.nextLine());
                phoneBook.AddContact(name, phoneNum);
            }
            else if(choose.equals("2")) System.out.println(PhoneBook.showPhoneBook());
            else if (choose.equals("3")) {
                System.out.print("\nВведите имя для поиска номера: ");
                String name = UserChoose.nextLine();
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList = phoneBook.FindNumber(name);
                System.out.print(arrayList);
            }
            else if(choose.equals("4")) {
                System.out.print("Введите имя контакта, который хотите удалить: ");
                String name = UserChoose.nextLine();
                phoneBook.RemoveContact(name);
            }
            else if (choose.equals("0")) break;


        }



    }
}