package usecase.resourceinclude;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class TextServletBean {

	public String callServlet(String servletName) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet("http://localhost:8080/UseCase_ResourceInclude_1/" + servletName);
			try (CloseableHttpResponse response = httpclient.execute(httpget)) {

				System.out.println(response.getProtocolVersion());
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(response.getStatusLine().getReasonPhrase());
				System.out.println(response.getStatusLine().toString());

				return EntityUtils.toString(response.getEntity());
			}
		} catch (IOException ex) {
			Logger.getLogger(TextServletBean.class.getName()).log(Level.SEVERE, null, ex);
		}

		return "Sorry, no servlet was called !!!";
	}

}
