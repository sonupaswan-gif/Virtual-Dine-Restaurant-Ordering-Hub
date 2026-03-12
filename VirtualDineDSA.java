import java.util.*;

/* Food Item Class */

class FoodItem {

    String name;
    int price;

    FoodItem(String name,int price){

        this.name=name;
        this.price=price;
    }

}

/* Linked List Node */

class Node{

    FoodItem item;
    Node next;

    Node(FoodItem item){

        this.item=item;
        this.next=null;
    }

}

/* Cart using Linked List */

class Cart{

    Node head;

    void addItem(FoodItem item){

        Node newNode=new Node(item);

        if(head==null){
            head=newNode;
            return;
        }

        Node temp=head;

        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
    }

    void displayCart(){

        if(head==null){
            System.out.println("Cart is empty");
            return;
        }

        Node temp=head;
        int total=0;

        System.out.println("\nCart Items");

        while(temp!=null){

            System.out.println(temp.item.name+" - ₹"+temp.item.price);
            total+=temp.item.price;

            temp=temp.next;
        }

        System.out.println("Total = ₹"+total);
    }

}

/* Searching Algorithm */

class Searching{

    static int linearSearch(List<FoodItem> list,String key){

        for(int i=0;i<list.size();i++){

            if(list.get(i).name.equalsIgnoreCase(key))
                return i;
        }

        return -1;
    }

}

/* Sorting Algorithm */

class Sorting{

    static void bubbleSort(List<FoodItem> list){

        for(int i=0;i<list.size()-1;i++){

            for(int j=0;j<list.size()-i-1;j++){

                if(list.get(j).price > list.get(j+1).price){

                    FoodItem temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);

                }
            }
        }

    }

}

/* Order Queue */

class OrderQueue{

    Queue<String> queue=new LinkedList<>();

    void placeOrder(String order){

        queue.add(order);
        System.out.println("Order placed successfully");
    }

    void processOrder(){

        if(queue.isEmpty()){
            System.out.println("No orders to process");
            return;
        }

        System.out.println("Processing order : "+queue.poll());
    }

}

/* Priority Queue Example */

class PriorityOrders{

    PriorityQueue<Integer> pq=new PriorityQueue<>();

    void addPriority(int p){
        pq.add(p);
    }

    void processPriority(){

        while(!pq.isEmpty()){
            System.out.println("Processing priority order : "+pq.poll());
        }

    }

}

/* Main Class */

public class VirtualDineDSA{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        /* HashMap Menu */

        HashMap<String,FoodItem> menu=new HashMap<>();

        menu.put("pizza",new FoodItem("Pizza",250));
        menu.put("pasta",new FoodItem("Pasta",220));
        menu.put("biryani",new FoodItem("Biryani",300));
        menu.put("noodles",new FoodItem("Noodles",200));

        List<FoodItem> menuList=new ArrayList<>(menu.values());

        Cart cart=new Cart();
        OrderQueue orderQueue=new OrderQueue();

        while(true){

            System.out.println("\n--- Virtual Dine Menu ---");

            System.out.println("1 View Menu");
            System.out.println("2 Add to Cart");
            System.out.println("3 Search Food");
            System.out.println("4 Sort Food by Price");
            System.out.println("5 Show Cart");
            System.out.println("6 Place Order");
            System.out.println("7 Exit");

            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.println("\nFood Menu");

                    for(FoodItem f:menuList){
                        System.out.println(f.name+" ₹"+f.price);
                    }

                    break;

                case 2:

                    System.out.println("Enter food name to add:");

                    String name=sc.nextLine().toLowerCase().trim();

                    if(menu.containsKey(name)){

                        cart.addItem(menu.get(name));

                        System.out.println("Item added to cart");

                    }
                    else{

                        System.out.println("Item not found");

                    }

                    break;

                case 3:

                    System.out.println("Enter food name to search:");

                    String key=sc.nextLine();

                    int pos=Searching.linearSearch(menuList,key);

                    if(pos!=-1){

                        FoodItem f=menuList.get(pos);
                        System.out.println("Found : "+f.name+" ₹"+f.price);

                    }
                    else{

                        System.out.println("Food not found");

                    }

                    break;

                case 4:

                    Sorting.bubbleSort(menuList);

                    System.out.println("\nSorted Menu");

                    for(FoodItem f:menuList){

                        System.out.println(f.name+" ₹"+f.price);

                    }

                    break;

                case 5:

                    cart.displayCart();

                    break;

                case 6:

                    orderQueue.placeOrder("Food Order");

                    orderQueue.processOrder();

                    break;

                case 7:

                    System.out.println("Thank you for using Virtual Dine");

                    System.exit(0);

            }

        }

    }

}