public class FindingPI {
    public static void main(String[] args){
        System.out.println(getPi(10000));
        System.out.println(getPi(100000));
        System.out.println(getPi(1000000));
        System.out.println(getPi(10000000));
        System.out.println(getPi(100000000));
    }

    public static double getPi(int numPoints){
        int inCircle = 0;
        for(int i=0;i<numPoints;i++){
            // a square with a side of length 2 centered at 0 has x and y range of -1 to 1
            double randX = (Math.random()*2) - 1;
            double randY = (Math.random()*2) - 1;
            //dist from (0,0) = sqrt((x-0)^2 + (y-0)^2)
            double dist = Math.sqrt(randX*randX + randY*randY);
            if(dist<1){
                inCircle++;
            }
        }
        return 4.0 * inCircle / numPoints;
    }
}
