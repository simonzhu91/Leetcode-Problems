/**
* Ximeng Zhu 2/8/2016
* CustomCSVParser.java
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

public class CustomCSVParser{
  

  // we assume there is no whitespace in the expression
  public static ArrayList<MyType> customSplitSpecific(String s)
  {
    
      ArrayList<MyType> toRet = new ArrayList<MyType>();
      boolean flag = false;
      int start =0;
      int i;
      for(i=0; i < s.length(); i++)
      {
          if(s.charAt(i)==',' && !flag)
          {

          	// For a Null Time
            if(i == 0 || s.charAt(i-1) == ',')
                toRet.add(new MyType(null));

            // For a String Literal
            else if(i > 0 && s.charAt(i-1) == '"'){
                String str = s.substring(start,i);

                str = str.replaceAll("\"\"", "\"");
                
                toRet.add(new MyType(str));
            }

            // For a Integer
            else{
                toRet.add(new MyType(Integer.parseInt(s.substring(start, i))));
            }

            start = i+1;                
          }   
          else if(s.charAt(i)=='"')
            flag=!flag;
      }

      if(i == 0 || s.charAt(i-1) == ','){
          toRet.add(new MyType(null));
        }
        else if(i > 0 && s.charAt(i-1) == '"'){
          String str = s.substring(start,s.length()-1);

          str = str.replaceAll("\"\"", "\"");

          toRet.add(new MyType(str));
        }
        else{
          toRet.add(new MyType(Integer.parseInt(s.substring(start))));
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
    String s8 = "\"Hello\"\"\"\"World\"\"\"\"Hello\",\"My\"\"Name\", \"Hello\"\"World\"\"Hello\"";
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