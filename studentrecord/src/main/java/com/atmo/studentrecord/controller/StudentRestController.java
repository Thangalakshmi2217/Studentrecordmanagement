package com.atmo.studentrecord.controller;

import com.atmo.studentrecord.model.Student;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <p>
 * Interface that provides an API service.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public interface StudentRestController {

    /**
     * <p>
     * Checks whether the student details were inserted using the API.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the student details were inserted
     */
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    boolean insertStudentDetails(final Student student);

    /**
     * <p>
     * Checks whether the student details were deleted using the API.
     * </p>
     *
     * @param rollNumber represents the rollNumber of the student
     * @return true when the student details were deleted
     */
    @Path("/{rollNumber}")
    @DELETE
    boolean deleteStudentDetails(@PathParam("rollNumber") final String rollNumber);

    /**
     * <p>
     * Checks whether the student details were updated using the API.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the student details were updated
     */
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    boolean updateStudentDetails(final Student student);

    /**
     * <p>
     * Checks whether all the student details can be obtained using API.
     * </p>
     *
     * @return the {@link List}
     */
    @Path("/allStudent")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    List<Student> getAllStudents();

    /**
     * <p>
     * Checks whether the particular student details can be selected.
     * </p>
     *
     * @param rollNumber represents the student's rollNumber
     * @return the specific student details
     */
    @Path("/{rollNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    Student selectStudentDetail(@PathParam("rollNumber") final String rollNumber);
}
