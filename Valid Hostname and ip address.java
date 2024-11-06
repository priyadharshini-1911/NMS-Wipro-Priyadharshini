import java.util.*;
class Valid Hostname and ip address {
    public static void Main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String host_name=sc.next();
      String ip=sc.next();
      boolean flag=false;
      if(host_name.isEmpty() || !isValidName(host_name))
      {
          System.out.println("ERROR! Enter Valid Hostname.");
         flag=true;
      }
     flag=false;
      if(!isValidIp(ip))
      {
         System.out.println("Enter valid IP in either of the ipv4 or ipv6 format"); 
         flag=true;
      }
      if(flag==false)
      {
          if(isValidIp(ip) && isValidName(host_name))
          System.out.println(host_name +" is connected to "+ip);
      }
      
    }
    public static boolean isValidName(String host_name)
    {
        if(host_name.matches("[A-Za-z0-9.-]+"))
        {
        return true;
        }
        return false;
        
    }
    public static boolean isValidIp(String ip)
    {
        String[] ip_arr=new String[ip.length()-1];
        int op=0;
        for(int i=0;i<ip.length();i++)
        {
            if(ip.charAt(i)=='.')
            {
                ip_arr=ip.split("\\.");
                op=1;
                break;
            }
            if(ip.charAt(i)==':')
            {
                op=2;
                ip_arr=ip.split("\\:");
                break;
            }
        }
        if(op==1)
        {
            if(checkipv4(ip_arr))
            return true;
        }
        if(op==2)
        {
            if(checkipv6(ip_arr))
            return true;
        }
        System.out.println(ip_arr.length);
        
         return false;
    }
  public  static boolean checkipv4(String[] ip_arr)
    {
        if(ip_arr.length!=4)
        return false;
        int num=0;
        try{
            for(String ele:ip_arr)
             num=Integer.parseInt(ele);
        }
        catch(NumberFormatException e)
        {
        return false;
        }
        for(String ele:ip_arr)
        {
             num=Integer.parseInt(ele);
            if(num<0 && num>255)
            return false;
        }
        return true;
    }
    public static boolean checkipv6(String[] ip_arr)
    {
        if(ip_arr.length!=8)
        {
        return false;
        }
        for (String segment : ip_arr) {
            if (!segment.matches("[0-9a-fA-F]+")) {
               
                return false;
            }
        }
return true;
    }
}