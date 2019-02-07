[489. Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/)

```
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
/*
    0
3       1
    2
*/
class Solution {
    HashSet<List<Integer>> hs = new HashSet();
    int[][] movement = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public void cleanRoom(Robot robot) {
        DFS(robot, 0, new int[]{0, 0});
    }
    public int DFS(Robot robot, int currentDirection, int[] pos)
    {
        List<Integer> key = Arrays.asList(pos[0], pos[1]);
        if(hs.contains(key)) 
        {
            return currentDirection;
        }
        else
        {
            hs.add(key);
        }
        robot.clean();
        for(int i = 0; i < 4; i ++)
        {
            setDirection(robot, i, currentDirection);
            currentDirection = i;
            if(robot.move())
            {
                pos[0] += movement[i][0];
                pos[1] += movement[i][1];
                currentDirection = DFS(robot, currentDirection, pos);
                // return to current direction;
                pos[0] -= movement[i][0];
                pos[1] -= movement[i][1];
                int reverseDirection = reverse(i);
                setDirection(robot, reverseDirection, currentDirection);
                currentDirection = reverseDirection;
                robot.move();
            }
        }
        return currentDirection;
    }
    public int reverse(int d)
    {
        if(d == 0) return 2;
        else if(d == 2) return 0;
        else if(d == 3) return 1;
        else return 3;
    }
    public void setDirection(Robot robot, int destinationDirection, int currentDirection)
    {
        int turnRight = destinationDirection - currentDirection;
        if(turnRight == 0) return;
        else if(turnRight > 0) for(int i = 0; i < turnRight; i ++) robot.turnRight();
        else for(int i = 0; i < -turnRight; i ++) robot.turnLeft();
    }
}
```
