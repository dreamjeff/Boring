package am;

import common.Go;
import java.util.*;

public class Find_Top_K_Features implements Go {

//	第一题：Find Top K Features for Amazon kindle，具体点是，根据客户的留言(以feature requests的形式出现)，找Kindle最需要提高的features
//	方法定义：
//	public List<String> findTopFeatures(int numFeatures, List<String> features, int topFeatures, int featureRequest, List<String> featureRequests) {
//	...
//	}
//	where numFeatures is an integer, e,g., numFeatures = 4
//	features is a list of strings, e.g., features = ["battery", "storage", "waterproof", “price”]
//	numTopFeatures is an integer, e.g., topFeature = 2
//	numFeatureRequests is an integer, e.g., numFeatureRequests = 5
//	featureRequests is a list of string, e.g., featureRequsts = ["I hope Amazon Kindle can be waterprool!", "I want a kindle with more storage.", "Waterproof! Kindle needs to be waterproof!", "It will be great if kindle can have better battery performance", "Better  Battery, Kindle needs better battery."]
//
//	根据上面的例子，输出top features = ["waterproof", "battery"].
//	几个edge cases：
//	1. 记得把每个feature request里的标点符号都去掉（看我highlight成红色的地方）。举的例子，Java里这么写，featureRequest.replaceAll("[^a-zA-Z-0-9 ]", "").
//	2. 比较的时候大小写不重要， 举个例子，如果只要waterproof或者Waterproof出现在一个feature request里，都算waterproof这个feature出现了一次。
//	3. 不管一个feature在一个feature request里出现了多少次，都只算出现一次。比如waterproof在"Waterproof! Kindle needs to be waterproof!"出现了两次，在算frequency的时候，只会算一次，因为我们count的是某个feature是否出现在某个feature request里，不是count某个feature request在某个feature request里出现了多少次。这点和李扣 - 流旧二不一样，因为流旧二会care出现了多少次。
//	4. 如果几个features出现在次数一样，就按照字母顺序排列。
//	5. 如果numTopFeatures > numFeatures, 就要返回所有出现的features。举个例子，比如我们只有5个features，但是题目要求我们返回top 7 features，因为最多就只有5个featuers，所以就返回出现过的features就行了，可能是1，2，3，4，5个，取决与有多少个features出现在feature requests里。
//	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<String> features = Arrays.asList("battery","storage","waterproof","price");
		List<String> featureRequests = Arrays.asList("I hope Amazon Kindle can be waterproof!", "I want a kindle with more storage.", "Waterproof! Kindle needs to be waterproof!", "It will be great if kindle can have better battery performance", "Better  Battery, Kindle needs better battery.");
		List<String> res = findTopFeatures(4, features, 2, 5, featureRequests);
		for(String s : res) {
			System.out.println(s);
		}
	}

	public List<String> findTopFeatures(int numFeatures, List<String> features, int topFeatures, int featureRequest, List<String> featureRequests){
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : features) {
			s = s.toLowerCase();
			map.put(s, 0);
		}
		for(String request : featureRequests) {
			request = request.toLowerCase();
			//request.replaceAll("[^a-z0-9]", "");
			for(String feature : features) {
				if(request.indexOf(feature)!=-1) {
					map.put(feature, map.get(feature) + 1);
				}
			}
		}
		PriorityQueue<Feature> q = new PriorityQueue<>(new MyComparator()); 
		for(String key : map.keySet()) {
			Feature f = new Feature(key, map.get(key));
			System.out.println(key + " " + f.num);
			q.add(f);
		}
		List<String> res = new LinkedList<>();
		while(!q.isEmpty() && topFeatures>0) {
			res.add(q.poll().s);
			//topFeatures--;
		}
		return res;
	}

}

class MyComparator implements Comparator<Feature>{

	@Override
	public int compare(Feature o1, Feature o2) {
		// TODO Auto-generated method stub
		return o2.num - o1.num;
	}
	
}

class Feature{
	String s;
	int num;
	public Feature (String s, int num) {
		this.s = s;
		this.num = num;
	}
}
