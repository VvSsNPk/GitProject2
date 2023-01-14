import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class SmallestEquivalentString {
    public static void main(String[] args) {
        String s = "\"cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc\"";
        String o = "\"rjjlkbmnprkslilqmbnlasardrossiogrcboomrbcmgmglsrsj\"";
        String base = "\"bxbwjlbdazfejdsaacsjgrlxqhiddwaeguxhqoupicyzfeupcn\"";
        System.out.println(smallestEquivalentString(s,o,base));

//        HashMap<Integer,TreeSet<Character>> store = new HashMap<>();
//        for(int i = 0; i<s.length();i++){
//            TreeSet<Character> charStore = new TreeSet<>();
//            charStore.add(s.charAt(i));
//            charStore.add(o.charAt(i));
//            store.put(i,charStore);
//        }
//        for(int i = 0; i<store.size();i++){
//            TreeSet<Character> one = new TreeSet<>(store.get(i));
//            for(int j = i+1;j<store.size();j++){
//                TreeSet<Character> two = new TreeSet<>(store.get(j));
//                if(!Collections.disjoint(one,two)){
//                    TreeSet<Character> create = new TreeSet<>();
//                    create.addAll(store.get(i));
//                    create.addAll(store.get(j));
//                    store.put(i,create);
//                    store.put(j,create);
//                }
//            }
//        }
//        for(TreeSet<Character> i : store.values()){
//            System.out.println(i.first());
//        }

    }

    public static String smallestEquivalentString(String s1,String s2,String baseStr){
        HashMap<Integer,TreeSet<Character>> store = new HashMap<>();
        for(int i = 0; i<s1.length();i++){
            TreeSet<Character> charStore = new TreeSet<>();
            charStore.add(s1.charAt(i));
            charStore.add(s2.charAt(i));
            store.put(i,charStore);
        }
        for(int i = 0; i<store.size();i++){
            TreeSet<Character> one = new TreeSet<>(store.get(i));
            for(int j = i+1;j<store.size();j++){
                TreeSet<Character> two = new TreeSet<>(store.get(j));
                if(!Collections.disjoint(one,two)){
                    TreeSet<Character> create = new TreeSet<>();
                    create.addAll(one);
                    create.addAll(two);
                    store.replace(i,create);
                    store.replace(j,create);
                }
            }
        }
        char[] myNameChars = baseStr.toCharArray();
        for(int i = 0; i<myNameChars.length;i++){
            char check = myNameChars[i];
            for(TreeSet<Character> j : store.values()){
                if(j.contains(check)){
                    myNameChars[i] = j.first();
                }
            }
        }
        return String.valueOf(myNameChars);
    }



}
