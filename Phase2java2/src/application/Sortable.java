package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public  interface Sortable {
    /* The sorting should be based on the number of Martyrs. Keep the original
       family list as it is. */
    public static ArrayList<Family> sortByMartyrs(ArrayList<Family> families) {
        Collections.sort(families, new Comparator<Family>() {
            @Override
            public int compare(Family f1, Family f2) {
                return Integer.compare(f2.getMartyrsCount(), f1.getMartyrsCount()); // descending order
            }
        });
        return families;
    }

    /* The sorting should be based on the number of Orphans. Keep the original
       family list as it is. */
    public static ArrayList<Family> sortByOrphans(ArrayList<Family> families) {
        Collections.sort(families, new Comparator<Family>() {
            @Override
            public int compare(Family f1, Family f2) {
                return Integer.compare(f2.getOrphansCount(), f1.getOrphansCount()); // descending order
            }
        });
        return families;
    }
}