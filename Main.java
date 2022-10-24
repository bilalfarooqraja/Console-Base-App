import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DbFunctions db= new DbFunctions();
        Connection conn=db.connectToDb("postgres","postgres","admin");
        Scanner input = new Scanner(System.in);
        boolean con = true;
        while(con)
        {
            System.out.println("To Create Table Press 1\nTo Insert Rows Press 2\nTo Update Name Press 3\nTo Search By Name Press 4\nTo Delete Name Press 5\nTo Read Table Press 6\n Press 7 to exit");
            int num = Integer.parseInt(input.nextLine());
            if (num == 1) {
                System.out.println("Enter Table Name ");
                Scanner inputs = new Scanner(System.in);
                String table = inputs.nextLine();
                db.CreateTable(conn, table);
            }
            if (num == 2) {
                System.out.println("Enter Table Name ");
                Scanner inputs = new Scanner(System.in);
                String table = inputs.nextLine();
                System.out.println("Enter Name ");
                String name = inputs.nextLine();
                System.out.println("Enter Address ");
                String address = inputs.nextLine();
                db.InsertRows(conn, table, name, address);
            }
            if (num == 3) {
                System.out.println("Enter Table Name ");
                Scanner inputs = new Scanner(System.in);
                String table = inputs.nextLine();
                System.out.println("Enter Old Name ");
                String name = inputs.nextLine();
                System.out.println("Enter New Name ");
                String newName = inputs.nextLine();
                db.updateData(conn, table, name, newName);
            }
            if (num == 4) {
                System.out.println("Enter Table Name ");
                Scanner inputs = new Scanner(System.in);
                String table = inputs.nextLine();
                System.out.println("Enter Name ");
                String name = inputs.nextLine();

                db.searchByName(conn, table, name);
            }
            if (num == 5) {
                System.out.println("Enter Table Name ");
                Scanner inputs = new Scanner(System.in);
                String table = inputs.nextLine();
                System.out.println("Enter Name ");
                String name = inputs.nextLine();

                db.deleteData(conn, table, name);
            }
            if (num == 6) {
                db.readData(conn, "employee");
            }
            if (num == 7) {
                con =false;
            }
        }
    }
}