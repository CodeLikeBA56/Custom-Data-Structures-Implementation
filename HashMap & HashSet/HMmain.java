public class HMmain{
	public static void main(String[] args) {
  		 HashMap<String, Integer> map = new HashMap<>();
   			 map.insert("corolla", 1300);
   			 map.insert("honda", 1800);
   			 map.insert("kia", 1500);
    			 map.display();

   			 System.out.println("Removing ");
  			 map.remove("honda");
   			 map.display();

   			 System.out.println("Contains 'kia'? " + map.containsKey("kia"));
   	 
   
}
}