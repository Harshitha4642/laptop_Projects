class Reverse {
    public static int reverse(int x) {
        int r=0,n=x,sum=0, flag=0;
        if(x<0){
            flag = 0;
            n=0-n;
        }
        else{
            flag=1;
        }
            while(n>0)
            {
                r=n%10;
                sum = sum*10+r;
                System.out.println(sum);
                n=n/10;
            }
        //System.out.println(sum);
        if(sum>=Math.pow(2, 31)-1 || sum<=-Math.pow(2,31))
        {
            return 0;
        }
        if(flag==1)
            return sum;
        else
        return 0-sum;
    }

    public static void main(String [] args)
    {
        System.out.println(reverse(1534236469));
        System.out.println(Math.pow(2,31));
        
    }
}