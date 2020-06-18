package AOneQuestionPerDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code0618 {
    // Employee info
    public static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public ListNode getIntersectionNode( ListNode listA, ListNode listB) {
        if(listA == null || listB == null){
            return null;
        }
        ListNode a = listA;
        ListNode b = listB;
        while(a != b){
            if(a == null){
                a = listB;
            }else{
                a = a.next;
            }
            if(b == null){
                b = listA;
            }else{
                b = b.next;
            }
        }
        return a;
    }
    public int findMagicIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if((nums[i] ^ i ) == 0){
                if(nums[i]<ret){
                    ret = nums[i];
                }
            }
        }
        if(ret == Integer.MAX_VALUE){
            return -1;
        }
        return ret;
    }
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        //将员工id和员工信息建立索引关系
        for(Employee e:employees){
            map.put(e.id,e);
        }
        // return DFS(map,id);
        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));
        int sum = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Employee e = q.poll();
                sum+=e.importance;
                for(int j=0;j<e.subordinates.size();j++){
                    q.offer(map.get(e.subordinates.get(j)));
                }
            }
        }
        return sum;

    }
}
