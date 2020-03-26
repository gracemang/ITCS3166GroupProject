/*
ITCS-3166 Group Project
Group 7
IP Router Function
Authors: Will McCurry, Alex McNeely, Calvin Moore, Grace Mang, Tommy McCullough
* */

import java.util.Scanner;
public class Router {
    public static void main(String argv[])
    {

        Scanner scanner = new Scanner(System.in);
        int table_size;

        String IP_Address;
        System.out.print("Enter IP_Address to search:");
        IP_Address = scanner.nextLine();//Address to route


        System.out.print("Enter table size :");
        table_size=scanner.nextInt();
        String enter;
        System.out.println("Press enter to proceed: ");
        enter = scanner.nextLine();
        String routing[]=new String[table_size];

        System.out.println("Enter Given Table:");
        System.out.println("Address/mask Next hop");

        for(int i=0;i<table_size;i++) //
        {
            routing[i]=scanner.nextLine();
        }

        String IP_Address_split[];

        IP_Address_split = IP_Address.split("[.]"); //Split IPAddress

        String table_split[][] = new String[table_size][];

        for(int i=0;i<table_size;i++)
        {
            table_split[i] = routing[i].split("[./ ]"); //Split Address/Mask
        }

        int i; //Initialize i for finding route
        for(i=0;i<table_size-1;i++)
        {
            int temp = Integer.parseInt(table_split[i][table_size]);
            int default_r[]={0,0,0,0};
            int list=7,count=0;
            while(temp>0)
            {
                if(list==0)
                {
                    default_r[count]=default_r[count]+1;
                    count++;
                    list=7;
                }
                else
                {
                    default_r[count]=default_r[count]+(int)Math.pow(2, list);
                    list--;
                }
                temp--;
            }
            int temp2=0;
            for(temp2 =0;temp2<IP_Address_split.length;temp2++)
            {
                int temp3 = Integer.parseInt(IP_Address_split[temp2])&default_r[temp2];
                if(temp3!=Integer.parseInt(table_split[i][temp2]))
                {
                    break;
                }
            }
            if(temp2==IP_Address_split.length)
            {
                System.out.println("Routed to :"+table_split[i][table_split[i].length-2]+" "+table_split[i][table_split[i].length-1]);
                break;
            }
        }
        if(i==table_size-1)
        {
            System.out.println("Routed to :"+table_split[i][table_split[i].length-2]+" "+table_split[i][table_split[i].length-1]);

        }
    }
}


