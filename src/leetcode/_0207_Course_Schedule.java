package leetcode;

import java.util.*;

public class _0207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] prerequest = new int[numCourses];
        for(int[] req : prerequisites){
            if(map.containsKey(req[1])){
                List<Integer> l = map.get(req[1]);
                l.add(req[0]);
                map.put(req[1], l);
            }else{
                List<Integer> l = new LinkedList<>();
                l.add(req[0]);
                map.put(req[1], l);
            }
            prerequest[req[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(prerequest[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int key = q.poll();
            if(map.containsKey(key)){
                for(Integer i : map.get(key)){
                    prerequest[i]--;
                    if(prerequest[i]==0){
                        q.add(i);
                    }
                }
            }
        }
        for(int i=0; i<numCourses; i++){
            if(prerequest[i]!=0) return false;
        }
        return true;
    }
}
