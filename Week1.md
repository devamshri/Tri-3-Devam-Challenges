{% include navigation.html %}
### [TT1](https://github.com/devamshri/Tri_3_Devam_Challenges/issues/1):
#### Links to Review Ticket for this Week: [Review Ticket](https://github.com/devamshri/Tri_3_Devam_Challenges/issues/1)

[Run Time](https://replit.com/@D3vIs4G0d/Tri3DevamChallenges#src/com/devamchallenges/tt1)

## GitHub Links
1. [challenge 1](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt1/LinkedList.java)
2. [challenge 2](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt1/MergingQueues.java)
3. [challenge 3](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt1/twoQueue.java)
4. [Queue](https://github.com/devamshri/Tri-3-Devam-Challenges/blob/main/src/com/devamchallenges/tt1/Queue.java)

## Notes for TT1
[3/15 Linked Lists Notes](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-1:-Linked-Lists-Part-2)
> **_Linked Lists:_**  linked lists are lists that are linked in one direction though variables within each object within the list.
**head** is the first node of the linked list
**tail** is the last node of the linked list
the head of the linked list will link to the next node and so on. The last node (tail) will link to null since there isn't anything else after it.
> **_Doubly Linked Lists:_** these are liked linked lists but the nodes are also linked backwards, towards their previous node.
A normal linked list will only link to the next node, however a doubly linked lists's node will link to both it's next node and it's previous node.
> **_The Java Generic T_** is a generic type of perameter for the class it is added to. It will generally appear at the end of the class name with < >.
- Linked lists are datastructures
- They have lists
- head pointer: beginning of list (always slimy in this case)
- tail pointer: end of list (southward after southward is added)
-deque --> remove head pointer
- Stack- will use push and pop
- deque and push to reverse order of stack
- a que has a linked list --> que will have date
- previous node is node previous
- next node is null until it is added
- link list needs to be resized periodically and it needs
- arraylist is a cobination of a queue and an array list
- Insertian and deletion is very efficient compared to an array
- Doubly linked lists each element is linked to its next and previous element

### challenge 1 (Setting up Linked List and Testing it out)
```java
package com.devamchallenges.tt1;

public class LinkedList<T> {
    private T data;
    private LinkedList<T> prevNode, nextNode;
    private LinkedList lifo;

    public LinkedList(T data, LinkedList<T> node) {
        this.setData(data);
        this.setPrevNode(node);
        this.setNextNode(null);
    }

    public LinkedList(LinkedList<T> node) {
        this.setData(node.data);
        this.setPrevNode(node.prevNode);
        this.setNextNode(node.nextNode);
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setPrevNode(LinkedList<T> node) {
        this.prevNode = node;
    }

    public void setNextNode(LinkedList<T> node) {
        this.nextNode = node;
    }

    public LinkedList<T> getPrevious() {
        return this.prevNode;
    }

    public LinkedList<T> getNext() {
        return this.nextNode;
    }

    public static void main(String[] args) {
        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        QueueManager qWords = new QueueManager("Words", words);

    }
}

```
### challenge 2 (Combining/Merging)
```java
package com.devamchallenges.tt1;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergingQueues {

    public static PriorityQueue<Integer> merge(Queue<Integer> first, Queue<Integer> second){
        PriorityQueue<Integer> mergedQueue = new PriorityQueue<Integer>();

        //if both Queues are not empty
        while(!first.isEmpty() && !second.isEmpty()){
            //uses peek() function to look at values in the Queues
            Integer init = first.peek();
            Integer next = second.peek();

            //if the first queue has a value smaller than 2nd queue
            if(init < next){
                mergedQueue.add(first.poll());
            }
            //if second queue has a value smaller than 1st queue
            else{
                mergedQueue.add(second.poll());
            }
        }

        //if the first queue has values but second queue is empty
        while (!first.isEmpty() && second.isEmpty()){
            mergedQueue.add(first.poll());
        }

        //if second queue has values but first queue is empty
        while(!second.isEmpty() && first.isEmpty()){
            mergedQueue.add(second.poll());
        }
        //return statement
        return mergedQueue;
    }


    public static void main(String[] args){

        //creating queue1
        Queue qNums1 = new PriorityQueue<Integer>();
        qNums1.add(1);
        qNums1.add(4);
        qNums1.add(5);
        qNums1.add(8);
        //printing queue1
        System.out.println("first queue: " + qNums1);

        //creating queue2
        Queue qNums2 = new PriorityQueue<Integer>();
        qNums2.add(2);
        qNums2.add(3);
        qNums2.add(6);
        qNums2.add(7);
        System.out.println("second queue: " + qNums2);

        //Object[] numbers2 = new Integer[]{2, 3, 6, 7};
        //QueueManager qNums2 = new QueueManager("num2", numbers2);

        //merging Queues
        PriorityQueue merged = MergingQueues.merge(qNums1, qNums2);

        //enhanced for loop to print values in the merged Queue
        System.out.print("Merged Queue: ");
        for (Object data : merged)
            System.out.print(data + " -> ");
        System.out.print("nil");


    }
}
```



### challenge 3 (Build Stack and Reverse)
```java
package com.devamchallenges.tt1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class twoQueue {

    public static void reverse(Queue<Integer> initQueue){
        /**
         * In order to reverse the Queue into a stack, you need to make a temporary/empty stack
         * Then, reverse the queue order by popping the elements from the stack and put the elements into the queue into the stack
         * Push the elements back into the Queue & print elements in the queue
         */
        Stack<Integer> temp = new Stack<>(); //creates a temporary stack

        //pushes element from queue to stack
        while(!initQueue.isEmpty()){
            temp.push(initQueue.poll());
        }

        //pop elements from stack to Queue
        while(!temp.isEmpty())
        {
            initQueue.add(temp.pop());
        }

        //print values from queue
        for(Integer value2: initQueue) {
            System.out.print(value2 + " -> ");
        }
        System.out.print("nil");


    }

    public static void main(String[] args){
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        System.out.println("Initial Queue: "+ queue1);

        System.out.print("Reverse Queue: ");
        reverse(queue1);
    }
}

```
