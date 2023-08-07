package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        long newShot = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
        switch (shot.charAt(0)) {
            case 'A':
                break;
            case 'B': {
                newShot >>>= 1;
                break;
            }
            case 'C': {
                newShot >>>= 2;
                break;
            }
            case 'D': {
                newShot >>>= 3;
                break;
            }
            case 'E': {
                newShot >>>= 4;
                break;
            }
            case 'F': {
                newShot >>>= 5;
                break;
            }
            case 'G': {
                newShot >>>= 6;
                break;
            }
            case 'H': {
                newShot >>>= 7;
                break;
            }
        }
        newShot >>>= (8 * (shot.charAt(1) - 1));
        shots |= newShot;
        return ships == (ships | newShot);
    }

    public String state() {
        String ships = Long.toBinaryString(this.ships);
        String shots = Long.toBinaryString(this.shots);
        StringBuilder sb = new StringBuilder();

        if (shots.length() < 64) {
            sb.append("0".repeat(64 - shots.length()));
            shots = sb.append(shots).toString();
            sb.delete(0, sb.length());
        }
        if (ships.length() < 64) {
            sb.append("0".repeat(64 - ships.length()));
            ships = sb.append(ships).toString();
            sb.delete(0, sb.length());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shots.length(); i++) {
            if (i % 8 == 0)
                result.append("\n");
            if (ships.charAt(i) == '0' && shots.charAt(i) == '0')
                result.append(".");
            if (ships.charAt(i) == '0' && shots.charAt(i) == '1')
                result.append("×");
            if (ships.charAt(i) == '1' && shots.charAt(i) == '0')
                result.append("☐");
            if (ships.charAt(i) == '1' && shots.charAt(i) == '1')
                result.append("☒");
        }
        return result.toString();
    }

}
