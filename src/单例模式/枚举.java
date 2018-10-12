package 单例模式;

import timer.TimerTaskTest;

/**
 * @author Tainy
 * @date 2018/9/17 18:36
 */
public enum 枚举 {

    INSTANCE{};

    private TimerTaskTest timerTaskTest;

    private 枚举(){
        timerTaskTest = new TimerTaskTest();
    }

    public TimerTaskTest getTimerTaskTest() {
        return timerTaskTest;
    }
}
