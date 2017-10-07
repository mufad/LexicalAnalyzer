

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class LexicalAnalyzer {


    public static void main(String[] args) throws FileNotFoundException{

        File f = new File("C:\\Users\\Ja\\IdeaProjects\\LexicalAnalyzer\\src\\input.txt");
        Scanner sc = new Scanner(f);
        
        
        String[] keywords = { "abstract", "boolean", "byte", "case",
            "catch", "char", "class", "continue", "default", "do", "double",
            "else", "extends", "final", "finally", "float", "for", "if",
            "implements", "import", "instanceof", "int", "interface", "long",
            "native", "new", "package", "private", "protected", "public",
            "return", "short", "static", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile",
            "while", "false", "true", "null" };
        String[] logicalop= { "<", ">", "!=", "==", ">=", "<=", "&&", "||"};
        String[] mathop= { "+", "-","/", "*", "%", "=" };
         ArrayList<String> fkeywords = new ArrayList<>();
         ArrayList<String> numv = new ArrayList<>();
         ArrayList<String> logop = new ArrayList<>();
         ArrayList<String> matop = new ArrayList<>();
         ArrayList<String> others = new ArrayList<>();  
         ArrayList<String> id = new ArrayList<>(); 
        
        float[] NV= new float[50];
        
        while(sc.hasNextLine())
        {
            String x=sc.nextLine();
            if(x.contains("(") && !others.contains("( )"))
            {
                others.add("( )");
            }
            if(x.contains("{") && !others.contains("{ }"))
            {
                others.add("{ }");
            }
            if(x.contains("[") && !others.contains("[ ]"))
            {
                others.add("[ ]");
            }
            if(x.contains(";") && !others.contains(";"))
            {
                others.add(";");
            }
            
            String []ax= x.split("\\s+|\\,+|\\;+|\\(+|\\)+|\\\"+|\\:+|\\[+|\\]+|\\{+|\\}+");

            for(String c:ax)
            {
                for(int i=0;i<keywords.length;i++)
                {
                    if(keywords[i].equals(c) && !fkeywords.contains(c))
                    {
                        fkeywords.add(c);
                    }
                }
            }
            for(String c:ax)
            {
               char[] ac= c.toCharArray();
               for(int i=0;i<ac.length;i++){
               if(Character.isDigit(ac[i]) && !numv.contains(c))
               {
                   numv.add(c);
               }
                   
                   }
            }
            for(String c:ax)
            {
                for(int i=0;i<logicalop.length;i++)
                {
                    if(logicalop[i].equals(c) && !logop.contains(c))
                    {
                        logop.add(c);
                    }
                }
            }
            for(String c:ax)
            {
                for(int i=0;i<mathop.length;i++)
                {
                    if(mathop[i].equals(c) && !matop.contains(c))
                    {
                        matop.add(c);
                    }
                }
            }
            for(String c:ax)
            {
               
                   if(!matop.contains(c) && !logop.contains(c) && !numv.contains(c) && !others.contains(c) && !fkeywords.contains(c) && !id.contains(c) && !c.equals(""))
                   {
                       id.add(c);
                   }
               
            }
                
        }
        System.out.print("Keywords: ");
        for(String c:fkeywords)
            System.out.print(c+", ");
        System.out.print("\nNumerical Values: ");
        for(String c:numv)
            System.out.print(c+", ");
        System.out.print("\nMathematical Operators: ");
        for(String c:matop)
            System.out.print(c+", ");
        System.out.print("\nLogical Operators: ");
        for(String c:logop)
            System.out.print(c+", ");
        System.out.print("\nOthers: ");
        for(String c:others)
            System.out.print(c+", ");
        System.out.print("\nIdentifiers: ");
        for(String c:id)
            System.out.print(c+", ");
        System.out.println();
    }
    
}
