package weekFirst.task3;

import java.util.*;

class Good {
    private static Map<String, Integer> goods = new HashMap<>();
    private static Set<Map.Entry<String, Integer>> entries = goods.entrySet();
    private static List<String> list = new ArrayList<>(entries.size());

    Good() {
        goods.put("Молоко", 10);
        goods.put("Хлеб", 25);
        goods.put("Мясо", 100);
        goods.put("Курица", 55);
        goods.put("Бананы", 7);
        goods.put("Апельсины", 4);
        goods.put("Яблоки", 8);
        goods.put("Лемоны", 9);
        goods.put("Вода", 1);
        goods.put("Мороженое", 6);
        goods.put("Сок", 5);
        goods.put("Печенье", 2);
        goods.put("Йогурт", 3);
        goods.put("Джем", 15);
        for (Map.Entry<String, Integer> entry : entries) {
            list.add(entry.getKey()+ " " + entry.getValue());
        }
    }
    static int goodsLength(){
        return goods.size();
    }

    static String getGoods(int number) {
        return  list.get(number);
    }

}
