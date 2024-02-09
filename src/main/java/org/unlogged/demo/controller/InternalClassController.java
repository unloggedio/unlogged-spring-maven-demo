package org.unlogged.demo.controller;

import lombok.Getter;

public class InternalClassController {

    class Xe {
        @Getter
        private int y = 4;
        private Xe subInstance = new Xe();

        public int methodE() {
            return subInstance.y;
        }

        public int methodE2() {
            return subInstance.getY();
        }
    }
}
