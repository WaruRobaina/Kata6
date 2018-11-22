package kata6;

import java.io.File;
import java.util.Iterator;

public class Kata6 {
    
    public static void main(String[] args) {
        File root = new File("/");
        File[] files = root.listFiles();
        Histogram<Integer> histogram = new Histogram<>(megabytes(lengths(iteratorOf(files))));
    }
    
    private static <T> Iterator<T> iteratorOf (T[] files){
        return new Iterator <T>(){
            int index = 0;
            @Override
            public boolean hasNext(){
                return index < files.length;
            }
            
            @Override
            public T next(){
                return files[index++];
            }
            
        };
    }

    private static Iterator<Long> lengths(Iterator<File> iterator) {
        return new Iterator<Long>(){
            @Override
            public boolean hasNext(){
                return iterator.hasNext();
            }
            
            @Override
            public Long next(){
                return iterator.next().length();
            }
        };
    }
    
    private static Iterator<Integer> megabytes (Iterator<Long> iterator) {
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext(){
                return iterator.hasNext();
            }
            
            @Override
            public Integer next(){
                return (int) (iterator.next()/(1024*1024));
            }
        };
    }
}