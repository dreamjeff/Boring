package am;

import java.util.*;

import common.Go;

public class MovieNetwork implements Go{
	
	public void run() {
		
	}
	
	public List<Integer> getSimilarMovies(int id, int k, Movie movie){
		Queue<Movie> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		PriorityQueue<Movie> pq = new PriorityQueue<>(new Compare());
		q.offer(movie);
		while(!q.isEmpty()) {
			Movie cur = q.poll();
			for(Movie m : cur.neighbors) {
				if(set.contains(m.id)) continue;
				pq.offer(m);
				set.add(m.id);
				q.offer(m);
				if(pq.size() > k) pq.poll();
			}
		}
		while(!pq.isEmpty()) {
			res.add(pq.poll().id);
		}
		return res;
	}
	
    private class Movie {
        int id;
        int rate;
        List<Movie> neighbors;

        public Movie(int id, int rate, List<Movie> neighbors) {
            this.id = id;
            this.rate = rate;
            this.neighbors = neighbors;
        }
    }
    
    private class Compare implements Comparator<Movie>{
    	public int compare(Movie m1, Movie m2) {
    		return m1.rate - m2.rate;
    	}
    }
}
