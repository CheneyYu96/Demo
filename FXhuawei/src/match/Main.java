package match;

import java.util.*;

/**
 * Created by yuminchen on 16/4/19.
 */
public class Main {
    /**
     * the count of group
     */
    int groupCnt;

    /**
     * a list for group
     */
    List<Group> groups;

    /**
     * read what inputs from console
     */
    public void readInput(){
        Scanner cin = new Scanner(System.in);
        if (cin.hasNext()){
            groupCnt = cin.nextInt();
        }

        groups = new ArrayList<>();
        int blackNum = 0;
        int whiteNum = 0;
        for(int i = 0; i<groupCnt;i++){
            Group group = new Group();
            if(cin.hasNext()){
                blackNum = cin.nextInt();
            }
            if(cin.hasNext()){
                whiteNum = cin.nextInt();
            }
            int x = 0;
            int y = 0;
            for(int j = 0; j<blackNum;j++){
                x = cin.nextInt();
                y = cin.nextInt();
                Point tmp = new Point(x,y);
                group.addToBlackPoints(tmp);

            }
            for(int j = 0; j<whiteNum;j++){
                x = cin.nextInt();
                y = cin.nextInt();
                Point tmp = new Point(x,y);
                group.addToWhitePoints(tmp);

            }
            groups.add(group);
        }

    }

    /**
     * to system out the max number of pathes orderly
     */
    public void getMaxMatches(){
        for(int i = 0; i<groupCnt;i++){
            System.out.println(groups.get(i).findMaxMatch());
        }
    }

    class Group{
        List<Point> whitePoints;
        List<Point> blackPoints;
        int[][] pathes;
        int[] whiteUsed;
        int[] blackUsed;
        int[] match;

        public Group() {
            whitePoints = new ArrayList<>();
            blackPoints = new ArrayList<>();
        }

        public void addToBlackPoints(Point point){
            blackPoints.add(point);
        }

        public void addToWhitePoints(Point point){
            whitePoints.add(point);
        }

        /**
         * find the max number of match
         * @return
         */
        public int findMaxMatch(){
            int count = 0;
            // establish the graph
            pathes = new int[blackPoints.size()][whitePoints.size()];

            whiteUsed = new int[whitePoints.size()];

            blackUsed = new int[blackPoints.size()];

            match = new int[whitePoints.size()];

            for(int i = 0;i<blackPoints.size();i++){
                blackUsed[i] = 0;

            }
            for(int i = 0;i<whitePoints.size();i++){
                whiteUsed[i] = 0;
                match[i] = -1;

            }

            for(int i = 0;i<blackPoints.size();i++){
                for(int j = 0;j<whitePoints.size();j++){
                    if(whitePoints.get(j).isBigger(blackPoints.get(i))){
                        pathes[i][j] = 1;
                    }
                    else{
                        pathes[i][j] = 0;
                    }

                }

            }

            for(int i = 0;i<blackPoints.size();i++){
                if(DFS(i)){
                    count++;
                }
            }
            return count;

        }

        public boolean DFS(int index){
            for(int i = 0 ;i<whitePoints.size();i++){
                if(pathes[index][i]==1&&whiteUsed[index]==0){
                    whiteUsed[index] = 1;
                    if(match[i]==-1||DFS(match[i])){
                        match[i] = index;
                        return true;
                    }
                }
            }
            return false;
        }


    }


    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isBigger(Point point){
            if(this.x>=point.x&&this.y>=point.y){
                return true;
            }
            return false;

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readInput();
        main.getMaxMatches();
    }
}
