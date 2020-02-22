package retail.encore;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.JOptionPane;

public class RetailEncore
{
//
//    public static void add()
//    {
//
//    }
//
//    public static void remove()
//    {
//
//    }
//
//    public static void view()
//    {
//
//    }

    public static void main(String[] args)
    {
        RetailEncore obj = new RetailEncore();
        System.out.println("*****WELCOME TO RETAIL  ENCORE*****");
        System.out.println("**DEVELOPED BY KAZI SAHARIAR RAHI**");
        System.out.println("----------------------------------------------------------");
        System.out.println("*****WELCOME TO  ADMIN MODULE*****");
        System.out.println("----------------------------------------------------------");

        LinkedHashMap<String, Integer> admin_map = new LinkedHashMap< String, Integer>();
        LinkedHashMap<String, Integer> consum_map = new LinkedHashMap< String, Integer>();

        String choice;
        boolean b = true;

        do
        {

            int count = Integer.parseInt(JOptionPane.showInputDialog(" Choose your option.\n1.Add product to stock.\n2->Update product in your stock.\n3->Remove product from stock.\n4->View all product.\n5->Log out from admn module."));

            switch (count)
            {
                case 1:
                {

                    do
                    {

                        admin_map.put(JOptionPane.showInputDialog("Enter prouct name"), Integer.parseInt(JOptionPane.showInputDialog("Enter product price")));
                        choice = JOptionPane.showInputDialog("Do you want to add more product.(y/n)");
                        if (choice.equals("n"))
                        {
                            break;

                        }

                    } while (true);
                    break;

                }

                case 2://update product block

                {

                    do
                    {

                        admin_map.put(JOptionPane.showInputDialog("Enter product name"), Integer.parseInt(JOptionPane.showInputDialog("Enter upadated product price")));
                        choice = JOptionPane.showInputDialog("Do you want to updated more product.(y/n)");
                        if (choice.equals("n"))
                        {
                            break;

                        }

                    } while (true);
                    System.out.println("----------------------------------------------------------");
                    break;

                }
                case 3://remove product block
                {
                    do
                    {

                        String remove = JOptionPane.showInputDialog("Enter product name to be remove.");
                        admin_map.remove(remove);
                       
                        choice = JOptionPane.showInputDialog("Do you want to remove more product.(y/n)");
                        if (choice.equals("n"))
                        {
                            break;

                        }

                    } while (true);
                    break;

                }
                case 4://view all product
                {
                    Set keySet = admin_map.keySet();
                    Iterator pointer = keySet.iterator();
              
                     System.out.printf("\nPRODUCT NAME \t PRODUCT/PRICE\n");

                    while (pointer.hasNext())
                    {

                        String product_name = (String) pointer.next();//key take 
                        int product_price = (int) admin_map.get(product_name);// take value against key
                        System.out.printf("\n%s \t\t %d\n", product_name, product_price);

                    }
                    System.out.println("----------------------------------------------------------");

                    break;

                }
                case 5://log out block
                {
                    b = false;
                    System.out.println("You are  log out from admin module .");
                    System.out.println("----------------------------------------------------------");
                    break;

                }

                default:
                {
                    count=Integer.parseInt(JOptionPane.showInputDialog("Invalid choice.\n"));
                }

            }

        } while (b);
        //admin module ended
        //***********************************************************************************************************
        int total = 0;
        boolean c = true;
        do
        {

            int count2 = Integer.parseInt(JOptionPane.showInputDialog("Welcome to consumer module.\n *Choose your option.*\n1->.View all product in stock.\n2->Add to shopping basket.\n3->View all products in your basket.\n4->Search product in stock.\n5->Remove product from basket.\n6->Log out and print your invoice."));
            String choice3;

            switch (count2)
            {
                case 1://View all product in stock
                {
                    Set keySet2 = admin_map.keySet();
                    Iterator pointer2 = keySet2.iterator();
                    System.out.printf("\nPRODUCT NAME \t PRODUCT/PRICE\n");

                    while (pointer2.hasNext())
                    {

                        String product_name2 = (String) pointer2.next();//key take 
                        int product_price2 = (int) admin_map.get(product_name2);// take value against key
//                        System.out.print(product_name2);
//                        System.out.println(" \t " + product_price2);
                        System.out.printf("\n%s \t\t %d\n", product_name2, product_price2);
                    }
                    System.out.println("----------------------------------------------------------");
                    break;
                }
                case 2://Add to shopping basket
                {

                    do
                    {

                        consum_map.put(JOptionPane.showInputDialog("Enter prouct name to buy."), Integer.parseInt(JOptionPane.showInputDialog("Enter no of quantity.")));
                        choice3 = JOptionPane.showInputDialog("Do you want to add more product to your basket..(y/n)");
                        if (choice3.equals("n"))
                        {
                            break;

                        }

                    } while (true);
                    System.out.println("-----------------------------------------------------");
                    break;

                }
                case 3://view all product in basket
                {
                    Set keySet3 = consum_map.keySet();
                    Iterator pointer3 = keySet3.iterator();
                    System.out.printf("\nPRODUCT NAME \t PRODUCT QUANTITY\n");

                    while (pointer3.hasNext())
                    {

                        String product_name3 = (String) pointer3.next();//key take 
                        int product_quantity = (int) consum_map.get(product_name3);// take value against key
                        System.out.printf("\n%s \t\t %d\n", product_name3, product_quantity);
                    }
                    System.out.println("\n------------------------------------------------------");
                    break;

                }
                case 4://Search product in stock
                {
                    do
                    {

                        String search = JOptionPane.showInputDialog("Enter prouct name to search in stock.");

                        if (admin_map.containsKey(search))
                        {
                            consum_map.put(search, Integer.parseInt(JOptionPane.showInputDialog("Product is available in stock\nEnter no of quantity.")));
                            search = JOptionPane.showInputDialog("Do you want to search more product?(y/n)");
                            if (search.equals("n"))
                            {
                                break;

                            }

                        } else
                        {
                            search = JOptionPane.showInputDialog(" Sorry Product not found!\nplease try again.");
                        }
                    } while (true);
                    break;

                }

                case 5://Remove product from basket
                {
                    do
                    {
                        String remove = JOptionPane.showInputDialog("enter name oof product to remove from baket.");
                        consum_map.remove(remove);

                        remove = JOptionPane.showInputDialog("your product is successfully remove from basket.\nDo you want to remove more product?(y/n)");
                        if (remove.equals("n"))
                        {
                            break;

                        }

                    } while (true);
                    break;
                }
                case 6://log out and print invoice.
                {
                    Set keySet4 = consum_map.keySet();
                    Iterator pointer4 = keySet4.iterator();
                    System.out.printf("\nPRODUCT NAME \t\t         QTY\t\t    PPRODUCT/PRICE\t\t   TOTAL\n  ");
                    System.out.println("\n----------------------------------------------------------------------------------------------------");

                    while (pointer4.hasNext())
                    {

                        String product_name4 = (String) pointer4.next();//key take 
                        int product_price4 = (int) admin_map.get(product_name4);// take value against key
                        int product_quantity4 = (int) consum_map.get(product_name4);

                        System.out.printf("\n%s\t\t\t    %d\t\t\t    %d\t\t\t    %d  ", product_name4, product_quantity4, product_price4, product_quantity4 * product_price4);
                        total += product_quantity4 * product_price4;
                    }
                     System.out.println("\n----------------------------------------------------------------------------------------------------");

                    System.out.println("Grand total amount=\t\t\t\t\t\t\t  " + total);
                    System.out.println("Thanks for shopping.\nThank you again.");
                    String will = JOptionPane.showInputDialog("Do you want to buy more things?\npress (y/n)");
                    if (will.contentEquals("n"))
                    {
                        c = false;
                    }

                    break;

                }

                default:
                {
                    JOptionPane.showInputDialog("Wrong Input ! Try again!!");
                    break;

                }

            }

        } while (c);

    }

}
