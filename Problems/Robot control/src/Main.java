class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int differenceX = robot.getX() - toX;
        int differenceY = robot.getY() - toY;
        if (differenceX > 0) {
            rotateLeft(robot);
        } else {
            rotateRight(robot);
        }
        goForwardNStep(robot, Math.abs(differenceX));
        if (differenceY > 0) {
            rotateDown(robot);
        } else {
            rotateUp(robot);
        }
        goForwardNStep(robot, Math.abs(differenceY));
    }

//    public static void main(String[] args) {
//        Direction direction = Direction.RIGHT;
//        Robot robot = new Robot(14, -78, direction);
//        moveRobot(robot, 32, 96);
//        System.out.println("end");
//    }

    private static void rotateLeft(Robot robot) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnLeft();
                break;
            case DOWN:
                robot.turnRight();
                break;
            case RIGHT:
                robot.turnRight();
                robot.turnRight();
                break;
            default:
        }
    }

    private static void rotateRight(Robot robot) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnRight();
                break;
            case DOWN:
                robot.turnLeft();
                break;
            case LEFT:
                robot.turnRight();
                robot.turnRight();
                break;
            default:
        }
    }

    private static void goForwardNStep(Robot robot, int countSteps) {
        for (int i = 0; i < countSteps; i++) {
            robot.stepForward();
        }
    }

    private static void rotateDown(Robot robot) {
        switch (robot.getDirection()) {
            case RIGHT:
                robot.turnRight();
                break;
            case LEFT:
                robot.turnLeft();
                break;
            case UP:
                robot.turnRight();
                robot.turnRight();
                break;
            default:
        }
    }

    private static void rotateUp(Robot robot) {
        switch (robot.getDirection()) {
            case RIGHT:
                robot.turnLeft();
                break;
            case LEFT:
                robot.turnRight();
                break;
            case DOWN:
                robot.turnRight();
                robot.turnRight();
                break;
            default:
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}