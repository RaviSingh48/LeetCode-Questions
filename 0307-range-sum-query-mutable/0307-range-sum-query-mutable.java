class NumArray {

    int n ;
    int[] st;   // segment tree
    int[] nums;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums; 
        this.st = new int[4*n];
        build(0, 0, n-1);
    }
    
    public void update(int index, int val) {
        pointUpdate(0, 0, n-1, index, val);
        List<Integer> list = new ArrayList<>();
    }
    
    public int sumRange(int left, int right) {
        return query(0,0, n-1, left, right);
    }

    private void build(int index, int low, int high){
        if(low == high){
            st[index] = nums[low];
            return;
        }
        int mid = (low + high)/2;
        build(2*index+1, low, mid);
        build(2*index+2, mid+1, high);

        st[index] = st[2*index + 1] + st[2*index + 2];
    }

    private int query(int index, int low, int high, int l, int r){
        if(low >= l && high <= r){
            return st[index];
        }
        if(low > r || high < l){
            return 0;
        }
        int mid = low + (high - low)/2;
        int left_result = query(2*index+1, low, mid, l, r);
        int right_result = query(2*index + 2, mid+1, high, l,r);
        return left_result + right_result;
    }

    private void pointUpdate(int index, int low, int high, int node,int val){
        if(low == high){
            st[index] = val;
            nums[node] = val;
            return;
        }
        else{
        int mid = low + (high - low)/2;
            if(node <= mid && node >= low){
                pointUpdate(2*index + 1, low,  mid, node, val);
            }
            else{
                pointUpdate(2*index + 2, mid +1, high, node, val);
            }
            st[index] = st[2*index +1] + st[2*index +2] ;
        }
    }

}