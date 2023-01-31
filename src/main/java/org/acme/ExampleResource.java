package org.acme;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.agroal.api.AgroalDataSource;

@Path("/factorial")
public class ExampleResource {

	@Inject
	AgroalDataSource agroalDataSource;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String factorial() throws SQLException {
		Connection conn= agroalDataSource.getConnection();
		Statement statement =conn.createStatement();
		statement.execute("WITH RECURSIVE tbl_factorial (n, factorial) AS (SELECT 1 as n, 6 as factorial union all SELECT n+1, factorial*n FROM tbl_factorial where n < 6) SELECT * FROM tbl_factorial");
		return "successfull";
         
    }
}