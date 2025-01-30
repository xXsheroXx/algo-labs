import java.util.ArrayList;

public class uppgift1 {
    public static void main(String[] args) {
        int r=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n=1;n<=40;n++) {
            for(int i=1;i<=n;i++)
                for(int j=1;j<=i;j++)
                    for(int k=j;k<=i+j;k++)
                        for(int m=1;m<=i+j-k;m++)
                            r++;
            list.add(r);
            r = 0;
        }
        System.out.println(list);
    }
}