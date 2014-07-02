import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class TempDriver2{
	
	public static void main(String args[]){
		//Beno's attributes
		//List<Supplier> dBS = new ArrayList<Supplier>();
		
		//Raffy's attributes
		String loopScan, inS1, inS2;
		double unitPrice;
		int search;
		
		//Beno's code:
		MainProg m = new MainProg();
		m.addSupplier();//adds supplier
		m.addItem();//adds item
		
		//raffy's code:
		/*
        do{
            List<Item> cut;
            int itemCount = 0;
            System.out.println("Do you want to edit an Item? (y/n) : ");
            loopScan = inS.next();
            if(loopScan.equals("y")){
                    System.out.println(loopScan);
                    System.out.println("Enter a Supplier: ");
                    for(int i = 0; i < dBS.size(); i++) {
                        System.out.println(i + ")" + dBS.get(i).getName() + "\n");
                    }
                    search = inS.nextInt();
                    for(int i = 0; i < dBS.size(); i++){
                        if(i == search){
                            cut = dBS.get(i).getSupplies();
                            System.out.println("Choose Item: ");
                            for(int j = 0; j < cut.size(); j++){
                                System.out.println(j + ")" + cut.get(j).getBrandName());
                                System.out.println("  " + cut.get(j).getName());
                                System.out.println("  " + cut.get(j).getUnitPrice());
                                itemCount++;
                            }
                            search = inS.nextInt();
                            System.out.println("ITEMCOUNT == " + itemCount);
                            for(int a = 0; a < itemCount; a++){
                                if(a == search){
                                    System.out.println("ENTER CONDITION");
                                    System.out.println("Enter new brand name: ");
                                    inS1 = inS.next().toUpperCase();
                                    System.out.println("Enter new item name: ");
                                    inS2 = inS.next().toUpperCase();
                                    System.out.println("Enter new unit price: ");
                                    unitPrice = inS.nextDouble();
                                    dBS.get(i).getSupplies().get(a).setBrandName(inS1);
                                    dBS.get(i).getSupplies().get(a).setName(inS2);
                                    dBS.get(i).getSupplies().get(a).setUnitPrice(unitPrice);
                                    break;
                                }
                            }
                        }
                    }
                System.out.println("Do you want to edit another Item? (y/n)");
                loopScan = inS.next();
            }
            else
                break;
        }while(loopScan.equals("y"));*/
	}
	
}
