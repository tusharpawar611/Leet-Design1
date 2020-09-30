
class pair<K, V> {
	K key;
	V value;

	pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

}

class Bucket {

	private List<pair<Integer, Integer>> bucket;

	Bucket() {
		this.bucket = new LinkedList<pair<Integer, Integer>>();
	}

	public Integer get(Integer key) {
		for (pair<Integer, Integer> i : this.bucket) {
			if (i.key.equals(key)) {
				return i.value;
			}
		}
		return -1;
	}

	public void update(Integer key, Integer value) {
		boolean found = false;
		for (pair<Integer, Integer> i : this.bucket) {
			if (i.key.equals(key)) {
				found = true;
				i.value = value;
			}
		}
		if (!found) {
			this.bucket.add(new pair(key, value));
		}
	}

	public void remove(Integer key) {
		for (pair<Integer, Integer> i : this.bucket) {
			if (i.key.equals(key)) {
				this.bucket.remove(i);
				break;
			}
		}
	}
}

class hashMap {

	private int k;
	private List<Bucket> bucket_list;

	/** Initialize your data structure here. */
	public hashMap() {
		this.k = 2003;
		this.bucket_list = new ArrayList<Bucket>();
		for (int i = 0; i < this.k; i++) {
			this.bucket_list.add(new Bucket());
		}
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {

		int hash = key % this.k;
		this.bucket_list.get(hash).update(key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash = key % this.k;
		return this.bucket_list.get(hash).get(key);
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash = key % this.k;
		this.bucket_list.get(hash).remove(key);
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */