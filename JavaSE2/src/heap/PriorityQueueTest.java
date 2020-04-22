package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Card implements Comparable<Card>{
    int rank;
    String suit;

    public Card(int rank,String suit){
        this.rank=rank;
        this.suit=suit;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if( !(o instanceof Card)){
            return false;
        }

        Card c=(Card) o;
        return this.rank==c.rank&&this.suit.equals(c.suit);

    }

    @Override
    public int compareTo(Card o) {
        if(o==null){
            return 1;
        }
        return this.rank-o.rank;
    }
}


public class PriorityQueueTest {



    public static void main(String[] args) {
        CardCom com=new CardCom();
        PriorityQueue<Card> q=new PriorityQueue<>(com);

        Card c1=new Card(1,"♠");
        Card c2=new Card(2,"♠");
        q.offer(c1);
        q.offer(c2);
        System.out.println(q.peek().rank);
    }
}

class CardCom implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        if(null == o1){
            return -1;
        }
        if(null == o2){
            return 1;
        }
        return o1.rank-o2.rank;
    }
}