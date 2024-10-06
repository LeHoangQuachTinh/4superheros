import java.util.Scanner;

public class Bai6 {
    static int [] M;
    static int N;
    static Scanner sc= new Scanner(System.in);
    static void Nhap(){
        for (int i = 0; i< N; i++)
        {
            System.out.print("Nhap phan tu thu "+(i+1)+": ");
            M[i]=sc.nextInt();
        }
    }
    static void In()
    {
        for(int i = 0; i < N; i++)
        {
            System.out.print(+M[i]+" ");
        }
    }
    static int Tim(int x)
    {
        int Vitri = 0;
        boolean found = false;
        for (int i = 0; i < N && !found; i++)
        {
            if(M[i]==x)
            {
                found = true;
                Vitri = i;
            }
        }
        return Vitri;
    }
    static void Xoa(int x)
    {
        int K = Tim(x);
        for (int i = K; i< N-1; i++)
            M[i] = M[i+1];
        M[N-1]=0;
        N--;    
    }
    static void Them(int x, int m)
    {
        if(m<0 && m>M.length)
            System.out.println("Nhap vi tri khong hop le!");
        N++;
        for (int i = N-1; i>m; i--)
            M[i]=M[i-1];
        M[m]=x;
    }
    public static void main(String[] args) {
        System.out.println("Nhap so phan tu cua mang: ");
        N = sc.nextInt();
        M = new int[N];
        Nhap();
        System.out.print("Mang ban dau: ");
        In();
        System.out.print("\nNhap so muon xoa: ");
        int x = sc.nextInt();
        Tim(x);
        Xoa(x);
        System.out.print("Mang sau khi xoa : ");
        In();
        System.out.print("\nNhap so muon them: ");
        int y = sc.nextInt();
        System.out.print("Nhap vi tri muon them: ");
        int z = sc.nextInt();
        Them(y, z);
        System.out.print("Mang sau khi them la: ");
        In();

        
    }    
}
