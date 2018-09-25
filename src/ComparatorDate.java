
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
public class ComparatorDate implements Comparator<Runner> {
    @Override
    public int compare(Runner r1, Runner r2) {
        return r1.getLapDate().compareTo(r2.getLapDate());
    }
}