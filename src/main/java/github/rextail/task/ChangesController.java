package github.rextail.task;

import java.util.*;
import java.util.stream.Collectors;

public class ChangesController {
    private HashMap<String, String> yday; //yesterday
    private HashMap<String, String> tday; //today

    private List<String> deleted = new ArrayList<>();
    private List<String> added = new ArrayList<>();
    private List<String> changed = new ArrayList<>();

    public ChangesController(HashMap<String, String> yday,HashMap<String, String> tday ){
        this.yday = yday;
        this.tday = tday;
        getChanges();
    }

    private void getChanges(){
       Set<String> allKeys = new HashSet<>(yday.keySet());
       allKeys.addAll(tday.keySet());
       for(String key: allKeys){
           if(!tday.containsKey(key)) deleted.add(key);
           else if(!yday.containsKey(key)) added.add(key);
           else if(!Objects.equals(tday.get(key),yday.get(key))) changed.add(key);
       }

    }
    public void printChanges(String fullname){
        System.out.printf("Здравствуйте, дорогая %s%n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n",fullname);
        System.out.printf("Исчезли следующие страницы: %s%n",String.join(",", deleted));
        System.out.printf("Появились следующие новые страницы: %s%n",String.join(",", added));
        System.out.printf("Изменились следующие страницы: %s%n",String.join(",", changed));
    }
    /*Здравствуйте, дорогая и.о. секретаря

    За последние сутки во вверенных Вам сайтах произошли следующие изменения:

    Исчезли следующие страницы:{здесь список урлов}

    Появились следующие новые страницы {здесь список урлов}

    Изменились следующие страницы {здесь список урлов}*/

}
