
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matheus.oliveira
 */

public class ComparatorTime implements Comparator<Runner> {
    @Override
    public int compare(Runner o1, Runner o2) {
        return o1.getLapTime().compareTo(o2.getLapTime());
    }
}