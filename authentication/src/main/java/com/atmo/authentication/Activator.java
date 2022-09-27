package com.atmo.authentication;

import com.atmo.authentication.view.StudentView;
import com.atmo.database.connection.DatabaseConnection;
import com.atmo.studentrecord.controller.StudentRestControllerImpl;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.Map;

/**
 * <p>
 * Activates the server that an API needs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
@Component(immediate = true)
public class Activator {

    public static Bundle bundle;
    private Server server;

    /**
     * <p>
     * Sets the address,provides the file format and implemented the API. Created a endpoints in the server using the bean.
     * </p>
     *
     * @param context Used to grant access to other methods so that this bundle can interact with the Framework.
     */
    @Activate
    public void activate(BundleContext context) {

        try {
            final JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/record");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new StudentRestControllerImpl());

            server = bean.create();
            bundle = context.getBundle();

            StudentView.selectChoice();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * <p>
     * Deactivates the API server to shut down.
     * </p>
     */
    @Deactivate
    public void deactivate() {
        try {

            if (server != null) {
                server.destroy();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}