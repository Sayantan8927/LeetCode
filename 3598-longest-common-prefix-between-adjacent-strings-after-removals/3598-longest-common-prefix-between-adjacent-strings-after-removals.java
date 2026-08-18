class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int i,j,n=words.length;
        int[] curr=new int[n];
        int[] curr2=new int[n];
        int[] pre=new int[n];
        int[] post=new int[n];
        int[] ans=new int[n];
        curr[0]=0;
        for(i=1;i<n;i++){
           curr[i] = Math.max(commonSub(words[i-1],words[i]),curr[i-1]);
            pre[i] = curr[i-1];
        }
        curr2[n-1]=0;
        for(i=n-2;i>=0;i--){
            curr2[i] = Math.max(commonSub(words[i+1],words[i]),curr2[i+1]);
            post[i] = curr2[i+1];
        }
        ans[0]=post[0];
        ans[n-1]=pre[n-1];
        for(i=1;i<n-1;i++){
            ans[i] =Math.max(pre[i],post[i]);
            ans[i] =Math.max(ans[i],commonSub(words[i-1],words[i+1]));
        }

        return ans;
    }

    private int commonSub(String a, String b){
        int i=0,j=0,n=a.length(),m=b.length(),ans=0;
        while(i<n && i<m){
            if(a.charAt(i)==b.charAt(i)) ans++;
            else return ans;
            i++;
        }
        return ans;
    }
}