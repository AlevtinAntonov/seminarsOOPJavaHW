package HW05.chars;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public abstract class UnitBase implements InterfaceHero {
    protected int attack, protect, maxHealth, speed;
    protected float health;
    protected int[] damage;
    protected String name, role;
    protected List<UnitBase> gang;
    protected Vector2 position;
    protected String status;


    public UnitBase(int attack, int protect, int[] damage, int maxHealth, int speed, String name,
                    String role, String status) {
        this.attack = attack;
        this.protect = protect;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.speed = speed;
        this.name = name;
        this.role = role;
        this.status = status;
        this.health = maxHealth;

    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public List<UnitBase> getGang() {
        return gang;
    }

    public String getStatus() {
        if (health <= 0) {
            this.status = "Died";
        } else {
            this.status = status;
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() { return role;}


    public int getAttack() {
        return attack;
    }

    protected void getDamage(float attackPower) {
        this.health -= attackPower;
        if (this.health <= 0 ) {
            this.health = 0;

        } else if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void getDistance(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        String outStr;
        outStr = format("%s\t%s\t⚔%d\t\uD83D\uDEE1%d\t❤:%d / %d\t\uD83E\uDD15%d\t\uD83C\uDFC3%d",
                role, name, attack, protect,maxHealth, (int) health, (damage[0] + damage[1]) / 2, speed);
        return  outStr;
    }

    @Override
    public String getMaxLost() {
        return role + " " + String.valueOf(maxHealth) + " " + String.valueOf(health);
    }

    @Override
    public String toString() {
        return name +
               ", role=" + role +
               ", attack=" + attack +
               ", defence=" + protect +
               ", damage=" + Arrays.toString(damage) +
               ", maxHealth=" + maxHealth +
               ", health=" + health +
               ", speed=" + speed +
               ", status=" + status;
    }

    public Vector2 getPosition() {
        return position;
    }
}
