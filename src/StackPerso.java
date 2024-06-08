import java.util.EmptyStackException;
import java.util.Stack;


public class StackPerso<E> {
    private E arr[];
    private int top=-1;

    public StackPerso(int c){
        arr = (E[]) new Object[c];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        if(size()==0){
            return true;
        }else{
            return false;
        }
    }

    public E push(E elem){ //A REGLER HYPER IMPORTANT
        if (top==arr.length-1){
            E[] newArr = (E[]) new Object[(arr.length)*2];
            for(int i=0; i<top;i++){
                newArr[i]=arr[i];
            }
            arr=newArr;
        }
        top++;
        arr[top]=elem;
        return arr[top];
    }

    public E pop(){
        E temp;
        if(isEmpty()){
            System.out.println("The stack is already empty");
            return null;
        }
        temp=arr[top];
        arr[top]=null;
        top--;
        return temp;
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        return arr[top];
    }

    public void display()
    {
        System.out.println("-------------------START HERE----------------------");
        for (int i=0;i<this.size();i++)
        {

            System.out.println(arr[i]);

        }
        System.out.println("-------------------END HERE----------------------");
    }

}
