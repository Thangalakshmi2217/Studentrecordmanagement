package com.atmo.database.connection;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * <p>
 * Establishes the database {@link java.sql.Connection} using the properties.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
@Component(immediate = true, name = "database")
public class DataBaseProperty {

    /**
     * <p>
     * Properties which holds the necessary information for the database connection
     * </p>
     *
     * @param properties which contains the connection attributes which connects the database
     */
    @Activate
    public void activate(Map<String, String> properties) {
        DatabaseConnection.setDataBaseProperty(properties);
    }
}
