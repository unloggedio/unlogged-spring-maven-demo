package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordPatternController {

    private record Point(int x, int y) {}
    private record Line(Point start, Point end) {}

    @RequestMapping("/points/sum/{x}/{y}")
    public int sumController(@PathVariable int x, @PathVariable int y) {
        Point point = new Point(x, y);
        return sumOfCoordinates(point);
    }

    @RequestMapping("/points/length")
    public int lengthController() {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        return lengthOfLine(line);
    }

    private int sumOfCoordinates(Point point) {
        if (point instanceof Point) {
            Point p = (Point) point;
            return p.x() + p.y();
        }
        return -999;
    }

    private int lengthOfLine(Line line) {
        if (line instanceof Line) {
            Line l = (Line) line;
            return (int) Math.sqrt(Math.pow(l.end().x() - l.start().x(), 2) + Math.pow(l.end().y() - l.start().y(), 2));
        }
        return -999;
    }

    @RequestMapping("/points/equals")
    public boolean equalController() {
        Line line = new Line(new Point(1, 1), new Point(1, 1));
        return checkEqualPoints(line.start(), line.end());
    }

    private boolean checkEqualPoints(Point point1, Point point2) {
        return point1.equals(point2);
    }
}
