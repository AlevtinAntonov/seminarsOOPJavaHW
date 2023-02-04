package HW06.chars;

public class Vector2 {
    float x,y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Vector2 opposit){
        if (opposit.y == y && opposit.x == x) return true;
        else return false;
    }

    public float getDistance (float x, float y){
        float dx = x - this.x;
        float dy = y - this.y;

        return (float) Math.sqrt(dx * dx + dy * dy);

    }

    public boolean isEqual(Vector2 pos) {
        if (pos.y == y && pos.x == x) return true;
        return false;
    }
}
