import static java.lang.System.out;
import java.util.Scanner;

//Optmised-version
//Tested on jdk 12.x.x
//On operating system linux debain 

class cart{
	private int[] ar = new int[4];
	cart(){
		for (int i =0;i<=3 ;i++ ) {
			ar[i] = 0;
		}
	}
	void insert(int x){
		int ins_pos=0,flag = 0;
		if(ar[0] == 0){
			ar[0] = x;
		}else{
			//checking if already present and getting last position
			for(int i =0;i<3;i++){
				if(ar[i] == x){System.out.println("Element already present");break;}
				if(ar[i] == 0){ins_pos = i;flag=1;break;}//reached end of cart
			}
			if(flag == 1){
				ar[ins_pos] = x;
			}
		}
	}
	void remove(int x){
		int rm_pos=0,tmp=0;//remember to pass value which is in cart
		if(ar[0] == 0){//if empty print 
			System.out.println("Cart is empty");
		}else{
			for(int i =0;i<3;i++){
				if(ar[i] == x){//remove the ele at this pos and note the position
					ar[i] = 0;rm_pos = i;break;
				}
			}
			//refactor from the rm_pos position
			for(int i =rm_pos;i<3;i++){
				if(ar[i]<ar[i+1]){
					ar[i] = ar[i+1];
					ar[i+1] = 0;
				}
			}
		}
	}
	void printCart(){
		//print full loop and until Zero is reched
		if(ar[0] == 0){//if empty print 
			System.out.println("Cart is empty");
		}else{
			for(int i=0;i<3;i++){
				if (ar[i]==0) {
				break;
			}
			System.out.println(ar[i]);
		}
		}
	}
}


class tmp{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cart c = new cart();
		int ch,tmp;
		do{
			System.out.print("\n1)Insert\n2)remove\n3)print\nEnter choice");
			ch = sc.nextInt();
			switch(ch){
				case 1:{
					System.out.println("Enter a id to insert : ");
					tmp = sc.nextInt();
					c.insert(tmp);
					break;}
				case 2:{
					System.out.println("Enter the id to remove : ");
					tmp = sc.nextInt();
					c.remove(tmp);
					break;}
				case 3:{
					System.out.println();
					c.printCart();
					break;}
				default:break;
			}
		}while(ch<4);
	}
}