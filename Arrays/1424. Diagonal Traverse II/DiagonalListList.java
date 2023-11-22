class l {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> diag = new ArrayList();
        int count = 0;
        for(int i = 0; i<nums.size(); i++) {
            count+=nums.get(i).size();
            for(int j = 0; j < nums.get(i).size(); j++) {
                if(diag.size()==i+j) {
                    diag.add(new ArrayList());
                }
                diag.get(i+j).add(nums.get(i).get(j));
            }
        }
      
        int[] result = new int[count];
        count=0; 
        for(int i = 0; i<diag.size(); i++) {
            for(int j = diag.get(i).size()-1; j>=0; j--) {
                result[count++]= diag.get(i).get(j);
            }
        }
        return result;
    }
}
