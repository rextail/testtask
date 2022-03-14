package github.rextail.task;


import java.util.HashMap;

public class Main {

    static HashMap<String, String> yesterday = new HashMap<>();
    static HashMap<String, String> today = new HashMap<>();

    public static void main(String[] args) {

        filler();
        ChangesController cc = new ChangesController(yesterday,today);
        cc.printChanges("Diana Ivanovna");
    }

    private static void filler(){

        yesterday.put("vk.com","somecode");
        yesterday.put("vk.ru","somecodE");
        yesterday.put("vk.org","someCode");
        yesterday.put("vk.net","sOmEcode");
        yesterday.put("vk.by","somecodeee");

        today.put("vk.com","some");
        today.put("vk.ru","someInterestingCode");
        today.put("vk.net","someChangedCode");
        today.put("vk.ua","some");
    }
}
