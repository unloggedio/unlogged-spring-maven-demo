package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.sealed.*;

@RestController
@RequestMapping("/sealed")
public class SealedOpsController {

    public Shape shapeSerial() {
        return new Shape();
    }

    public Square getSquare() {
        return new Square(1);
    }

    public Rectangle getRectangle() {
        return new Rectangle(1, 1);
    }

    public FilledRectangle getFilledRectangle() {
        FilledRectangle fr = new FilledRectangle(1, 1);
        fr.setBlue(1);
        fr.setGreen(1);
        fr.setRed(1);
        return fr;
    }

    @RequestMapping("/rectFromFilled")
    public Rectangle getRectFromFilled() {
        Rectangle temp = getFilledRectangle();
        return temp;
    }

    public Circle getCircle() {
        return new Circle(2.0f);
    }
}
