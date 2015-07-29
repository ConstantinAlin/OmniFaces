package omnify.usecase.graphicimage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Utils;

/**
 *
 * @author Constantin Alin
 */
@Named
@ApplicationScoped
public class ByteImageBean {

	private final String IMAGE = "http://localhost:8080/GraphicImage_1/ByteServlet";

	public byte[] imageAsByteArrayFromServlet() {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(IMAGE);
			try (CloseableHttpResponse response = httpclient.execute(httpget)) {
				return Utils.toByteArray(response.getEntity().getContent());
			}
		} catch (IOException ex) {
			Logger.getLogger(ByteImageBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public byte[] imageAsByteArrayFromFolder() {
		try {
			return Utils.toByteArray(Faces.getResourceAsStream("/resources/default/images/img_all.png"));
		} catch (IOException ex) {
			Logger.getLogger(ByteImageBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public byte[] imageAsByteArrayFromServletRnd(String id) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(IMAGE + "?id=" + id);
			try (CloseableHttpResponse response = httpclient.execute(httpget)) {
				return Utils.toByteArray(response.getEntity().getContent());
			}
		} catch (IOException ex) {
			Logger.getLogger(ByteImageBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public byte[] imageAsByteArrayFromFolderRnd(String id) {
		try {
			return Utils.toByteArray(Faces.getResourceAsStream("/resources/default/images/img_" + id + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(ByteImageBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
