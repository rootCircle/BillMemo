
/**
 * @author:Praveen jaiswal
 * @verison:27.301.5.301
 * User instructions:
 * Discount refers to be devired from price exclusive of tax only.
 * Sgst and cgst is initilized to 6% only.
 * Service charge of $0.04 is provided.
 */
import java.util.*;
import java.io.*;
public class Billmemo 
{
    static String username="\0";
    static String password="\0";
    static boolean login=false;
    static double paid,price=0.0,weight=-1,shp_dis,discount=-1,ret_amt;
    static double gst,sgst,cgst,total,pay,disc,shp_chr,tax,ser_chr,cgstp=6.0,sgstp=6.0;
    static int noi=0,disc_ch,shp_ch;
    static boolean choice=false,bill=false,fotr=false,reg=false,choice2=false;
    static int b,d;
    static double c,e;
    static String sius,sipa="",sirepa="",lous,lopa,depa,deus,fopa,fous;    
    static String[] array2;
    static double[] array,array4;
    static int[] array3;
    static int i,l,jad,foch;
    static long billno=0;
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("3. Forgotten Username or Password");
        System.out.println("4. Credits and Instructions");
        System.out.println("5. Delete Account");
        System.out.println("6. Exit");
        System.out.println("Enter your choice");

        int ch=Integer.parseInt(br.readLine());
        System.out.print("\n\n\n");
        if (ch==1){
            signin();
        }
        else if(ch==2){
            signup();
        }
        else if(ch==3){
            forgottenusernameorpassword();
        }
        else if(ch==4){
            creditsandinstructions();
        }
        else if(ch==5){
            deleteaccount();
        }

        if(ch!=6){
            if(ch<1 && ch>6){
                System.out.println("Invalid choice");
            }
            main();
        }

    }

    private static double decimal(double a)
    {
        b=(int)a;
        c=a-b;
        c=c*100;
        d=(int)c;
        e=d/100.0;
        a=(double)b+e;
        return a;
    }

    private static void signup()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        if(login==false)
        {
            System.out.println("                          Signup   ");
            System.out.println("Username");
            sius=br.readLine();
            System.out.println("Password");
            sipa=br.readLine();
            System.out.println("Retype password ");
            sirepa=br.readLine();
            boolean a=sipa.equals(sirepa);
            while(a==false)
            {
                System.out.println("Password not matched");
                System.out.println("Rewrite password");
                sipa=br.readLine();
                System.out.println("Retype password");
                sirepa=br.readLine();
                a=sipa.equals(sirepa);
            }

            if(username=="\0"&&password=="\0")
            {
                if(a==true)
                {
                    password=sipa;
                    username=sius;
                    System.out.println("Validation successful");
                    System.out.println("Account created");
                    reg=true;
                }
                else
                {

                    System.out.println("Error found");
                    System.out.println("Re-signup");
                }
            }
            else
            {
                System.out.println("Account has already been created on this pc");
                System.out.println("Only user allowed per device");
                System.out.println("Try one of these methods");
                System.out.println("1.Delete the account");
                System.out.println("2.Forgotten username or password");
                System.out.println("Try using forgotten username or password feature");

            }
        }
        else
        {
            System.out.println("You cannot signup when already signed-in");
        }
    }

    private static void signin()throws IOException
    {
        if(login==false)
        {
            if(reg==true)
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("                       Login");
                System.out.println("Enter username");
                lous=br.readLine();
                System.out.println("Enter password");
                lopa=br.readLine();
                boolean a=lous.equals(username),b=lopa.equals(password);
                if(a==true&&b==true)
                {
                    login=true;
                    System.out.println("You have been logined successfully");
                    logined();
                }
                while(login!=true)
                {
                    System.out.println("Invalid username or password");
                    System.out.println("Retype username and pasword");
                    System.out.println("Enter username");
                    lous=br.readLine();
                    System.out.println("Enter password");
                    lopa=br.readLine();
                    a=lous.equals(username);
                    b=lopa.equals(password);
                    if(a==true&&b==true)
                    {
                        login=true;
                        System.out.println("You have been logined successfully");
                        logined();
                    }
                }
            }
            else
            {
                System.out.println("Sign up first");
            }
        }
        else
        {
            System.out.println("Already logined");
        }
    }
    
    private static void logined()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Bill Input");
        System.out.println("2. Reprint Bill");
        System.out.println("3. Change GST");
        System.out.println("4. Logout");
        System.out.println("Enter your choice");

        int ch=Integer.parseInt(br.readLine());
        System.out.print("\n\n\n");
        if (ch==1){
            billinput();
        }
        else if(ch==2){
            reprint();
        }
        else if(ch==3){
            changegst();
        }
        else if(ch==4){
            logout();
        }

        if(ch!=4){
            if(ch<1 && ch>4){
                System.out.println("Invalid choice");
            }
            logined();
        }
    }
    
    private static void billinput()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        paid=0;
        price=0.0;
        weight=-1;
        shp_dis=0;
        discount=-1;
        ret_amt=0;
        gst=0;
        sgst=0;
        cgst=0;
        total=0;
        pay=0;
        disc=0;
        shp_chr=0;
        tax=0;
        shp_ch=0;

        ser_chr=0;
        noi=0;
        disc_ch=0;
        Scanner sc=new Scanner(System.in);
        i = 0;
        array2 = new String[noi];
        array = new double[noi];
        if(login==true)
        {
            noi=0;
            bill=false;
            for(jad=1;noi<1;jad++)
            {
                if(jad>1)
                {
                    System.out.println("Invaid number of items");
                }
                System.out.println("Enter number of items");
                noi=Integer.parseInt(br.readLine());
            }
            array3=new int[noi];
            array2 = new String[noi];
            array = new double[noi];
            array4=new double[noi]; 
            for(i=0;i<=array.length;i++)
            {
                if(i==array.length)
                {
                    break;
                }
                l=1+i;

                System.out.println("Name of article "+l);
                array2[i] = br.readLine();
                System.out.println("Price of article "+l);
                array[i] = Double.parseDouble(br.readLine());
                System.out.println("Quantity "+l);
                array3[i]= Integer.parseInt(br.readLine());
                array4[i]=array[i]*(double)array3[i];
                price=array4[i]+price;
            }
            disc=0;
            weight=0;
            price=decimal(price);
            shp_dis=-1;
            System.out.println("Shipping choice");
            System.out.println("1:Shipping required");
            System.out.println("2:No shipping required");

            System.out.println("Enter your choice");
            shp_ch=Integer.parseInt(br.readLine());
            if(shp_ch>=0&&shp_ch<=2)
            {
                choice2=true;
            }
            while(choice2!=true)
            {
                shp_ch=0;
                System.out.println("Invalid choice");
                System.out.println("Re-enter your choice");
                shp_ch=Integer.parseInt(br.readLine());
                if(shp_ch>0&&shp_ch<=3)
                {
                    choice2=true;
                }
            }
            if(shp_ch==1)
            {
                for(jad=1;shp_dis<=0;jad++)
                {
                    shp_dis=0;
                    if(jad>1)
                    {
                        System.out.println("Invalid shipping distance");
                        System.out.println("Re-enter shipping distance");
                    }
                    System.out.println("Shipping distance(in km)");
                    shp_dis=Double.parseDouble(br.readLine());
                }
                for(jad=1;weight<=0;jad++)
                {
                    weight=0;
                    if(jad>1)
                    {
                        System.out.println("Invalid weight");
                        System.out.println("Re-enter weight");
                    }
                    System.out.println("Weight(in kg)");
                    weight=Double.parseDouble(br.readLine());
                }
            }
            System.out.println("Choice of discount");
            System.out.println("1:Automatic");
            System.out.println("2:Manual");
            System.out.println("3:Null(Zero)");
            System.out.println("Enter your choice");
            disc_ch=Integer.parseInt(br.readLine());
            if(disc_ch>0&&disc_ch<=3)
            {
                choice=true;
            }
            while(choice!=true)
            {
                disc_ch=0;
                System.out.println("Invalid choice");
                System.out.println("Re-enter your choice");
                disc_ch=Integer.parseInt(br.readLine());
                if(disc_ch>0&&disc_ch<=3)
                {
                    choice=true;
                }
            }
            if(disc_ch==2)
            {

                for(jad=1;discount<=0;jad++)
                {
                    if(jad>1)
                    {
                        System.out.println("Invalid discount");
                        System.out.println("Re-enter discount");
                    }
                    discount=0;
                    System.out.println("Enter disscount");
                    discount=Double.parseDouble(br.readLine());
                }
            }
            else if(disc_ch==3)
            {
                discount=0.0;
            }
            bill =true;
            jad=1;
            billno=billno+1;
        }
        if(bill==true&&login==true)
        {

            sgst=sgstp/100*price;
            cgst=cgstp/100*price;

            shp_chr=1/4.0*weight*shp_dis;

            shp_chr=decimal(shp_chr);
            cgst=decimal(cgst);
            sgst=decimal(sgst);
            gst=cgst+sgst;
            ser_chr=2.50;
            tax=gst+shp_chr+ser_chr;
            if(disc_ch==1)
            {
                if(price<10000)
                {
                    discount=5;
                }
                else if(price>=10000&&price<20000)
                {
                    discount=10;
                }
                else if(price>=20000&&price<30000)
                {
                    discount=15;
                }
                else if(price>=30000&&price<40000)
                {
                    discount=20;
                }
                else if(price>=40000)
                {
                    discount=23;
                }
            }
            disc=discount/100.0*price;

            disc=decimal(disc);
            total=price+tax;
            pay=total-disc;
            pay=decimal(pay);
            total=decimal(total);          
            System.out.println("Amount to pay "+pay);
            System.out.println("Amount paid by customer");
            paid=Double.parseDouble(br.readLine());

            while(paid<pay)
            {
                paid=0;
                System.out.println("Paid less amount than the bill");
                System.out.println("Repay");
                System.out.println("Amount paid by customer");
                paid=Double.parseDouble(br.readLine()); 
            }
            ret_amt=decimal(paid-pay);
            System.out.println("_________________________________________________________________");
            System.out.println("|                      Welcome "+username);
            System.out.println("|                  Dragon drone shopping center                  |");
            System.out.println("|                           Bill memo                            |");
            System.out.println("|Bill number                        :"+billno);
            System.out.println("|Number of items                    :"+noi);  
            for(i=0;i<noi;i++)
            {
                System.out.println("| Name of article   |Quantity   |Mrp          |Price             |");
                System.out.println("|"+array2[i]+"      : "+array3[i]+":"+array[i]+":"+array4[i]);
            }
            System.out.println("|Total Price of all articles        :"+price); 
            if(shp_ch==1)
            {
                System.out.println("|Shipping charge                    :"+shp_chr);  
            }
            System.out.println("|C.G.S.T.                           :"+cgst);                   
            System.out.println("|S.G.S.T.                           :"+sgst);               
            System.out.println("|G.S.T.                             :"+gst); 
            System.out.println("|Service charge                     :"+ser_chr);
            System.out.println("|Tax                                :"+tax);                 
            System.out.println("|Total price(inclusive of all taxes):"+total);  
            System.out.println("|Discount                           :"+disc);                 
            System.out.println("|Amount to pay                      :"+pay);   
            System.out.println("|Amount paid by customer            :"+paid);
            System.out.println("|Amount to be returned              :"+ret_amt);
            System.out.println("|                      Thanks for shopping                       |");
            System.out.println("|                  Software designed by Lab studios              |");
            System.out.println("|________________________________________________________________|");             
        }
        else if(bill==false)
        {
            System.out.println("Input data first");
        }
        else if(login==false)
        {
            System.out.println("Login to get access");
        }
        else
        {
            System.out.println("Error");
        }
    }

    private static void reprint()throws IOException
    {
        if(login==true&&bill==true)
        {
            System.out.println("_________________________________________________________________");
            System.out.println("|                      Welcome "+username);
            System.out.println("|                  Dragon drone shopping center                  |");
            System.out.println("|                           Bill memo                            |");   
            System.out.println("|Bill number                        :"+billno);
            System.out.println("|Number of items                    :"+noi);  
            for(i=0;i<noi;i++)
            {
                System.out.println("| Name of article   |Mrp          |Quantity   |Price             |");
                System.out.println("|"+array2[i]+"      : "+array[i]+":"+array3[i]+":"+array4[i]);
            }
            System.out.println("|Total Price of all articles        :"+price); 
            if(shp_ch==1)
            {
                System.out.println("|Shipping charge                    :"+shp_chr);  
            }             
            System.out.println("|C.G.S.T.                           :"+cgst);                   
            System.out.println("|S.G.S.T.                           :"+sgst);               
            System.out.println("|G.S.T.                             :"+gst); 
            System.out.println("|Service charge                     :"+ser_chr);
            System.out.println("|Tax                                :"+tax);                 
            System.out.println("|Total price(inclusive of all taxes):"+total);  
            System.out.println("|Discount                           :"+disc);                 
            System.out.println("|Amount to pay                      :"+pay);   
            System.out.println("|Amount paid by customer            :"+paid);
            System.out.println("|Amount to be returned              :"+ret_amt);
            System.out.println("|                      Thanks for shopping                       |");
            System.out.println("|                  Software designed by Lab studios              |");
            System.out.println("|________________________________________________________________|");
        }
        else if(bill==false)
        {
            System.out.println("Input data first");
        }
        else if(login==false)
        {
            System.out.println("Login to get access");
        }
        else
        {
            System.out.println("Error");
        }
    }

    private static void logout()throws IOException
    {
        if(login==true)
        {
            login=false;
            paid=0;
            price=0.0;
            weight=-1;
            shp_dis=0;
            discount=-1;
            ret_amt=0;
            gst=0;
            sgst=0;
            cgst=0;
            total=0;
            pay=0;
            disc=0;
            shp_chr=0;
            tax=0;
            ser_chr=0;
            noi=0;
            disc_ch=0;
            choice=false;
            bill=false;
            fotr=false;
            reg=false;
            shp_ch=0;
            choice2=false;
            array3=new int[noi];
            array2 = new String[noi];
            array = new double[noi];
            array4=new double[noi]; 

            System.out.println("You have been logged out successfully");
        }
        else
        {
            System.out.println("Login first");
        }
    }

private static void deleteaccount()throws IOException
    {
        boolean a,b;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Delete account");
        System.out.println("Username");
        deus=br.readLine();
        System.out.println("Password");
        depa=br.readLine();
        a=deus.equals(username);
        b=depa.equals(password);
        if(a==true&&b==true)
        {
            username="\0";
            password="\0";
            sius="";
            sipa="";
            sirepa="";
            fous="";
            fopa="";
            lous="";
            lopa="";
            deus="";
            depa="";
            login=false;
            paid=0;
            price=0.0;
            weight=-1;
            shp_ch=0;
            choice2=false;
            shp_dis=0;
            discount=-1;
            ret_amt=0;
            gst=0;
            sgst=0;
            cgst=0;
            total=0;
            pay=0;
            disc=0;
            shp_chr=0;
            tax=0;
            ser_chr=0;
            noi=0;
            disc_ch=0;
            choice=false;
            bill=false;
            fotr=false;
            reg=false;
            array3=new int[noi];
            array2 = new String[noi];
            array = new double[noi];
            array4=new double[noi]; 

            billno=0;
            System.out.println("Account deleted successfully");

        }
        else 
        {
            System.out.println("Invalid creditinals");
        }

    }

    private static void forgottenusernameorpassword()throws IOException
    {
        boolean c,a,b;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        fotr=false;
        System.out.println("Forgotten username or password");
        System.out.println("1:Forgotten Password");
        System.out.println("2:Forgotten Username");
        System.out.println("Enter your choice");
        foch=Integer.parseInt(br.readLine());
        if(foch>=1&&foch<=2)
        {
            fotr=true;
        }
        while(fotr!=true)
        {
            System.out.println("Invalid choice");
            System.out.println("Re-Enter your choice");
            foch=Integer.parseInt(br.readLine());
            if(foch>=1&&foch<=2)
            {
                fotr=true;
            }
        }
        if(foch==1)
        {
            System.out.println("Enter username");
            fous=br.readLine();
            a=fous.equals(username);
            if(a==true)
            {
                System.out.println("Reset password");
                System.out.println("Type new password");
                sipa=br.readLine();
                System.out.println("Retype password");
                sirepa=br.readLine();
                c=sipa.equals(sirepa);
                for(;c==false;)
                {
                    System.out.println("Password not matched");
                    System.out.println("Retype password");
                    sipa=br.readLine();
                    System.out.println("Retype password");
                    sirepa=br.readLine();
                    c=sipa.equals(sirepa);
                }
                password=sipa;
            }
            else
            {
                System.out.println("Invalid creditinals");
            }
        }
        else if(foch==2)
        {
            System.out.println("Enter password");
            fopa=br.readLine();
            c=password.equals(fopa);
            if(c==true)
            {
                System.out.println("Reset username");
                System.out.println("Enter new username");
                sius=br.readLine();
                username=sius;
            }
            else
            {
                System.out.println("Invalid creditinals");
            }
        }
        else
        {
            System.out.println("Error");
        }
    }

    private static void creditsandinstructions()throws IOException
    {
        System.out.println("                                             Credits                                                    ");
        System.out.println("@Microsoftlabs");
        System.out.println("Discount refers to be devired from price exclusive of tax only.");
        System.out.println("Sgst and cgst is initilized to 6% only.");
        System.out.println("Service charge of $0.04 is provided.");
        System.out.println("Sign up first then login to takeover the program");

    }

    private static void changegst()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        if(login==true)
        {
            System.out.println("Changing gst rates");
            System.out.println("Cgst");
            cgstp=Integer.parseInt(br.readLine());
            System.out.println("Sgst");
            sgstp=Integer.parseInt(br.readLine());
        }
        else
        {
            System.out.println("Login first");
        }
    }
}
