class Candy {
public:
    int candy(vector<int> &ratings) {
        int n=ratings.size();
        if (n==0) return 0;
        if (n==1) return 1;
        vector<int> left(n, 1), right(n,1);
        int res=0;
        for (int i=1; i<n; ++i) {
            if (ratings[i]>ratings[i-1]) left[i]=1+left[i-1];
        }
         
        for (int i=n-2; i>=0; --i) {
            if (ratings[i]>ratings[i+1]) right[i]=1+right[i+1];
        }
         
        for (int i=0; i<n; ++i) res+=max(left[i], right[i]);
         
        return res;
    }
};