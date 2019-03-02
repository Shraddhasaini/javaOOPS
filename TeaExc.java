class TeaExc{
public static void main(String args[]){
public void drinkTea (TeaCup cup) throws TooColdEx,
TooHotEx {
int temperature = cup.getTemperature();
if (temperature <= Toocold) throw new TooColdEx ();
else if (temperature >= Toohot) throw new TooHotEx ();
else cup.sip();
}
try{
cust.drinkTea(cup);
System.out.println("Tea is okay for drinking");
}
catch (TooColdEx e){
System.out.println("Tea is too cold");
}
catch (TooHotEx e){
System.out.println("Tea is too hot");
}
}
}