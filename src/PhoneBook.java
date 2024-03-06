import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void AddContact(String name, Integer phoneNum){
        ArrayList<Integer> arrayList = phoneBook.get(name);
        if (arrayList == null){
            arrayList = new ArrayList<>();
            phoneBook.put(name, arrayList);
        }
        arrayList.add(phoneNum);

    }
    public static HashMap<String, ArrayList<Integer>> showPhoneBook(){
        return phoneBook;
    }
}
