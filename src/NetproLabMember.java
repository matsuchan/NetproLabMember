import java.util.Random;

public class NetproLabMember {
    public static void main(String args[]){
        int year = 15;
        float percent = 20;
        int[][] column = new int[year][3];
        for(int i=0;i<year;i++){
            //学生数を決める
            Random Rstudent = new Random();
            int student = Rstudent.nextInt(20)-10+110;
            //女性の人数を決める
            float josei = (float)(student * (percent/100));
            //男性の数を求める
            int dansei = (int)(student - josei);
            //配属人数を決める
            Random Rhaizoku = new Random();
            int haizoku = Rhaizoku.nextInt(6)-3+10;
            //配列にそれぞれ代入
            column[i][0] = student;
            column[i][1] = (int)josei;
            column[i][2] = haizoku;
            System.out.println("学生数="+column[i][0]+" 女性数="+column[i][1]+" 配属人数="+column[i][2]);
            //全体から配属される組み合わせ(学生数combination配属人数)
            long r=1;
            long r1 =1;
            int k=1;
            //int r1 = column[i][2];
            for(long j=column[i][0]; j>(column[i][0]-column[i][2]); j--){
                r=r*j;
                r1=r1*k;
                k++;
                System.out.println("j="+j+" r="+r+" r1="+r1);
            }
            long comb_all = (r/r1);

            //男性全体から配属される組み合わせ
            long r2=1;
            long r3 =1;
            int k1=1;
            for(long j=dansei; j>(dansei-column[i][2]); j--){
                r2=r2*j;
                r3=r3*k1;
                k1++;
                System.out.println("j="+j+"r2="+r2+" r3="+r3);
            }
            long comb_men = (r2/r3);

            //男性だけ配属される組み合わせ
            //[学生数]C[配属数]-[男性数]C[配属数]
            //110C10-98C10
            System.out.println("all="+comb_all+" men="+comb_men);
            long danseionly = (comb_all-comb_men);
            System.out.println("danseionly="+danseionly);
            percent += 1;
        }
        System.out.println("owari");
    }
}
