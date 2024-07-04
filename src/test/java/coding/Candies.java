package coding;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Candies {
    @Test
    public void test0() {
        int[] candies = {2,3,5,1,3};//5,6,8,4,6
               int extraCandies = 3;
        Assert.assertEquals(kidsWithCandies(candies, extraCandies),List.of(true,true,true,false,true));
    }
    @Test
    public void test1(){
        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        Assert.assertEquals(kidsWithCandies(candies, extraCandies), List.of(true,false,false,false,false));
    }
    @Test
    public void test2(){
        int[] candies = {12,1,12};//22, 11, 22
        int extraCandies = 10;
        Assert.assertEquals(kidsWithCandies(candies, extraCandies), List.of(true,false,true));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        for(int i=0;i<candies.length;i++){
            candies[i] = candies[i]+extraCandies;
        }
        List<Boolean> extraCandiesArr = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            boolean val=false;
            for(int j=0;j<candies.length;j++){
                if(candies[i]>candies[j]){
                    val = true;
                }
                else{
                    val=false;
                }
            }
            extraCandiesArr.add(val);
        }
        return extraCandiesArr;
    }
}
