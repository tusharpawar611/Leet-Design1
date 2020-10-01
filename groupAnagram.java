class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<Long,LinkedList<String>> map = new HashMap<>();

        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        for(String st : strs){

            int prod = findProd(st);

            if(!map.containsKey(prod)){
                map.put(prod,new ArrayList<String>());
            }

            map.get(prod).add(st);
        }

        return new ArrayList<>(map.values());
    }
    public int findProd(String str){
        int [] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,67,71,73,79,83,89,97,101,103};
        long prod =1;
        for(char ch : str.toCharArray()){
       prod = prod*prod[ch-'a'];
        }
        return prod;
    }
}