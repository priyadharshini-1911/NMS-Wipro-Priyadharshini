import java.util.*;
class Multiple and empty Placeholder{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,String> map=new HashMap<>();
        System.out.println("Enter template String: ");
        String temp=sc.nextLine();
        String[] arr=temp.split("\\s+");
       // System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].charAt(0)=='{')
            {
              map.put(i,arr[i]);  
            }
        }
       // System.out.println(map);
        for(Map.Entry entry:map.entrySet())
        {
            System.out.println("Enter palceholder for "+entry.getValue());
            String s=sc.next();
            if(s.equals("done"))
            break;
            map.put((int)entry.getKey(),s);
        }
       // System.out.println(map);
        int n;
        String s2;
        int flag=0;
        for(Map.Entry entry:map.entrySet())
        {
            n=(int)entry.getKey();
            s2=(String)entry.getValue();
            if(!arr[n].equals(s2))
             arr[n]=s2;
             else
             {
             System.out.println("Error placeholder for "+entry.getValue()+" not given.");
             flag=1;
             }
        }
        
        String s3="";
        for(String name:arr)
        s3+=name+" ";
        System.out.println(s3);
        
    }
}