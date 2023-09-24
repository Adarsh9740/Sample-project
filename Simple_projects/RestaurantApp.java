import java.util.Scanner;
class Restaurant
{

	int nplate[]=new int[20];
	int itNo[]=new int[20];
	int price[]=new int[50];
	String item[]=new String[50];
	int rear=-1;
	int total;
	int listAdd;
	static{
		System.out.println("-----------------------------------");
		System.out.println("        APPU BIRYANI CAFE");
		System.out.println("-----------------------------------\n");
	}
		{
		item[0]="ChickenBiryani";
		price[0]=100;
		item[1]="MuttonBiryani ";
		price[1]=300;
		item[2]="Kushka        ";
		price[2]=60;
		item[3]="kabab         ";
		price[3]=100;
		listAdd=3;
	}
		void addMenu(){
			Scanner scan=new Scanner(System.in);
			System.out.println("---------------------------------------------------");
			System.out.print("Item Name:");
			listAdd++;
			item[listAdd]=scan.nextLine();
			System.out.print("Item Price:");
			price[listAdd]=scan.nextInt();
			System.out.println("---------------------------------------------------");
			System.out.println(item[listAdd]+" added");
			System.out.println("---------------------------------------------------");
		}
	void itemList(){
		int i;
		System.out.println("-----------------------------------");
		System.out.println("Sn Item                Qty  Rate");
		System.out.println("-----------------------------------");
		for(i=0;i<=listAdd;i++){
		System.out.print((i+1)+"  "+item[i]);
		System.out.println("      1p    "+price[i]);
		}
	}
	int selectItem(){
		Scanner scan=new Scanner(System.in);
		System.out.println("-----------------------------------");
		System.out.print("Choose your food:");
		return (scan.nextInt());
	}
	void takingOrd(int itNo){
		Scanner scan=new Scanner(System.in);
		boolean sameIt=false;
		int i=1,j=0;
		System.out.println("-----------------------------------");
				while(true){
					if(i==itNo){
					System.out.println(item[i-1]+" - 1p - "+price[i-1]);
					System.out.println("-----------------------------------");
					System.out.print("How many:");
					if(rear>-1){
						while(j<=rear){
							if(this.itNo[j]==itNo){	
								nplate[j]+=scan.nextInt();
								sameIt=true;;
							}
							j++;
						}
					}
					if(sameIt==false){
					rear++;
					nplate[rear]=scan.nextInt();
				    this.itNo[rear]=itNo;
					}
						break;
					}
					i++;
				}
				   
		System.out.println("-----------------------------------");
	}

	void delItem(){
	
		int i=0,j=0;
		if(rear>-1){
		System.out.println("---------------------------------------------------");
		System.out.println("Sn  Item		Qty	Rate	Amount");
		System.out.println("---------------------------------------------------");
		for(i=0;i<=rear;i++){
			System.out.println((i+1)+"    "+item[itNo[i]-1]+"     "+nplate[i]+"       "+price[itNo[i]-1]+"     "+(price[itNo[i]-1]*nplate[i]));
		}

		System.out.println("---------------------------------------------------");
		System.out.print("Choose your food to be deleted: ");
		Scanner scan=new Scanner(System.in);
		int itDel=scan.nextInt();
					for(j=0;j<=rear;j++){
					 if(j+1==itDel){
					for(i=j;i<=rear;i++){
					nplate[i]=nplate[i+1];
					itNo[i]=itNo[i+1];
					}
					break;
					 }
					}
					
	     	System.out.println("---------------------------------------------------");
			System.out.println("item No "+itDel+" deleted");
			
			rear--;
		}
		else{
			System.out.println("---------------------------------------------------");
			System.out.println("Not yet order any item");
		}
			System.out.println("---------------------------------------------------");
		}

	void genBill(){
		int i;
		System.out.println("---------------------------------------------------");
		System.out.println("               Appu Biryani Cafe\n");
		System.out.println("     Appu Circle,100 feet road,Mandya,Karnataka");
		System.out.println("---------------------------------------------------");
		System.out.println("Sn  Item		Qty	Rate	Amount");
		System.out.println("---------------------------------------------------");
		for(i=0;i<=rear;i++){
			System.out.println((i+1)+"    "+item[itNo[i]-1]+"     "+nplate[i]+"       "+price[itNo[i]-1]+"     "+(price[itNo[i]-1]*nplate[i]));
			total+=price[itNo[i]-1]*nplate[i];
		}
						System.out.println("---------------------------------------------------");
						System.out.println("			  Sub Total:    "+total);
						System.out.println("			  CGST     :    "+(total*0.025));
						System.out.println("			  SGST     :    "+(total*0.025));
						total+=2*(total*0.025);
						System.out.println("			--------------------------");
						System.out.println("			  Total Due:    "+total);
						System.out.println("---------------------------------------------------");
						System.out.println("            Thank you for your visit");
						System.out.println("                 Have a nice day");
						System.out.println("---------------------------------------------------");
	}
	/*boolean signIn(){
		Sytem.out.print("Name:")
			String name=scan.next();
		System.out.print("Password:");
		String password=scan.next();
			if(this.name.equals(name)||this.password.equals(password)){
				return true;
		}
		return false;
	}*/
}


class RestaurantApp
{
	public static void main(String[] args) 
	{
		Restaurant r=new Restaurant();
		Scanner scan=new Scanner(System.in);

		r.itemList();
		r.takingOrd(r.selectItem());
		int i;
		
		while(true){
		System.out.println("1.Order more");
		System.out.println("2.Generate Bill");
		System.out.println("3.Delete Item");
		System.out.println("4.Add Menu");
		System.out.println("-----------------------------------");
		i=scan.nextInt();
		if(i==1){
		r.itemList();
		r.takingOrd(r.selectItem());
		}
		else if(i==2){
		r.genBill();
		break;		
		}
		else if(i==3){
		 r.delItem();
		}
		else if(i==4){
			System.out.println("-----------------------------------");
			System.out.println("Available items");
			r.itemList();
			r.addMenu();
		}
		
		}
	}
}
