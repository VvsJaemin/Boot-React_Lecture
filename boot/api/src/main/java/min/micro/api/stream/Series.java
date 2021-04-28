package min.micro.api.stream;

import java.util.ArrayList;
import java.util.Comparator;

public class Series<T>{
    private ArrayList<T> list;

    public Series(){
        list = new ArrayList<T>();
    }

    public boolean add(T o){
        return list.add(o);
    }

    public void clear(){
        list.clear();
    }

    public boolean contains(T o){
        return list.contains(o);
    }

    public T get(int index){
        return list.get(1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public T remove(int index){
        return list.remove(1);
    }

    public int size(){
        return list.size();
    }

    public void sort(Comparator c){
        list.sort(c);
    }
}
