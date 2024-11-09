/*Program to validate pin,check balance,deposit and withdraw money,reset pin by validating mobile number and security code if the pin is forgotten 
and reset pin by validating the old pin*/
import java.util.Scanner;
class Bank {
private int pin=1111;
private int bal=1000;
int trail=0;
private String mobile_no="11111";
private String nick_name="power";
byte flag=3;
Scanner scan=new Scanner(System.in);

//Greetings
static{
System.out.println("------------------------------------------");
System.out.println("           Welcome to SBI Bank");
System.out.println("------------------------------------------");
}

//validating the pin
int enterPin(){
int count=3;
while(count>=1){
System.out.print(" Enter 4 number pin:");
if(pin==scan.nextInt())
{
System.out.println("------------------------------------------");
return 1;
}
else{
count--;
if(count!=0){
System.out.println("******************************************");
System.out.println("         +++++ENTERED WRONG PIN++++++");
System.out.println("YOU HAVE "+count+" ATTEMPTS LEFT TO ENTER WRONG PIN");
System.out.println("******************************************");
}
}
}
System.out.println("******************************************");
System.out.println("    YOU HAVE ENTERED WRONG PIN MANY TIMES");
System.out.println("******************************************");
return 0;
}

//checking balance
void checkBal(){
System.out.println(" Balance:"+bal);
System.out.println("------------------------------------------");
}

//depositing money
void deposit(){
System.out.print(" Enter the amount:");
bal=bal+scan.nextInt();
System.out.println("------------------------------------------");
}

//withdrawing money
void draw(){
int draw;
System.out.print(" Enter the amount:");
if(bal>=(draw=scan.nextInt())){
bal=bal-draw;
System.out.println("------------------------------------------");
}
else{
System.out.println("******************************************");
System.out.println("Your balance="+bal);
System.out.println("Insufficient Balance");
System.out.println("******************************************");
}
}

//verifying the mobile number and security code.so here security code is the nickname
int forgetPin(){
int count=3;
while(true){
System.out.print("Enter your registered mobile number: ");
if(mobile_no.equals(scan.next())){
while(count>=1){
System.out.print("Enter your security code which ,Hint:your nick name: ");
if(nick_name.equals(scan.next())){
return 1;
}
else{
count--;
if(count!=0){
System.out.println("******************************************");
System.out.println("Entered wrong security code...");
System.out.println("You have "+count+" attempts left to enter wrong code...");
System.out.println("******************************************");
System.out.println(" 1.try again\n");
System.out.println(" Enter any key to exit\n");
System.out.println("------------------------------------------");
System.out.print("Enter your choice: ");
if(scan.nextInt()!=1){
return 0;
}
System.out.println("------------------------------------------");
}
}
}
System.out.println("******************************************");
System.out.println("   you are exceeded your attempts");
System.out.println("    Your are blocked temporarely");
System.out.println("      Visit your SBI Branch");
System.out.println("******************************************");
return 0;
}
else{
System.out.println("******************************************");
System.out.println("     ...Number not found...");
System.out.println("******************************************");
System.out.println("------------------------------------------");
System.out.println(" 1.Try again\n");
System.out.println(" Enter any key to exit\n");
System.out.println("------------------------------------------");
System.out.print("Enter your choice: ");
if(scan.nextInt()!=1){
return 0;
}
System.out.println("------------------------------------------");
}
}
}

//reseting pin afterverifying the mobile number and security code.
int resetPin(){
int new_pin;
while(true){
System.out.println("------------------------------------------");
System.out.print("Enter a new pin: ");
new_pin=scan.nextInt();
System.out.print("Confirm your new pin: ");
if(new_pin==scan.nextInt()){
System.out.println("------------------------------------------");
pin=new_pin;
System.out.println("******************************************");
System.out.println("Your pin has been reset successfully...");
System.out.println("******************************************");
flag=1;
return 1;
}
else{
System.out.println("******************************************");
System.out.println("      +++-- MISMATCHING--+++");
System.out.println("******************************************");
System.out.println("1.Try again");
System.out.println("Enter any key to exit");
System.out.println("------------------------------------------");
System.out.print("Enter your choice:");
if(scan.nextInt()!=1){
	return 0;
}
System.out.println("------------------------------------------");

}
}
}

//reseting pin by verifying the old pin
int resetPin1(){
int newpin;
while(flag>=1){
System.out.print("Enter your old pin:");
if(pin==scan.nextInt()){
while(true){
System.out.println("------------------------------------------");
System.out.print("Enter a new pin:");
newpin=scan.nextInt();
System.out.print("Confirm the pin:");
if(newpin==scan.nextInt()){
System.out.println("------------------------------------------");
pin=newpin;
flag=1;
System.out.println("******************************************");
System.out.println("+++--YOUR PIN HAS BEEN REST--+++");
System.out.println("******************************************");
return 1;
}
else {
System.out.println("******************************************");
System.out.println("++++++++--Mismatching--++++");
System.out.println("******************************************");
System.out.println(" 1.try again");
System.out.println(" 2.Cancel");
System.out.println("------------------------------------------");
System.out.print("Enter your choice:");
if(scan.nextInt()!=1){
return 0;
}
}
}
}
else{
flag--;
if(flag!=0){
System.out.println("******************************************");
System.out.println("INCORRECT PIN");
System.out.println("ONLY "+flag+" ATTEMPTS LEFT");
System.out.println("******************************************");
System.out.println("1.Try again");
System.out.println("Enter any number key to exit");
System.out.print("Enter your choice:");
if(scan.nextInt()!=1){
return 0;
}
}
}
}
System.out.println("******************************************");
System.out.println("+++--YOUR ARE EXCEEDED YOUR ATTEMPS--++");
System.out.println("******************************************");
flag=0;
return 0;
}

//showing gratitude
void thank(){
System.out.println("*+*+*+*+*+*++*++*+*+*+*+*+*+*+*+*+*+**+*+*");
System.out.println("         Thanks for visiting SBI");
System.out.println("             HAVE A GOOD DAY");
System.out.println("*+*+*+*+*+*++*++*+*+*+*+*+*+*+*+*+*+*+*+*+");
}

//showing options
int showOptions(){
int n;
System.out.println(" 1.Balance check " );
System.out.println(" 2.Deposit " );
System.out.println(" 3.Withdraw " );
System.out.println(" 4.Reset pin");
System.out.println(" Enter any key to exit");
System.out.println("------------------------------------------");
System.out.print(" Enter your choice:" );
n=scan.nextByte();
System.out.println("------------------------------------------");
return n;
}
}


class BankApplication
{
public static void main(String[] args) {
Scanner scan=new Scanner(System.in);
int n,count=0;
int x;
Bank b=new Bank();
//calling enterPin() to verify the pin
n=b.enterPin();//if entered pin is right,then n=1 or else n=0
//if n=0,forget pin option will be displayed
if(n==0){
System.out.println("1.Forgot Pin");
System.out.println("Enter any key number to exit");
System.out.println("------------------------------------------");
System.out.print("Enter your choice:");
x=scan.nextInt();
System.out.println("------------------------------------------");
if(1==x){
x=b.forgetPin();
System.out.println("------------------------------------------");
if(x==1){
if((b.resetPin())==1){
n=b.enterPin();
}
else{
b.thank();
}
}
else{
b.thank();
}
}//inner if ends
else {
b.thank();
}//inner else if ends
}//outer if ends

//if n=1
if(n==1){
n=b.showOptions();
while(n<=5){
if(n==1){
b.checkBal();
}//inner if ends
else if(n==2){
b.deposit();
}//inner 1st else if ends
else if(n==3){
b.draw();
}//inner 2nd else if ends
else if(n==4){
if(b.flag!=1 || b.flag==0){
x=b.resetPin1();
}
else{
System.out.println("******************************************");
System.out.println("++++--YOU HAVE JUST RESET YOUR PIN--++++");
System.out.println("******************************************");

}
}
else {
b.thank();
break;
}
n=b.showOptions();
}
}
}
}

