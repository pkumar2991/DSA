package com.dsa.binarysearch;

public class FindNextCharInSortedCharArray {

    /**
     * Find the next character of char k in the given sorted character array.
     */

    public static void main(String[] args) {
        char[] chArr = {'a','f','g','h'};
        char ch = findNext(chArr,0,chArr.length-1,'a','#');
        System.out.println(ch);
    }

    static char findNext(char[] charArr, int start,int end, char key, char res){
        if(start > end){
            return res;
        }
        int mid = start + (end - start)/2;
        if(charArr[mid] <= key){
            return findNext(charArr,mid+1,end,key,res);
        }else{
            res = charArr[mid];
            return findNext(charArr,start,mid-1,key,res);
        }
    }
}
