package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable , Defensable{
    private static int hitCount;
    public abstract String getName();
    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;//System.out.println(hitCount);

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
          //  hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        }
        else if (hitCount >= 4) {
            hitCount = 0;
            attackedBodyPart = BodyPart.CHEST;
        }
        return attackedBodyPart;
    }
    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 2; //System.out.println(hitCount);

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
           // hitCount = 0;
            defendedBodyPart = BodyPart.ARM;
        }else if (hitCount >= 4) {
            hitCount = 0;
            defendedBodyPart = BodyPart.CHEST;
        }
        return defendedBodyPart;
    }
}
