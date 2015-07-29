package omnify.usecase.graphicimage;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.omnifaces.util.Faces;

/**
 *
 * @author Constantin Alin
 */
@Named
@ApplicationScoped
public class ByteImageBean {

	private final String IMAGE = "http://localhost:8080/GraphicImage_2/ByteServlet";

	public InputStream imageAsInputStreamFromServlet() {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(IMAGE);
			CloseableHttpResponse response = httpclient.execute(httpget);
			return response.getEntity().getContent();
		} catch (IOException ex) {
			Logger.getLogger(ByteImageBean.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	public InputStream imageAsInputStreamFromFolder() {
		return Faces.getResourceAsStream("/resources/default/images/img_all.png");
	}

	public InputStream imageAsInputStreamFromServletRnd(String id) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(IMAGE + "?id=" + id);
			CloseableHttpResponse response = httpclient.execute(httpget);
			return response.getEntity().getContent();
		} catch (IOException ex) {
			Logger.getLogger(ByteImageBean.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	public InputStream imageAsInputStreamFromFolderRnd(String id) {
		return Faces.getResourceAsStream("/resources/default/images/img_" + id + ".png");
	}

}
