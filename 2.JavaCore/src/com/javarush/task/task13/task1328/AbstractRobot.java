package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable {

    private static int hitCount;
    private String name;

    public String getName() {
        return name;
    }

    public AbstractRobot(String name) {
        this.name = name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 4) {
            attackedBodyPart = BodyPart.ARM;
            hitCount = 0;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
//            hitCount = 0;
        }
        else if (hitCount == 1){
            attackedBodyPart = BodyPart.CHEST;

        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
//            hitCount = 0;
        }
        else if (hitCount == 4){
            defendedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        return defendedBodyPart;
    }
}
