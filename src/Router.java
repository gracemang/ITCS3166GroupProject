import java.util.Scanner;
public class Router {
    public static void main(String argv[])
    {

        Scanner sc = new Scanner(System.in);
        int n;

//reading contents
        String ip;
        System.out.print("Enter ip to search:");
        ip = sc.nextLine();

        System.out.print("Enter routing table size :");
        n =sc.nextInt();
        String s;
        System.out.println("Press enter----------");
        s =sc.nextLine();
        String routing_table[]=new String[n];

        System.out.println("Enter Table contents :");
        System.out.println("Address/mask Next hop");

        for(int i=0;i<n;i++)
        {//System.out.println(i);
            routing_table[i]=sc.nextLine();

        }
        
        String ip_split[];

        ip_split = ip.split("[.]");



        String rt_split[][] = new String[n][];

        for(int i=0;i<n;i++)
        {
            rt_split[i] = routing_table[i].split("[./ ]");
        }



        for (String e :ip_split)
        {
            System.out.print(e+" ");
        }System.out.println();

        for(int i=0;i<n;i++)
        {
            for(String e : rt_split[i])
                System.out.print(e+" ");
            System.out.println();

        }


        int i;
        for(i=0;i<n-1;i++)
        {
            int k = Integer.parseInt(rt_split[i][4]);
            int num[]={0,0,0,0};
            int l=7,c=0;
            while(k>0)
            {
                if(l==0)
                {
                    num[c]=num[c]+1;
                    c++;
                    l=7;
                }
                else
                {
                    num[c]=num[c]+(int)Math.pow(2, l);
                    l--;
                }
                k--;
            }
            int j=0;
            for(j =0;j<ip_split.length;j++)
            {
                int m = Integer.parseInt(ip_split[j])&num[j];
//System.out.println(m);
                if(m!=Integer.parseInt(rt_split[i][j]))
                {
// System.out.println("hello"+i);
                    break;
                }

            }

// System.out.println(i+" "+j);
            if(j==ip_split.length)
            {
                System.out.println("Route to :"+rt_split[i][rt_split[i].length-2]+" "+rt_split[i][rt_split[i].length-1]);
                break;
            }

        }

        if(i==n-1)
        {
            System.out.println("Route to :"+rt_split[i][rt_split[i].length-2]+" "+rt_split[i][rt_split[i].length-1]);

        }

    }

}


