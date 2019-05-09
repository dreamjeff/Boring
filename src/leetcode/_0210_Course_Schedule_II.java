package leetcode;

import java.util.*;

public class _0210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] prereq = new int[numCourses];
        HashMap<Integer, List<Integer>> release = new HashMap<>();
        for(int[] pre : prerequisites){
            int key = pre[1];
            if(release.containsKey(key)){
                release.get(key).add(pre[0]);
            }else{
                List<Integer> l = new LinkedList<>();
                l.add(pre[0]);
                release.put(key, l);
            }
            prereq[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<prereq.length; i++){
            if(prereq[i]==0){
                q.add(i);
            }
        }
        int[] res = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int course = q.poll();
            res[i++]=course;
            if(!release.containsKey(course)) continue;
            for(Integer j : release.get(course)){
                if(--prereq[j]==0){
                    q.add(j);
                }
            }
        }
        if(i!=numCourses) return new int[0];
        return res;
    }
}
