class TimeMap {

// hashmap + heap
    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timesmap = map.getOrDefault(key, null);
        if (timesmap == null) return "";
        Integer timekey = timesmap.floorKey(timestamp);
        if (timekey == null) return "";
        return timesmap.get(timekey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/*class TimeMap {

    // hashmap + treemap
    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>(Collections.reverseOrder()));
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (map.get(key).get(timestamp) != null) {
            return map.get(key).get(timestamp);
        }
        for (int time : map.get(key).keySet()) {
            if (time <= timestamp) return map.get(key).get(time);
        }
        return "";
    }
    public class ValueTime {
        String value;
        int timestamp;
        public ValueTime(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}*/
