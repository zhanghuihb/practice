package 序列化和反序列化实现克隆;

import java.io.Serializable;

/**
 * @author Tainy
 * @date 2018/10/22 13:17
 */
public class Car implements Serializable{

    private String brand;// 品牌

    private int maxSpeed;// 最高时速

    public Car() {

    }

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
    }
}
