/**
* Ximeng Zhu 2/8/2016
* CustomCSVParser2.java
*/

import java.util.*;

class MyType{
  String s;
  int val;

  public MyType(String s){
    this.s = s;
    val = -1;
  }

  public MyType(int v){
    val = v;
    s = null;
  }
}

public class CustomCSVParser2{
  
  public static int jump(String s){
    if(s.startsWith("\"\""))
       return 2;
    return 1;
  }
  public static boolean isEnd(String s) {
    if(s.startsWith("\"\"")) return false;
    if(s.charAt(0) == '"') return true;
    return false;
  }
  public static String first2(int index,String complete) {
    String s = complete.substring(index);
    if(s.length() < 1) return "";
    if(s.length() == 1) return s;
    return s.substring(0,2);
  }
  public static String clean(String s){
    return s.replaceAll("\"\"", "\"");
  }  
  public static ArrayList<MyType> customSplitSpecific(String s)
  {
 
    ArrayList<MyType> toRet = new ArrayList<MyType>();
    
    int i = 0;
    int len = s.length();
    boolean flag = true;
    while(i < len){
      if(s.charAt(i) == '"') {
        int start = i;
        int end = i+1;
        while(!isEnd(first2(end,s))){
          end += jump(first2(end,s));
        }
        MyType newType = new MyType(clean(s.substring(start,end+1)));
        toRet.add(newType);
        i = end + 1;
        if(i < len && s.charAt(i) == ',') {
          flag = true;
          i++;
        }else{
          flag = false;
        }
      }else if(i < len && s.charAt(i) != ','){
        int start = i;
        int end = start;
        while(end < len && s.charAt(end) != ',') end++;
        toRet.add(new MyType(Integer.parseInt(s.substring(start, end))));
        i = end;
        if(i < len && s.charAt(i) == ',') {
          flag = true;
          i++;
        }else{
          flag = false;
        }
      }else{
        // NULL Case
        toRet.add(new MyType(null));
        if(i < len && s.charAt(i) == ',') {
          flag = true;
        }else{
          flag = false;
        }
        i++;
      }
    }
    if(flag) {
      toRet.add(new MyType(null));
    }
    return toRet;
  }   

  public static void main(String [] args){
    
    System.out.println();
    System.out.println("Test Case #1: \"Simon\",10,,");
    String s1 = "\"Simon\",10,,";
    List<MyType> list = customSplitSpecific(s1);

    for(MyType m : list){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #2: ,");
    String s2 = ",";
    List<MyType> list2 = customSplitSpecific(s2);

    for(MyType m : list2){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #3: \"Hello\"\"World\"");
    String s3 = "\"Hello\"\"World\"";
    List<MyType> list3 = customSplitSpecific(s3);

    for(MyType m : list3){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #4: \"Hello\"\"World\",\"My\"\"Name\"");
    String s4 = "\"Hello\"\"World\",\"My\"\"Name\"";
    List<MyType> list4 = customSplitSpecific(s4);

    for(MyType m : list4){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #5: ,,,");
    String s5 = ",,,";
    List<MyType> list5 = customSplitSpecific(s5);

    for(MyType m : list5){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #6: \"\"");
    String s6 = "";
    List<MyType> list6 = customSplitSpecific(s6);

    for(MyType m : list6){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #7: \"Simon, Zhu\",-15,20,\"Simon\"");
    String s7 = "\"Simon, Zhu\",-15,20,\"Simon\"";
    List<MyType> list7 = customSplitSpecific(s7);

    for(MyType m : list7){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }

    System.out.println();
    System.out.println("Test Case #8: \"Hello\"\"\"\"World\"\"\"\"Hello\",\"My\"\"Name\", \"Hello\"\"World\"\"Hello\"");
    String s8 = "\"Hello\"\"\"\"World\"\"\"\"Hello\",\"My\"\"Name\",\"Hello\"\"World\"\"Hello\"";
    List<MyType> list8 = customSplitSpecific(s8);
    System.out.println();

    for(MyType m : list8){
      if(m.val == -1){
        System.out.println(m.s);
      }else{
        System.out.println(m.val);
      }
    }


  }
}