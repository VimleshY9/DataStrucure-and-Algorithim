package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(a.isEmpty() && b.isEmpty()){
            return 0;
        }
        if(a.isEmpty()){
            if(b.size()==1) return b.get(0);
            int mi = b.size()/2;
            if(mi%2==0){
                return (b.get(mi)+b.get(mi-1))/2;
            }
            else
                return b.get(mi);
        }
        if(b.isEmpty()){
            if(a.size()==1) return a.get(0);
            int mi = a.size()/2;
            if(mi%2==0){
                return (a.get(mi)+a.get(mi-1))/2;
            }
            else
                return a.get(mi);
        }
        if((a.size()+b.size())==2){
            return (a.get(0)+b.get(0))/2;
        }
        List<Integer> temp = merge(a, b);
        int len = temp.size();
        int m = len/2;
        if(len%2==0){
            return (temp.get(m)+temp.get(m-1))/2;
        }
        else{
            return temp.get(m);
        }
    }

    List<Integer> merge(List<Integer> a, List<Integer> b){
        int p1 = 0;
        int p2 =0;

        List<Integer> temp = new ArrayList();
        while(p1<a.size() && p2<b.size()){
            if(a.get(p1)>b.get(p2)){
                temp.add(b.get(p2));
                p2++;
            }
            else{
                temp.add(a.get(p1));
                p1++;
            }
        }
        while(p1<a.size()){
            temp.add(a.get(p1));
            p1++;
        }
        while(p2<b.size()){
            temp.add(b.get(p2));
            p2++;
        }
        return temp;
    }

    public static void main(String[] args) {
        MedianOfArray m = new MedianOfArray();
        List<Integer> t1 = new ArrayList<>(List.of(-50, -47, -36, -35, 0, 13, 14, 16));
        List<Integer> t2 = new ArrayList<>(List.of(-31,1,9,23,30,39));
        System.out.print(m.findMedianSortedArrays(t1, t2));
    }
}
