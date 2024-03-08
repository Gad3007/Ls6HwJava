import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    public static TreeMap<String, ArrayList<Integer>> sortHashMap(HashMap<String, ArrayList<Integer>> hashMap) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (hashMap.get(o2).size() - hashMap.get(o1).size() == 0) {
                    return 1;
                }
                return hashMap.get(o2).size() - hashMap.get(o1).size();
            }
        };
        TreeMap<String, ArrayList<Integer>> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(hashMap);
        return treeMap;
    }
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    //private static Set<PhoneBook> values = new TreeSet<>();

    // МЕТОД ПО ДОБАВЛЕНИЮ НОВГО КОНТАКТА В HASH ИЛИ ДОБАВЛЕНИЮ ТЕЛЕФОНА К УЖЕ ИМЕЮЩЕМУСЯ
    public void AddContact(String name, Integer phoneNum) {
        ArrayList<Integer> arrayList = phoneBook.get(name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            phoneBook.put(name, arrayList);
        }
        arrayList.add(phoneNum);
    }


    // МЕТОД ПО ПОИСКУ НОМЕРОВ ТЕЛЕФОНОВ ПО ИМЕНИ
    public ArrayList<Integer> FindNumber(String name) {
        ArrayList<Integer> arrayList = phoneBook.get(name);
        if(arrayList == null) {
            arrayList = new ArrayList<>();
            System.out.println("По данному имени нет номеров");
        }

        return arrayList;
    }

    public void RemoveContact(String name) {
        ArrayList<Integer> arrayList = phoneBook.get(name);
        if (arrayList == null) {
            System.out.println("Нет телефонов для удаления");
        }
        else {
            phoneBook.remove(name);
            System.out.println("Телефон по имени " + name + " удален из базы данных");
        }

    }


    // МЕТОД ПО ВЫВОДУ ТЕЛЕФОННОГО СПРАВОЧНИКА
    public static TreeMap<String, ArrayList<Integer>> showPhoneBook() {

        return sortHashMap(phoneBook);
    }


}