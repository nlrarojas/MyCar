package util;

public interface IConstants {
    public static int WIDTH_WINDOW = 935;
    public static int HEIGHT_WINDOW = 530;
    
    public static int MAXIMUM_REVOLUTIONS = 3500;
    public static double RADIAN_PER_SECOND = (2 * Math.PI) / 60;
    
    public static int PENALTY_POINTS = 5;
    public final int MAX_THREADS = 5;
    
    public final double[] MAX_VELOCITY = {0, 12.83333, 19.97222, 28.96111, 38.61666, 49.43333};
    public final double[] MAX_RPM = {0, 430.64, 672, 974.4, 1299.3, 1663.2};
    
    public static String NONE_INSTRUCTION = "NONE_INSTRUCTION";
    
    public static String TURN_LEFT = "TURN_LETF";
    public static String TURN_RIGTH = "TURN_RIGHT";
        
    public static String SLOW_DOWN_ENGINE = "SLOW_DOWN_ENGINE";
    public static String SPEED_UP_ENGINE = "SPEED_UP_ENGINE";
        
    public static String GEAR_DOWN = "GEAR_DOWN";
    public static String GEAR_UP = "GEAR_UP";
        
    public static String SHUTDOWN_LIGTHS = "SHUTDOWN_LIGTHS";
    public static String START_LIGTHS = "START_LIGTHS";
        
    public static String STOP_WINDSHIELD = "STOP_WINDSHIELD";
    public static String START_WINDSHIELD = "START_WINDSHIELD";
}