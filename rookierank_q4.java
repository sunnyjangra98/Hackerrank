package hackerrank_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class rookierank_q4 {
    public static class point{
        private int x;
        private int y;
        private int level;

        public point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level=level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int ans[][] = new int [n-1][n-1];
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-1;j++)
                ans[i][j]=-2;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(ans[i][j]==-2){
                    int x = find(i+1,j+1);
                    ans[i][j]=x;
                    ans[j][i]=x;
                }
            }
        }
//        System.out.print(find(2,1));
        for(int i=0;i<n-1;i++) {
            for (int j = 0; j < n - 1; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int find(int p, int q) {
        int visited[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                visited[i][j]=-1;
        ArrayList<Integer> adj = new ArrayList<>();
        if(p==q){
            int [] movex = new int[4];
            int [] movey = new int[4];
            movex[0]=p;
            movex[1]=p;
            movex[2]=-p;
            movex[3]=-p;
            movey[0]=p;
            movey[1]=-p;
            movey[2]=p;
            movey[3]=-p;
//            System.out.println(movex.toString()+"\n"+movey.toString());
            return bfs(movex,movey,visited,new point(0,0,0));

        }
        else{
            int [] movex = new int[8];
            int [] movey = new int[8];
            movex[0]=p;
            movex[1]=q;
            movex[2]=q;
            movex[3]=p;
            movex[4]=-p;
            movex[5]=-q;
            movex[6]=-q;
            movex[7]=-p;
            
            movey[0]=q;
            movey[1]=p;
            movey[2]=-p;
            movey[3]=-q;
            movey[4]=-q;
            movey[5]=-p;
            movey[6]=p;
            movey[7]=q;

            return bfs(movex,movey,visited,new point(0,0,0));
            
        }


    }

    private static int bfs(int[] movex, int[] movey, int[][] visited,point source) {

        LinkedList<point> queue = new LinkedList<>();
        queue.add(source);
        visited[source.getX()][source.getY()]=0;
        int counter=1;
        boolean flag=false;
        while(queue.size()>0 && visited[n-1][n-1]==-1){
            point s = queue.poll();
//            System.out.println(s.getX()+" "+ s.getY());
            flag=false;
            for(int i=0;i<movex.length;i++){
//                System.out.print(s.getX()+movex[i]+" ");
//                System.out.print(s.getY()+movey[i]);
//                System.out.println();

                if(isSafe(s.getX()+movex[i],s.getY()+movey[i],visited)){
                    queue.add(new point(s.getX()+movex[i],s.getY()+movey[i],s.level+1));
                    visited[s.getX()+movex[i]][s.getY()+movey[i]]=s.level+1;
                    if(!flag)
                    {
                        flag=true;
                    }
                }
            }

//            print(visited);
            if(flag)
                counter++;
        }
        return visited[n-1][n-1];
    }

    private static void print(int[][] visited) {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n \n");
    }

    private static boolean isSafe(int x, int y, int[][] visited) {
        if(x>=0&&x<n&&y>=0&&y<n){
            if(visited[x][y]==-1)
                return true;
            return false;
        }
        return false;
    }
}