package com.makePicture;

import com.birdbrain.Finch;

public class CreatorFinch extends Finch {

    public CreatorFinch(String device) {
        super(device);
    }

    public void test() {
        setMove("F", 10, 100);
    }

    public void navigate() {
        int i = 0;
        while (i == 0) {
            if (canMove()) {
                moveForward();
                scootBack();
            } else {
                setTurn("L", 90, 100);
                if (canMove()) {
                    moveForward();
                    scootBack();
                } else {
                    setTurn("L", 180, 100);
                    if (canMove()) {
                        moveForward();
                        scootBack();
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public void moveForward() {
        setMove("F", getDistance() - 4, 100);
    }

    public boolean canMove() {
        return getDistance() > 12;
    }

    public void scootBack() {
        if (getDistance() < 3) {
            setMove("B", 4, 100);
        }
    }

}