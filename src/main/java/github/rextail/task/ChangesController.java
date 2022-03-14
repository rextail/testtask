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

        Set<String> ykeys = yday.keySet();
        Set<String> tkeys = tday.keySet();

        HashSet<String> checker = new HashSet<>();

        //not the fastest but good looking and readable method
        for(String y:ykeys){ //we add all yesterday urls in hashset and check, if it was deleted
            if(!tday.containsKey(y)){
                deleted.add(y);
            }
            checker.add(y);
        }
        for(String t:tkeys){
            if(checker.add(t)){ //if we add it successfully then it's a new url
                added.add(t);
            }
            else{               //this case means this url isn't new
                if(!deleted.contains(t) &&tday.get(t)!= yday.get(t)){ //if dict values are different then code was changed
                    changed.add(t);
                }
            }
        }


    }
    public void printChanges(String fullname){
        System.out.printf("Здравствуйте, дорогая %s%n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:",fullname);
        System.out.printf("Исчезли следующие страницы:%s%n",List.of(deleted).stream().map(String::valueOf).collect(Collectors.joining(",")));
        System.out.printf("Появились следующие новые страницы:%s%n",List.of(added).stream().map(String::valueOf).collect(Collectors.joining(",")));
        System.out.printf("Изменились следующие страницы:%s%n",List.of(changed).stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
    /*Здравствуйте, дорогая и.о. секретаря

    За последние сутки во вверенных Вам сайтах произошли следующие изменения:

    Исчезли следующие страницы:{здесь список урлов}

    Появились следующие новые страницы {здесь список урлов}

    Изменились следующие страницы {здесь список урлов}*/

}
