package edu.brandeis.lapps.goldlif;

import org.lappsgrid.serialization.Data;
import org.lappsgrid.serialization.Serializer;

import java.io.InputStream;

/**
 * Program to get gold lif examples, given schema versions as a parameter. <br/>
 * The gold lif files are hand-curated json that contain all possible
 * annotations (and their types) at each version of
 * <a href="http://vocab.lappsgrid.org/schema/">lif schemas</a>.
 *
 */
public class GoldLif {

    private static String latestSchema = "1.1.0";
    private static String goldLifFileBaseName = "lif-all";

    private static String getGoldLifFileName(String schemaVersion) {
        return String.format("%s-%s.lif", goldLifFileBaseName, schemaVersion);
    }

    /**
     * Returns a json string of gold LIF in latest schema
     * @return lif in plain string
     */
    public static String getAsString() {
        return getAsString(latestSchema);
    }

    /**
     * Returns a json string of gold LIF in a given schema version
     * @return lif in plain string
     */
    public static String getAsString(String schemaVersion) {
        InputStream resStream = GoldLif.class.getClassLoader()
                .getResourceAsStream(getGoldLifFileName(schemaVersion));
        java.util.Scanner s = new java.util.Scanner(resStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";

    }

    /**
     * Returns the latest gold LIF wrapped in {@link org.lappsgrid.serialization.Data}
     * @return lif in Data class
     */
    public static Data getAsData() {
        return getAsData(latestSchema);
    }

    /**
     * Returns a gold LIF of a given schema version wrapped in {@link org.lappsgrid.serialization.Data}
     * @return lif in Data class
     */
    public static Data getAsData(String schemaVersion) {
        return Serializer.parse(getAsString(schemaVersion), Data.class);
    }
}
